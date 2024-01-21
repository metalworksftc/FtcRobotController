
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Find Cube Red")

public class FindCubeRed extends LinearOpMode {
    Wheels wheels;
    Arm arm;
    @Override
    public void runOpMode() throws InterruptedException {
        wheels = new Wheels(hardwareMap, telemetry);
        arm = new Arm(hardwareMap, telemetry);

        arm.pixelServo.setPosition(0.1);
        long targetTime;

        waitForStart();

        wheels.forwards(30,wheels.driveSpeed);
        wheels.waitSec(2);
        if (wheels.colorSensor1.red() > 75) {
            telemetry.addLine("Left");
            wheels.absoluteTurnPower(180, wheels.driveSpeed);
            wheels.right(4, wheels.driveSpeed);
            wheels.left(4, wheels.driveSpeed);
            arm.pixelServo.setPosition(1);
            wheels.waitSec(.5);
            wheels.absoluteTurnPower(90, wheels.driveSpeed);
            wheels.backwards(23, wheels.driveSpeed);
            targetTime = System.currentTimeMillis() + 850;
            while (System.currentTimeMillis() < targetTime) {
                arm.pixelMotor.setPower(-.5);
            }
            arm.pixelMotor.setPower(0);
            arm.flipServo.setPosition(1);
            wheels.waitSec(2);
            arm.flipServo.setPosition(0);
            wheels.waitSec(.25);
            targetTime = System.currentTimeMillis() + 850;
            while (System.currentTimeMillis() < targetTime) {
                arm.pixelMotor.setPower(.5);
            }
            arm.pixelMotor.setPower(0);
            wheels.right(18,wheels.driveSpeed);
            wheels.backwards(10,wheels.driveSpeed);

        } else if (wheels.colorSensor2.red() > 75) {
            telemetry.addLine("Right");
            arm.pixelServo.setPosition(1);
            wheels.waitSec(.5);
            wheels.forwards(10,wheels.driveSpeed);
            wheels.right(20,wheels.driveSpeed);
            wheels.backwards(10,wheels.driveSpeed);
            wheels.absoluteTurnPower(90, wheels.driveSpeed);
            wheels.backwards(8, wheels.driveSpeed);
            targetTime = System.currentTimeMillis() + 850;
            while (System.currentTimeMillis() < targetTime) {
                arm.pixelMotor.setPower(-.5);
            }
            arm.pixelMotor.setPower(0);
            arm.flipServo.setPosition(1);
            wheels.waitSec(2);
            arm.flipServo.setPosition(0);
            wheels.waitSec(.25);
            targetTime = System.currentTimeMillis() + 850;
            while (System.currentTimeMillis() < targetTime) {
                arm.pixelMotor.setPower(.5);
            }
            arm.pixelMotor.setPower(0);
            wheels.right(20,wheels.driveSpeed);
            wheels.backwards(10,wheels.driveSpeed);

        } else {
            telemetry.addLine("Center");
            wheels.absoluteTurnPower(90, wheels.driveSpeed);
            arm.pixelServo.setPosition(1);
            wheels.waitSec(.5);
            wheels.backwards(28, wheels.driveSpeed);
            targetTime = System.currentTimeMillis() + 850;
            while (System.currentTimeMillis() < targetTime) {
                arm.pixelMotor.setPower(-.5);
            }
            arm.pixelMotor.setPower(0);
            arm.flipServo.setPosition(1);
            wheels.waitSec(2);
            arm.flipServo.setPosition(0);
            wheels.waitSec(.25);
            targetTime = System.currentTimeMillis() + 850;
            while (System.currentTimeMillis() < targetTime) {
                arm.pixelMotor.setPower(.5);
            }
            arm.pixelMotor.setPower(0);
            wheels.forwards(1,wheels.driveSpeed);
            wheels.right(16,wheels.driveSpeed);
            wheels.backwards(10,wheels.driveSpeed);
        }
        telemetry.update();

        wheels.X_Movement(-30);
        wheels.Y_Movement(10);
    }
}