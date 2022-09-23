package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Arm {
    Telemetry telemetry;
    DcMotor armMotor;

    public Arm(HardwareMap hardwareMap, Telemetry telemetry) {
        init(hardwareMap,telemetry);
    }

    private void init(HardwareMap hardwareMap, Telemetry telemetry) {
        armMotor = hardwareMap.dcMotor.get("am");
        armMotor.setDirection(DcMotorSimple.Direction.REVERSE);
//        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.telemetry = telemetry;

    }

    public  void down (double distance, double power){
        int target = armMotor.getCurrentPosition() + (int)  distance;
        armMotor.setPower(-power);
        while (armMotor.getCurrentPosition() < target) {
            telemetry.addLine("Driving: " + armMotor.getCurrentPosition() + " of " + target);
            telemetry.update();
        }
        armMotor.setPower(0);
    }

    public void up (double distance, double power) {

        int target = armMotor.getCurrentPosition() - (int) distance;
        armMotor.setPower(power);
        while (armMotor.getCurrentPosition() > target) {
            telemetry.addLine("Driving: " + armMotor.getCurrentPosition() + " of " + target);
            telemetry.update();
        }
        armMotor.setPower(0);
    }

//    public  void  drop(int counts){
//        telemetry.addLine("Going Down");
//        telemetry.update();
//        down(counts,0.5);
//        telemetry.addLine("Going Up");
//        telemetry.update();
//        open();
//        up(3000,0.5);
//    }


    public void sleep(double seconds) {
        try {
            Thread.sleep((long) seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void swing (double position) {
        armMotor.setPower(position);
        telemetry.addLine("Driving: " + armMotor.getCurrentPosition());
        telemetry.update();
    }
}