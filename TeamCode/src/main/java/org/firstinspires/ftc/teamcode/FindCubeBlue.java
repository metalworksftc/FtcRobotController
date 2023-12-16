
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;

@Autonomous(name = "Find Cube Blue")

public class FindCubeBlue extends LinearOpMode {
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
            telemetry.update();
            arm.pixelServo.setPosition(1);
            wheels.waitSec(.5);
            wheels.absoluteTurnPower(90, wheels.driveSpeed);
            wheels.Y_Movement(30);
            wheels.X_Movement(-30);
            wheels.Y_Movement(10);

        } else if (wheels.colorSensor2.blue() > 75) {
            telemetry.addLine("Right");
            telemetry.update();
            wheels.absoluteTurnPower(180, wheels.driveSpeed);
            arm.pixelServo.setPosition(1);
            wheels.waitSec(.5);
            wheels.absoluteTurnPower(90, wheels.driveSpeed);
            wheels.Y_Movement(30);
            wheels.X_Movement(-30);
            wheels.Y_Movement(10);

        } else {
            telemetry.addLine("Center");
            telemetry.update();
            wheels.absoluteTurnPower(90, wheels.driveSpeed);
            arm.pixelServo.setPosition(1);
            wheels.waitSec(.5);
            wheels.X_Movement(-10);
            wheels.absoluteTurnPower(90, wheels.driveSpeed);
            wheels.Y_Movement(30);
            wheels.X_Movement(10);
            wheels.X_Movement(-30);
            wheels.Y_Movement(10);
        }

        telemetry.update();


    }
}