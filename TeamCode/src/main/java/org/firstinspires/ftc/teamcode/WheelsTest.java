package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Wheels Test")

public class WheelsTest extends OpMode {
    Wheels wheels;

    DcMotor leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor;

    @Override
    public void init() {
        wheels = new Wheels(hardwareMap, telemetry);
    }

    @Override
    public void loop() {

        if (gamepad1.a) {
            wheels.leftFrontMotor.setPower(.5);
        }
        else {
            wheels.leftFrontMotor.setPower(0);
        }
        if (gamepad1.b) {
            wheels.leftBackMotor.setPower(.5);
        }
        else {
            wheels.leftBackMotor.setPower(0);
        }
        if (gamepad1.x) {
            wheels.rightFrontMotor.setPower(.5);
        }
        else {
            wheels.rightFrontMotor.setPower(0);
        }
        if (gamepad1.y) {
            wheels.rightBackMotor.setPower(.5);
        }
        else {
            wheels.rightBackMotor.setPower(0);
        }
    }
}
