package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

public class PID {
    Telemetry telemetry;
    Wheels wheels;
    public PID(HardwareMap hardwareMap, Telemetry telemetry) {init(hardwareMap,telemetry);
    }

    int heading;
    private void init(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;
        heading = (int) wheels.getHeading();

    }

    public void pid(boolean right, int target) {

        if (wheels.rightFrontMotor.getCurrentPosition() > wheels.leftBackMotor.getCurrentPosition()) {
           wheels.leftBackMotor.setPower(wheels.leftBackMotor.getPower() + 0.02);
        } else if (wheels.rightFrontMotor.getCurrentPosition() < wheels.leftBackMotor.getCurrentPosition()) {
            wheels.rightFrontMotor.setPower(wheels.rightFrontMotor.getPower() - 0.02);
        } else {
            wheels.leftFrontMotor.setPower(wheels.driveSpeed);
            wheels.rightFrontMotor.setPower(wheels.driveSpeed);
            wheels.leftBackMotor.setPower(wheels.driveSpeed);
            wheels.rightBackMotor.setPower(wheels.driveSpeed);
        }
    }
}
