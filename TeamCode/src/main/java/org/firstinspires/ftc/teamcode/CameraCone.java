package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;

import java.util.List;

public class CameraCone {

    private static final String TFOD_MODEL_ASSET = "PowerPlay.tflite";

    private static final String[] LABELS = {
      "1 Bolt",
      "2 Bulb",
      "3 Panel"
    };

    private static final String VUFORIA_KEY =
            " AV5DiRv/////AAABmQQY+qA6hk+yvs2h+C9m7O0RUTsHHsO90qj9c2c7U2NiWAGSvnLjTlL5NWFlyOcqHjqMAk4UNRsDPhS15hb3argJVORiC7ra0KqgkIGfaOcujDTpGtpWrcvnKS1bvM2UIhpLjy20Do5TPt2HRhfEo3MqDFehYGpA48mYCLEbBL4mhl1RdCZYAWHbsZgYTbyOzieaEvwcjSYHJDV+sQUkqzRrHXQx6OZtDtz9BkZalvvJa+pGGhBhN9PEXwZkU6gfon3LRZS8NJv84Az5/dsHvCNwdNpaFTyW62emm5+Q9Nf9iIgkH9b7Wk4b7RbYL3SdAr9PzWeSVi0DxZ2HIkyroAReM8UAwfq75HQdNXQq6hRB";

    private VuforiaLocalizer vuforia;
    private TFObjectDetector tfod;
    private Telemetry telemetry;
    private HardwareMap hardwareMap;
    private LinearOpMode linearOpMode;

    public CameraCone(HardwareMap hardwareMap, Telemetry telemetry, LinearOpMode linearOpMode) {
        init(hardwareMap, telemetry, linearOpMode);
    }

    private void init(HardwareMap hardwareMap, Telemetry telemetry, LinearOpMode linearOpMode) {
        this.telemetry = telemetry;
        this.linearOpMode = linearOpMode;
        this.hardwareMap = hardwareMap;
        initVuforia();
        initTfod();

    }
    public <label> String findCone () {
        if (tfod != null) {
            tfod.activate();
            tfod.setZoom(1.0, 16.0/9.0);
        }

        String item = null;

        if (linearOpMode.opModeIsActive()) {
            long targetTime = System.currentTimeMillis() + 3750;
            while (linearOpMode.opModeIsActive() &&  System.currentTimeMillis() < targetTime
            ) {
                if (tfod != null) {

                    List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
                    if (updatedRecognitions != null && updatedRecognitions.size() >0 && item == null) {
                        telemetry.addData("# Objects Detected", updatedRecognitions.size());

                        for (Recognition recognition : updatedRecognitions) {
                            double col = (recognition.getLeft() + recognition.getRight()) / 2 ;
                            double row = (recognition.getTop()  + recognition.getBottom()) / 2 ;
                            double width  = Math.abs(recognition.getRight() - recognition.getLeft()) ;
                            double height = Math.abs(recognition.getTop()  - recognition.getBottom()) ;

                            telemetry.addData(""," ");
                            telemetry.addData("Image", "%s (%.0f %% Conf.)", recognition.getLabel(), recognition.getConfidence() * 100 );
                            telemetry.addData("- Position (Row/Col)","%.0f / %.0f", row, col);
                            telemetry.addData("- Size (Width/Height)","%.0f / %.0f", width, height);

                        }
                        telemetry.addLine("Item: " + updatedRecognitions.get(0).getLabel());
                        item = updatedRecognitions.get(0).getLabel().substring(0,1);
                        telemetry.update();
                    }
                }
            }
        }
        return item;
    }

    private void initVuforia() {
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraDirection = CameraDirection.BACK;

        //  Instantiate the Vuforia engine
        vuforia = ClassFactory.getInstance().createVuforia(parameters);
    }

    /**
     * Initialize the TensorFlow Object Detection engine.
     */
    private void initTfod() {
        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
            "tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        tfodParameters.minResultConfidence = 0.75f;
        tfodParameters.isModelTensorFlow2 = true;
        tfodParameters.inputSize = 300;
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);

        // Use loadModelFromAsset() if the TF Model is built in as an asset by Android Studio
        // Use loadModelFromFile() if you have downloaded a custom team model to the Robot Controller's FLASH.
        tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABELS);
        // tfod.loadModelFromFile(TFOD_MODEL_FILE, LABELS);
    }
}