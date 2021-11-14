
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Auto Duck and Park in Storage")

public class AutoDuckandParkinStorage extends LinearOpMode {
    Wheels wheels;
    Intake intake;

    @Override
    public void runOpMode() {
        wheels = new Wheels(hardwareMap, telemetry);
        intake = new Intake(hardwareMap, telemetry);

        waitForStart();

        wheels.backwards(25, wheels.driveSpeed);
        wheels.right(30, wheels.driveSpeed);
        wheels.forwards(15, wheels.driveSpeed);
        intake.spin(5000);

    }
}
