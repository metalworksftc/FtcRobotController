
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Spin Carousel Blue")

public class SpinCarouselBlue extends LinearOpMode {
    Wheels wheels;
    Intake intake;

    @Override
    public void runOpMode() {
        wheels = new Wheels(hardwareMap, telemetry);
        intake = new Intake(hardwareMap,telemetry);

        waitForStart();

        wheels.forwards(10, .3);
        intake.spin(1500);
        wheels.forwards(2,0.25);
        intake.spin(1500);
        wheels.left(25, wheels.driveSpeed);
    }
}
