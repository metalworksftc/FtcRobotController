
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Park in Storage")

public class ParkInStorage extends LinearOpMode {
    Wheels wheels;


    @Override
    public void runOpMode() {
        wheels = new Wheels(hardwareMap, telemetry);

        waitForStart();

        wheels.forwards(30, wheels.driveSpeed);
        wheels.absoluteTurnPower(-90,wheels.driveSpeed);
        wheels.forwards(30,wheels.driveSpeed);

    }
}
