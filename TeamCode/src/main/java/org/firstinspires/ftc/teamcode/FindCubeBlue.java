
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;

@Autonomous(name = "Find Cube Blue")

public class FindCubeBlue extends LinearOpMode {
    Wheels wheels;
    Arm arm;
    @Override
    public void runOpMode() {
        wheels = new Wheels(hardwareMap, telemetry);
        arm = new Arm(hardwareMap, telemetry);


        waitForStart();

        arm.pixelServo.setPosition(0);
        wheels.Y_Movement(24);

        if (wheels.colorSensor1.blue() > 75) {
            telemetry.addLine("Left");
            wheels.absoluteTurnPower(180, wheels.driveSpeed);
            arm.pixelServo.setPosition(1);
            wheels.absoluteTurnPower(90, wheels.driveSpeed);
            wheels.Y_Movement(30);
            //ADD Drop Yellow Pixel Here
        } else if (wheels.colorSensor2.blue() > 75) {
            telemetry.addLine("Center");
            arm.pixelServo.setPosition(1);
            wheels.absoluteTurnPower(90, wheels.driveSpeed);
            wheels.Y_Movement(30);
            //ADD Drop Yellow Pixel Here
        } else {
            telemetry.addLine("Right");
            wheels.absoluteTurnPower(90, wheels.driveSpeed);
            arm.pixelServo.setPosition(1);
            //ADD Drop Purple Pixel Here
            wheels.absoluteTurnPower(90, wheels.driveSpeed);
            wheels.Y_Movement(30);
            //ADD Drop Yellow Pixel Here
        }
        telemetry.update();

        wheels.X_Movement(-30);
        wheels.Y_Movement(10);
    }
}