
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

        //wheels.forwardsCounts(2000,0.5);
//        wheels.forwards(wheels.block(1),wheels.driveSpeed);
//        wheels.left(wheels.block(1),wheels.driveSpeed);
//        wheels.backwards(wheels.block(1),wheels.driveSpeed);
//        wheels.right(wheels.block(1),wheels.driveSpeed);

            wheels.radianTurn(90, wheels.block(1));

    }
}
