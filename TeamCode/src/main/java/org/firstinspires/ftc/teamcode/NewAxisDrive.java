package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "New Axis Drive")

public class NewAxisDrive extends OpMode {
    Wheels wheels;
    Intake intake;
//    private Arm arm;

    DcMotor leftFrontMotor, leftRearMotor, rightFrontMotor, rightRearMotor, armMotor;

    @Override
    public void init() {
        wheels = new Wheels(hardwareMap, telemetry);
        intake = new Intake(hardwareMap,telemetry);
//        arm = new Arm(hardwareMap, telemetry);
    }

    @Override
    public void loop() {


        if (gamepad2.right_bumper) {
            intake.flywheelMotor.setPower(gamepad2.left_trigger * -0.4);
        } else
            intake.flywheelMotor.setPower(gamepad2.left_trigger * 0.4);

        if (gamepad1.left_bumper) {
            wheels.reversePower(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x * 0.5f);
        }
        else {
            if (gamepad1.right_bumper) {
                wheels.driveCartesian(gamepad1.left_stick_x * 0.5, gamepad1.left_stick_y * 0.5, gamepad1.right_stick_x * 0.5);
            }
            else {
                wheels.driveCartesian(gamepad1.left_stick_x * 1, gamepad1.left_stick_y * 1, gamepad1.right_stick_x * 0.5);
                telemetry.addLine(String.valueOf(wheels.leftFrontMotor.getCurrentPosition()));
                telemetry.addLine(String.valueOf(wheels.rightFrontMotor.getCurrentPosition()));
                telemetry.addLine(String.valueOf(wheels.leftBackMotor.getCurrentPosition()));
                telemetry.addLine(String.valueOf(wheels.rightBackMotor.getCurrentPosition()));
                telemetry.update();
            }
        }

            intake.armMotor(gamepad2.left_stick_y);
        intake.intakeMotor.setPower(gamepad2.right_stick_y * 0.4);

    }
}
