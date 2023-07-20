package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
@Disabled
public class Arm {
    Telemetry telemetry;
    DcMotor armMotor;
    Servo leftServo, rightServo;
    TouchSensor touchSensor;
    Arm arm;

    public Arm(HardwareMap hardwareMap, Telemetry telemetry) {
        init(hardwareMap,telemetry);
    }

    private void init(HardwareMap hardwareMap, Telemetry telemetry) {
        armMotor = hardwareMap.dcMotor.get("am");
        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.telemetry = telemetry;
        leftServo = hardwareMap.servo.get("ls");
        rightServo = hardwareMap.servo.get("rs");
        touchSensor = hardwareMap.get(TouchSensor.class, "mls");    }



    public void move(double distance, double power) {
        int target = armMotor.getCurrentPosition() + (int) (distance);
        armMotor.setPower(power);

        telemetry.addLine("Driving: " + armMotor.getCurrentPosition() + " of " + target);
        telemetry.update();

        while (armMotor.getCurrentPosition() < target) {
            telemetry.addLine("Driving: " + armMotor.getCurrentPosition() + " of " + target);
            telemetry.addLine(" Forward");
            telemetry.update();
        }
        armMotor.setPower(power);
    }

    public void moveLow() {
        while (!(touchSensor.isPressed())) {
            armMotor.setPower(.5);
        }
        armMotor.setPower(0);
    }
    public void close() {
        leftServo.setPosition(.6);
        rightServo.setPosition(.3);
    }


}