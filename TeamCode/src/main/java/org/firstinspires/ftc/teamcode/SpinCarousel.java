
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Spin Carousel Red")

public class SpinCarousel extends LinearOpMode {
    Wheels wheels;
    Intake intake;

    @Override
    public void runOpMode() {
        wheels = new Wheels(hardwareMap, telemetry);
        intake = new Intake(hardwareMap,telemetry);

        waitForStart();

        wheels.backwards(10, wheels.driveSpeed);
        wheels.absoluteTurnPower(90, wheels.driveSpeed);
        wheels.forwards(20,wheels.driveSpeed);

    }
}
