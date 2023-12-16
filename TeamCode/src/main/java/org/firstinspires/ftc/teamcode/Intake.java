package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
public class Intake {
    Telemetry telemetry;
    DcMotor intakeMotor;
    Servo intakeFlipServo;
    public Intake(HardwareMap hardwareMap, Telemetry telemetry) {
        init(hardwareMap, telemetry);
        intakeMotor = hardwareMap.dcMotor.get("im");
        intakeMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        intakeFlipServo = hardwareMap.servo.get("ifm");
    }

    private void init(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;

    }


}