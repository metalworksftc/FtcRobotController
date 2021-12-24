package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Intake {
    DcMotorEx beaterBar, conveyorBelt, flywheelMotor, armMotor, intakeMotor;
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
        armMotor = hardwareMap.get(DcMotorEx.class, "im");
        intakeMotor = hardwareMap.get(DcMotorEx.class, "am");
        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        beaterBar = hardwareMap.get(DcMotorEx.class, "im");
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

    public void move (double distance, double power) {
            power = -power;
        int target = intakeMotor.getCurrentPosition() + (int)  distance;
        telemetry.addLine("Setting Power");
        telemetry.update();
        sleep(1000);
        intakeMotor.setPower(power);
        telemetry.addLine("Power has been set at " + power);
        telemetry.update();

        while (intakeMotor.getCurrentPosition() > target) {
            telemetry.addLine(String.valueOf(System.currentTimeMillis()));
            telemetry.addLine("Going: " + intakeMotor.getCurrentPosition() + " of " + target);
            telemetry.update();
        }
        intakeMotor.setPower(0);
        telemetry.addLine("Arrived at target");
        telemetry.update();
    }


    public void up(long time) {
        intakeMotor.setPower(0.75);
        sleep(time);
        intakeMotor.setPower(0);
    }

    public void down(long time) {
        intakeMotor.setPower(-0.75);
        sleep(time);
        intakeMotor.setPower(0);
    }

    public void beaterBar() {
        beaterBar.setPower(-0.5);
        sleep(5000);
        beaterBar.setPower(0);
    }

    public void armMotor(double power) {
        intakeMotor.setPower(power);
    }

    public void intakeMotor(double power) {
        armMotor.setPower(power);
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