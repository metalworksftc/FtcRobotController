
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Park in Warehouse")

public class ParkInWarehouse extends LinearOpMode {
    Wheels wheels;


    @Override
    public void runOpMode() {
        wheels = new Wheels(hardwareMap, telemetry);

        waitForStart();

        wheels.left(20, wheels.driveSpeed);
        sleep(500);
        wheels.forwards(70, 1);

    }
}
