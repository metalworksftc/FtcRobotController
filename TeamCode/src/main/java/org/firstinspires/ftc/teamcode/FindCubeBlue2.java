
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Find Cube Blue 2")

public class FindCubeBlue2 extends LinearOpMode {
    Wheels wheels;
    Arm arm;
    @Override
    public void runOpMode() throws InterruptedException {
        wheels = new Wheels(hardwareMap, telemetry);
        arm = new Arm(hardwareMap, telemetry);

        arm.pixelServo.setPosition(0);

        waitForStart();

        wheels.Y_Movement(30);
        wheels.waitSec(2);
        if (wheels.colorSensor1.blue() > 75) {
            telemetry.addLine("Left");
            wheels.absoluteTurnPower(180, wheels.driveSpeed);
            arm.pixelServo.setPosition(1);
            wheels.waitSec(.5);
            wheels.absoluteTurnPower(90, wheels.driveSpeed);
            wheels.Y_Movement(30);

        } else if (wheels.colorSensor2.blue() > 75) {
            telemetry.addLine("Right");
            arm.pixelServo.setPosition(1);
            wheels.waitSec(.5);
            wheels.absoluteTurnPower(90, wheels.driveSpeed);
            wheels.Y_Movement(30);

        } else {
            telemetry.addLine("Center");
            wheels.absoluteTurnPower(90, wheels.driveSpeed);
            arm.pixelServo.setPosition(1);
            wheels.waitSec(.5);
            wheels.X_Movement(-10);
            wheels.absoluteTurnPower(90, wheels.driveSpeed);
            wheels.Y_Movement(20);
        }
        telemetry.update();

        wheels.X_Movement(-60);
        wheels.Y_Movement(10);
    }
}