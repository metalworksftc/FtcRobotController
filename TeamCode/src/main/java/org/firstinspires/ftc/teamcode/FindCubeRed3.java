
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Find Cube Red3")

public class FindCubeRed3 extends LinearOpMode {
    Wheels wheels;
    Arm arm;
    @Override
    public void runOpMode() throws InterruptedException {
        wheels = new Wheels(hardwareMap, telemetry);
        arm = new Arm(hardwareMap, telemetry);

        arm.pixelServo.setPosition(0);
        long targetTime;

        waitForStart();

        wheels.Y_Movement(30);
        wheels.waitSec(2);
        if (wheels.colorSensor1.red() > 75) {
            telemetry.addLine("Left");
            wheels.absoluteTurnPower(180, wheels.driveSpeed);
            wheels.right(4, wheels.driveSpeed);
            wheels.left(4, wheels.driveSpeed);
            arm.pixelServo.setPosition(1);

        } else if (wheels.colorSensor2.red() > 75) {
            telemetry.addLine("Right");
            arm.pixelServo.setPosition(1);

        } else {
            telemetry.addLine("Center");
            wheels.absoluteTurnPower(90, wheels.driveSpeed);
            arm.pixelServo.setPosition(1);

        }
        telemetry.update();

        wheels.X_Movement(-30);
        wheels.Y_Movement(10);
    }
}