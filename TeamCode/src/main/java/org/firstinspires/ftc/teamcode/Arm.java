package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Arm {
    Telemetry telemetry;
    DcMotor liftMotor, pixelMotor;
    CRServo liftServo;
    TouchSensor limitSwitch;
    Servo pixelServo, airplaneServo, flipServo;

    Arm arm;

    public Arm(HardwareMap hardwareMap, Telemetry telemetry) {
        init(hardwareMap,telemetry);
    }

    private void init(HardwareMap hardwareMap, Telemetry telemetry) {

        liftServo = hardwareMap.get(CRServo.class, "ls");

        pixelServo = hardwareMap.servo.get("ps");
        airplaneServo = hardwareMap.servo.get("as");
        flipServo = hardwareMap.servo.get("fs");

        liftMotor = hardwareMap.dcMotor.get("lm");
        liftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        pixelMotor = hardwareMap.dcMotor.get("pm");
        
        limitSwitch = hardwareMap.touchSensor.get("mls");

        this.telemetry = telemetry;
        //pixelMotor = hardwareMap.dcMotor.get("pm");
        
        }


    public boolean liftCounts(double power) {

        int target = liftMotor.getCurrentPosition() - 10000;
        liftMotor.setPower(-power);

        while (liftMotor.getCurrentPosition() > target) {
            telemetry.addLine("Driving: " + liftMotor.getCurrentPosition() + " of " + target);
            telemetry.addLine(" Backwards");
            telemetry.update();
        }
        liftMotor.setPower(0);
        return true;
    }


}