package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;

import java.util.List;

public class Camera {

    private static final String TFOD_MODEL_ASSET = "FreightFrenzy_BCDM.tflite";
    private static final String[] LABELS = {
            "Ball",
            "Cube",
            "Duck",
            "Marker"
    };

    private static final String VUFORIA_KEY =
            " AV5DiRv/////AAABmQQY+qA6hk+yvs2h+C9m7O0RUTsHHsO90qj9c2c7U2NiWAGSvnLjTlL5NWFlyOcqHjqMAk4UNRsDPhS15hb3argJVORiC7ra0KqgkIGfaOcujDTpGtpWrcvnKS1bvM2UIhpLjy20Do5TPt2HRhfEo3MqDFehYGpA48mYCLEbBL4mhl1RdCZYAWHbsZgYTbyOzieaEvwcjSYHJDV+sQUkqzRrHXQx6OZtDtz9BkZalvvJa+pGGhBhN9PEXwZkU6gfon3LRZS8NJv84Az5/dsHvCNwdNpaFTyW62emm5+Q9Nf9iIgkH9b7Wk4b7RbYL3SdAr9PzWeSVi0DxZ2HIkyroAReM8UAwfq75HQdNXQq6hRB";

    private VuforiaLocalizer vuforia;

    private TFObjectDetector tfod;
    private Telemetry telemetry;
    private HardwareMap hardwareMap;
    private LinearOpMode linearOpMode;

    public Camera(HardwareMap hardwareMap, Telemetry telemetry, LinearOpMode linearOpMode) {
        init(hardwareMap, telemetry, linearOpMode);
    }

    private void init(HardwareMap hardwareMap, Telemetry telemetry, LinearOpMode linearOpMode) {
        this.telemetry = telemetry;
        this.linearOpMode = linearOpMode;
        this.hardwareMap = hardwareMap;
        initVuforia();
        initTfod();

    }

    public String seeDucks() {
        if (tfod != null) {
            tfod.activate();

            // The TensorFlow software will scale the input images from the camera to a lower resolution.
            // This can result in lower detection accuracy at longer distances (> 55cm or 22").
            // If your target is at distance greater than 50 cm (20") you can adjust the magnification value
            // to artificially zoom in to the center of image.  For best results, the "aspectRatio" argument
            // should be set to the value of the images used to create the TensorFlow Object Detection model
            // (typically 16/9).
            tfod.setZoom(2.5, 16.0/9.0);
        }

        List<Recognition> updatedRecognitions = null;

        if (linearOpMode.opModeIsActive()) {
            long targetTime = System.currentTimeMillis() + 3750;
            while (linearOpMode.opModeIsActive() &&
            System.currentTimeMillis() < targetTime
                    && (updatedRecognitions == null || updatedRecognitions.size() == 0)) {

                if (tfod != null) {

                    // getUpdatedRecognitions() will return null if no new information is available since
                    // the last time that call was made.
                    updatedRecognitions = tfod.getUpdatedRecognitions();
                    if (updatedRecognitions != null) {
                        telemetry.addData("# Object Detected", updatedRecognitions.size());

                        // step through the list of recognitions and display boundary info.
                        int i = 0;
                        for (Recognition recognition : updatedRecognitions) {
                            telemetry.addData(String.format("label (%d)", i), recognition.getLabel());
                            telemetry.addData(String.format("  left,top (%d)", i), "%.03f , %.03f",
                                    recognition.getLeft(), recognition.getTop());
                            telemetry.addData(String.format("  right,bottom (%d)", i), "%.03f , %.03f",
                                    recognition.getRight(), recognition.getBottom());
                            i++;
                        }
                        telemetry.update();
                    }
                }
            }
        }
        if (updatedRecognitions == null) {
            return "No Ducks";
        }
        return updatedRecognitions.get(0).getLabel();
    }

    private void initVuforia() {
        /*
         * Configure Vuforia by creating a Parameter object, and passing it to the Vuforia engine.
         */
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;

        //  Instantiate the Vuforia engine
        vuforia = ClassFactory.getInstance().createVuforia(parameters);

        // Loading trackables is not necessary for the TensorFlow Object Detection engine.
    }

    /**
     * Initialize the TensorFlow Object Detection engine.
     */
    private void initTfod() {
        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
                "tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        tfodParameters.minResultConfidence = 0.8f;
        tfodParameters.isModelTensorFlow2 = true;
        tfodParameters.inputSize = 320;
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
        tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABELS);
    }
}
