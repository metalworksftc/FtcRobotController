package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Intake {
    DcMotorEx beaterBar, conveyorBelt, flywheelMotor, intakeMotor, armMotor;
    Servo pushServo;
    Telemetry telemetry;
    double flywheelVelocity = -1175;
    public boolean flywheelAtSpeed = false;

    public Intake(HardwareMap hardwareMap, Telemetry telemetry) {
        init(hardwareMap, telemetry);
    }

    private void init(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;
        flywheelMotor = hardwareMap.get(DcMotorEx.class, "fw");
        intakeMotor = hardwareMap.get(DcMotorEx.class, "im");
        armMotor = hardwareMap.get(DcMotorEx.class, "am");
        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void intake(double vel) {
        beaterBar.setVelocity(vel * 500);
    }

//    public void intake(double vel) {
//        beaterBar.setVelocity(vel * 500);
//    }
//
//    public void flywheel(long time, double power) {
//        final double velocity = flywheelMotor.getVelocity();
//        flywheelMotor.setVelocity(power);
//        time = time * 1000;
//        sleep(time);
//
//    }

    public void up(long time) {
        armMotor.setPower(0.75);
        sleep(time);
        armMotor.setPower(0);
    }

    public void down(long time) {
        armMotor.setPower(-0.75);
        sleep(time);
        armMotor.setPower(0);
    }

    public void beaterBar() {
        beaterBar.setPower(-0.5);
        sleep(500);
        beaterBar.setPower(0);
    }

    public void armMotor(double power) {
        armMotor.setPower(power);
    }

    public void intakeMotor(double power) {
        intakeMotor.setPower(power);
    }


    public void spin(long milliseconds) {
        flywheelMotor.setPower(0.5);
        sleep(milliseconds);
    }

    public final void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public double flywheelSpeed = 0.5;

}