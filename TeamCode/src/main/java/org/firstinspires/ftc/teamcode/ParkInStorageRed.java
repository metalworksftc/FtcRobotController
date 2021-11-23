
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Park in Storage")

public class ParkInStorageRed extends LinearOpMode {
    Wheels wheels;


    @Override
    public void runOpMode() {
        wheels = new Wheels(hardwareMap, telemetry);

        waitForStart();

        wheels.forwards(16, wheels.driveSpeed);
        wheels.sleep(1000);
        wheels.absoluteTurnPower(90, wheels.turnSpeed);
        wheels.forwards(15, wheels.driveSpeed);

    }
}
