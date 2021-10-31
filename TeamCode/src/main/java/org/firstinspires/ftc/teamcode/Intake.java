package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Intake {
    DcMotorEx beaterBar, conveyorBelt, flywheelMotor;
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
    }

    public void intake(double vel) {
        beaterBar.setVelocity(vel * 500);
    }

    public void flywheel(long time, double power) {
        final double velocity = flywheelMotor.getVelocity();
        flywheelMotor.setVelocity(power);
        time = time * 1000;
        sleep(time);

    }

    public final void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public double flywheelSpeed = 0.6;

}