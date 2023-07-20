package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "DriveCartesion2")
public class DriveCartesian2 extends OpMode {
    Wheels wheels;
    //Arm arm;
    Intake intake;
    int initPos;
    @Override
    public void init() {
        wheels = new Wheels(hardwareMap, telemetry);
        // arm = new Arm(hardwareMap,telemetry);
        intake = new Intake(hardwareMap,telemetry);
       // initPos = (int) arm.armMotor.getCurrentPosition();
        telemetry.addLine(String.valueOf(initPos));
        telemetry.update();
    }

    @Override
    public void loop() {

        if (gamepad1.left_bumper) {
            wheels.reversePower(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x);
        } else {
            if (gamepad1.right_bumper) {
                wheels.driveCartesian(gamepad1.left_stick_x * 1, -gamepad1.left_stick_y * 1, gamepad1.right_stick_x * 1);
            } else {
                wheels.driveCartesian(gamepad1.left_stick_x * 0.5, -gamepad1.left_stick_y * 0.5, gamepad1.right_stick_x * 0.5);
            }
        }

        initPos = wheels.rightFrontMotor.getCurrentPosition();
    }
}
