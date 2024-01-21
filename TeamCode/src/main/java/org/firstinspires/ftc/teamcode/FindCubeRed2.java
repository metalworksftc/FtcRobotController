
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Find Cube Red 2")

public class FindCubeRed2 extends LinearOpMode {
    Wheels wheels;
    Arm arm;
    @Override
    public void runOpMode() throws InterruptedException {
        wheels = new Wheels(hardwareMap, telemetry);
        long targetTime;
        arm = new Arm(hardwareMap, telemetry);

        arm.pixelServo.setPosition(0);

        waitForStart();

        wheels.left(3, wheels.driveSpeed);
        wheels.forwards(96, wheels.driveSpeed);

//        wheels.Y_Movement(30);
//        wheels.waitSec(2);
//        if (wheels.colorSensor1.blue() > 75) {
//            telemetry.addLine("Left");
//
//        } else if (wheels.colorSensor2.blue() > 75) {
//            telemetry.addLine("Right");
//
//            arm.pixelServo.setPosition(1);
//            wheels.backwards(05,wheels.driveSpeed);
//            wheels.absoluteTurnPower(90, wheels.driveSpeed);
//            wheels.backwards(30, wheels.driveSpeed);
//            targetTime = System.currentTimeMillis() + 850;
//            while (System.currentTimeMillis() < targetTime) {
//                arm.pixelMotor.setPower(-.5);
//            }
//            arm.pixelMotor.setPower(0);
//            arm.flipServo.setPosition(1);
//            wheels.waitSec(2);
//            arm.flipServo.setPosition(0);
//            wheels.waitSec(.25);
//            targetTime = System.currentTimeMillis() + 850;
//            while (System.currentTimeMillis() < targetTime) {
//                arm.pixelMotor.setPower(.5);
//            }
//            arm.pixelMotor.setPower(0);
//            wheels.right(20,wheels.driveSpeed);
//            wheels.backwards(10,wheels.driveSpeed);
//
//        } else {
//            telemetry.addLine("Center");
//            wheels.absoluteTurnPower(90, wheels.driveSpeed);
//            arm.pixelServo.setPosition(1);
//            wheels.waitSec(.5);
//            wheels.absoluteTurnPower(-90, wheels.driveSpeed);
//            wheels.backwards(30, wheels.driveSpeed);
//            targetTime = System.currentTimeMillis() + 850;
//            while (System.currentTimeMillis() < targetTime) {
//                arm.pixelMotor.setPower(-.5);
//            }
//            arm.pixelMotor.setPower(0);
//            arm.flipServo.setPosition(1);
//            wheels.waitSec(2);
//            arm.flipServo.setPosition(0);
//            wheels.waitSec(.25);
//            targetTime = System.currentTimeMillis() + 850;
//            while (System.currentTimeMillis() < targetTime) {
//                arm.pixelMotor.setPower(.5);
//            }
//            arm.pixelMotor.setPower(0);
//            wheels.right(20,wheels.driveSpeed);
//            wheels.backwards(10,wheels.driveSpeed);
//
//        }
        telemetry.update();

        wheels.X_Movement(-60);
        wheels.Y_Movement(10);
    }
}