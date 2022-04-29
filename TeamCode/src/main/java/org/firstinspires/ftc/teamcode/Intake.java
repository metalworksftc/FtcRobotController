package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Intake {
    DcMotorEx beaterBar, conveyorBelt, flywheelMotor, armMotor, intakeMotor;
    Servo grabServo;
    Telemetry telemetry;
    double flywheelVelocity = -1175;
    public boolean flywheelAtSpeed = false;

    public Intake(HardwareMap hardwareMap, Telemetry telemetry) {
        init(hardwareMap, telemetry);
    }

    private void init(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;
        flywheelMotor = hardwareMap.get(DcMotorEx.class, "fw");
        armMotor = hardwareMap.get(DcMotorEx.class, "am");
        armMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        intakeMotor = hardwareMap.get(DcMotorEx.class, "im");
        grabServo = hardwareMap.get(Servo.class,"gs");

    }

//    public void intake(double vel) {
//        beaterBar.setVelocity(vel * 500);
//    }

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
//    }s

    public void up (double distance, double power) {
            power = -power;
        int target = armMotor.getCurrentPosition() - (int)  distance;
        telemetry.addLine("Setting Power");
        telemetry.update();
        sleep(1000);
        armMotor.setPower(power);
        telemetry.addLine("Power has been set at " + power);
        telemetry.update();

        while (armMotor.getCurrentPosition() > target) {
            telemetry.addLine(String.valueOf(System.currentTimeMillis()));
            telemetry.addLine("Going: " + armMotor.getCurrentPosition() + " of " + target);
            telemetry.update();
        }
        armMotor.setPower(0);
        telemetry.addLine("Arrived at target");
        telemetry.update();
    }

    public void down (double distance, double power) {
        int target = armMotor.getCurrentPosition() + (int)  distance;
        telemetry.addLine("Setting Power");
        telemetry.update();
        sleep(1000);
        armMotor.setPower(power);
        telemetry.addLine("Power has been set at " + power);
        telemetry.update();

        while (armMotor.getCurrentPosition() < target) {
            telemetry.addLine(String.valueOf(System.currentTimeMillis()));
            telemetry.addLine("Going: " + armMotor.getCurrentPosition() + " of " + target);
            telemetry.update();
        }
        armMotor.setPower(0);
        telemetry.addLine("Arrived at target");
        telemetry.update();
    }


//    public void up(long time) {
//        intakeMotor.setPower(0.75);
//        sleep(time);
//        intakeMotor.setPower(0);
//    }
//
//    public void down(long time) {
//        intakeMotor.setPower(-0.75);
//        sleep(time);
//        intakeMotor.setPower(0);
//    }

    public void beaterBarUp() {
        intakeMotor.setPower(-0.55);
        sleep(1250);
        intakeMotor.setPower(0);
    }

    public void beaterBarOut() {
        intakeMotor.setPower(0.55);
        sleep(1250);
        intakeMotor.setPower(0);
    }

    public void armMotor(double power) {
        armMotor.setPower(power);
    }

    public void intakeMotor(double power) {
        intakeMotor.setPower(power);
    }


    public void spin(long milliseconds) {
        flywheelMotor.setPower(0.3);
        sleep(milliseconds);
        flywheelMotor.setPower(0);
    }

    public final void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


    public final  void flywheel(){
        double flywheelSpeed = 0.5;
        sleep(100);
        do {
            flywheelSpeed += .01;
        } while (flywheelSpeed <= 1);
    }


    public final void servoDown() {
        grabServo.setPosition(1);
    }
    public final void servoUpperCap() {
        grabServo.setPosition(0.425);
    }
    public final void servoLowerCap() {
        grabServo.setPosition(0.345);
    }
    public final void servoStore() {
        grabServo.setPosition(0);
    }

}