package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Flywheel")

public class FlyWheel extends OpMode {
    DcMotor flywheelMotor;
    Wheels wheels;

    @Override
    public void init() {
        flywheelMotor = hardwareMap.dcMotor.get("fw");

    }

    @Override
    public void loop() {

      if (gamepad1.right_bumper) {
          flywheelMotor.setPower(-0.6);
      }
      else {
          flywheelMotor.setPower(0);
      }

    }
}
