
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Auto Test")

public class AutoTest extends LinearOpMode {
    Wheels wheels;
    Intake intake;

    @Override
    public void runOpMode() {
        wheels = new Wheels(hardwareMap, telemetry);

        waitForStart();

        wheels.absoluteTurnPower(-90, wheels.driveSpeed);
        sleep(500);
        wheels.absoluteTurnPower(180,wheels.driveSpeed);
        sleep(500);
        wheels.absoluteTurnPower(90,wheels.driveSpeed);
        sleep(500);
        wheels.absoluteTurnPower(0,wheels.driveSpeed);
        sleep(500);
    }
}
