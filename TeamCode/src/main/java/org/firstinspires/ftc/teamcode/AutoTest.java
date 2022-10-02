
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

        wheels.right(200,0.5);

    }
}
