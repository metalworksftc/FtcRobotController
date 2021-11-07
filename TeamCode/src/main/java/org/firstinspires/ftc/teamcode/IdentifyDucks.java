
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.tfod.Recognition;

import java.util.List;

@Autonomous(name = "Identify Ducks")

public class IdentifyDucks extends LinearOpMode {
    Wheels wheels;
    Intake intake;
    Camera camera;
    List<Recognition> updatedRecognitions = null;

    @Override
    public void runOpMode() {
     //   wheels = new Wheels(hardwareMap, telemetry);
     //   intake = new Intake(hardwareMap,telemetry);
        camera = new Camera(hardwareMap, telemetry, this);
        int duckPosition;

        waitForStart();

        String ducks = camera.seeDucks();
        sleep(5000);
        telemetry.addLine(ducks);
        telemetry.addLine(String.valueOf(camera.Left));
        telemetry.update();

        if (camera.level == 0) {
            duckPosition = 1;
        } else if (camera.Left > 750) {
                duckPosition = 2;
                telemetry.addLine("Sees duck on right");
            } else if (camera.Left < 750) {
                duckPosition = 3;
                telemetry.addLine("Sees duck on left");
            } else {
                duckPosition = 1;
            }

        telemetry.update();

    }
}
