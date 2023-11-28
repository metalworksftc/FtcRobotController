package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;

@TeleOp(name = "DriveCartesion2")
public class DriveCartesian2 extends OpMode {
    Wheels wheels;
    Arm arm;
    Intake intake;
    int initPos;
    boolean pressed = false;
    boolean up = false;

    @Override
    public void init() {
        wheels = new Wheels(hardwareMap, telemetry);
         arm = new Arm(hardwareMap,telemetry);
        intake = new Intake(hardwareMap,telemetry);
       // initPos = (int) arm.armMotor.getCurrentPosition();
        telemetry.addLine(String.valueOf(initPos));
        telemetry.update();
        arm.pixelServo.setPosition(0);
        up = false;
    }

    @Override
    public void loop() {

        if (gamepad1.left_bumper) {
            wheels.reversePower(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x);
        } else {
            if (gamepad1.right_bumper) {
                wheels.driveCartesian(-gamepad1.left_stick_x * 1, gamepad1.left_stick_y * 1, -gamepad1.right_stick_x * 1);
            } else {
                wheels.driveCartesian(-gamepad1.left_stick_x * 0.5, gamepad1.left_stick_y * 0.5, -gamepad1.right_stick_x * 0.5);
            }
        }
        if(gamepad1.a && gamepad2.a){
            arm.liftServo.setPower(-1);

        }
        if (arm.limitSwitch.isPressed() && up == false) {
            arm.liftServo.setPower(0);
            up = arm.liftCounts(1);
        }
//        telemetry.addLine(String.valueOf(arm.limitSwitch.isPressed()));
//        telemetry.addLine(String.valueOf(arm.liftMotor.getCurrentPosition()));
        telemetry.addLine(String.valueOf(wheels.getHeading()));
        telemetry.update();

        arm.liftMotor.setPower(gamepad2.left_stick_y);


        arm.pixelServo.setPosition(gamepad2.left_trigger);
        arm.flipServo.setPosition(gamepad2.right_trigger);

        if(gamepad2.y){
            arm.airplaneServo.setPosition(0);
        }

        initPos = wheels.rightFrontMotor.getCurrentPosition();
    }
}
