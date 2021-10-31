
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Spin Carousel")

public class SpinCarousel extends LinearOpMode {
    Wheels wheels;
    Intake intake;

    @Override
    public void runOpMode() {
        wheels = new Wheels(hardwareMap, telemetry);
        intake = new Intake(hardwareMap,telemetry);

        waitForStart();

        wheels.forwards(10, wheels.driveSpeed);
        wheels.left(20,wheels.driveSpeed);
        intake.flywheel(10, intake.flywheelSpeed);

    }
}
