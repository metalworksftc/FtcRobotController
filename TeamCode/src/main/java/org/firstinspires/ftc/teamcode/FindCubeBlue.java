
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
        long targetTime;
        waitForStart();

        wheels.forwards(30,wheels.driveSpeed);
        wheels.waitSec(2);
        if (wheels.colorSensor1.blue() > 75) {
            telemetry.addLine("Left");
            telemetry.update();
            wheels.forwards(10,wheels.driveSpeed);
            wheels.left(18,wheels.driveSpeed);
            wheels.backwards(10,wheels.driveSpeed);
            wheels.right(5.5,wheels.driveSpeed);
            arm.pixelServo.setPosition(1);
            wheels.waitSec(.5);
            wheels.left(.5, wheels.driveSpeed);
            wheels.left(10,wheels.driveSpeed);
            wheels.waitSec(.25);
            wheels.absoluteTurnPower(-90, wheels.driveSpeed);
            wheels.waitSec(.75);
            wheels.backwards(5,wheels.driveSpeed);
            targetTime = System.currentTimeMillis() + 850;
            while (System.currentTimeMillis() < targetTime) {
                arm.pixelMotor.setPower(-.65);
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
            wheels.left(12,wheels.driveSpeed);
            wheels.backwards(10,wheels.driveSpeed);

        } else if (wheels.colorSensor2.blue() > 90) {
            telemetry.addLine("Right");
            telemetry.update();
            wheels.backwards(3.25,wheels.driveSpeed);
            wheels.right(3,wheels.driveSpeed);
            wheels.left(1., wheels.driveSpeed);
            arm.pixelServo.setPosition(1);
            wheels.waitSec(.5);
            wheels.left(12,wheels.driveSpeed);
            wheels.waitSec(.25);
            wheels.absoluteTurnPower(-90, wheels.driveSpeed);
            wheels.waitSec(.90);
            wheels.backwards(23,wheels.driveSpeed);
            targetTime = System.currentTimeMillis() + 1000;
            while (System.currentTimeMillis() < targetTime) {
                arm.pixelMotor.setPower(-.65);
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
            wheels.left(18,wheels.driveSpeed);
            wheels.backwards(10,wheels.driveSpeed);

        } else {
            telemetry.addLine("Center");
            telemetry.update();
            wheels.absoluteTurnPower(90, wheels.driveSpeed);
            arm.pixelServo.setPosition(1);
            wheels.waitSec(.5);
            wheels.left(10,wheels.driveSpeed);
            wheels.absoluteTurnPower(-90, wheels.driveSpeed);
            wheels.backwards(35,wheels.driveSpeed);
            //wheels.left(8,wheels.driveSpeed);
            wheels.backwards(3, wheels.driveSpeed);
            targetTime = System.currentTimeMillis() + 850;
            while (System.currentTimeMillis() < targetTime) {
                arm.pixelMotor.setPower(-.65);
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
            wheels.left(16,wheels.driveSpeed);
            wheels.backwards(10,wheels.driveSpeed);
        }

        telemetry.update();


    }
}