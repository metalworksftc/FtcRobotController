
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Identify Ducks")

public class IdentifyDucks extends LinearOpMode {
    Wheels wheels;
    Intake intake;
    Camera camera;

    @Override
    public void runOpMode() {
        wheels = new Wheels(hardwareMap, telemetry);
        intake = new Intake(hardwareMap,telemetry);
        camera = new Camera(hardwareMap, telemetry, this);

        waitForStart();

        wheels.forwards(10, wheels.driveSpeed);
        String ducks = camera.seeDucks();
        telemetry.addLine(ducks);

    }
}
