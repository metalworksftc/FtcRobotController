package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "DriveCartesion2")
public class DriveCartesian2 extends OpMode {
    Wheels wheels;
    Arm arm;
    Intake intake;
    int initPos;
    @Override
    public void init() {
        wheels = new Wheels(hardwareMap, telemetry);
         arm = new Arm(hardwareMap,telemetry);
        intake = new Intake(hardwareMap,telemetry);
        initPos = (int) arm.armMotor.getCurrentPosition();
        telemetry.addLine(String.valueOf(initPos));
        telemetry.update();
    }

    @Override
    public void loop() {

        arm.armMotor.setPower(gamepad2.left_stick_y);


        if (gamepad1.left_bumper) {
            wheels.reversePower(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x);
        } else {
            if (gamepad1.right_bumper) {
                wheels.driveCartesian(-gamepad1.left_stick_x * 1, -gamepad1.left_stick_y * 1, gamepad1.right_stick_x * 1);
            } else {
                wheels.driveCartesian(-gamepad1.left_stick_x * 0.5, -gamepad1.left_stick_y * 0.5, gamepad1.right_stick_x * 0.5);
            }
        }

        if (gamepad2.left_bumper) {
        } else if (gamepad2.right_bumper) {
            arm.leftServo.setPosition(.6);
            arm.rightServo.setPosition(.3);
        }
        telemetry.addLine(String.valueOf(arm.armMotor.getCurrentPosition()));
//        if (gamepad2.a) {
//            arm.moveLow();
//
//        }
//        if (gamepad2.b) {
//           // arm.move(23.5, .75);
//            arm.armMotor.setTargetPosition(initPos + 300);
//        }
//        if (gamepad2.y) {
//           // arm.move(33.5,.75);
//            arm.armMotor.setTargetPosition(initPos + 600);
//        }
//        if (gamepad2.x) {
//            //arm.move(0, .75);
//            arm.armMotor.setTargetPosition(initPos + 800);
//        }

        //a = low
        //b = medium
        //x = ground
        //y = high
    }
}
