package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "DriveCartesion2")
public class DriveCartesian2 extends OpMode {
    Wheels wheels;
    Arm arm;
    Intake intake;

    @Override
    public void init() {
        wheels = new Wheels(hardwareMap, telemetry);
         arm = new Arm(hardwareMap,telemetry);
        intake = new Intake(hardwareMap,telemetry);
    }

    @Override
    public void loop() {

        arm.armMotor.setPower(-gamepad2.left_stick_y);


        if (gamepad1.left_bumper) {
            wheels.reversePower(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x);
        }
        else {
            if (gamepad1.right_bumper) {
                wheels.driveCartesian(gamepad1.left_stick_x * 1, gamepad1.left_stick_y * 1, gamepad1.right_stick_x * 1);
            }
            else {
                wheels.driveCartesian(gamepad1.left_stick_x*0.5, gamepad1.left_stick_y*0.5, gamepad1.right_stick_x*0.5);
            }
        }
       /*
        telemetry.addLine(String.valueOf(wheels.leftFrontMotor.getCurrentPosition()));
        telemetry.addLine(String.valueOf(wheels.rightFrontMotor.getCurrentPosition()));
        telemetry.addLine(String.valueOf(wheels.leftBackMotor.getCurrentPosition()));
        telemetry.addLine(String.valueOf(wheels.rightBackMotor.getCurrentPosition()));

        telemetry.addLine(String.valueOf(wheels.getHeading()));
        telemetry.update();
 */
    }
}
