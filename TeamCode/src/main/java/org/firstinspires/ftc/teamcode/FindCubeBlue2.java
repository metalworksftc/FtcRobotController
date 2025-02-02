
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Find Cube Blue 2")

public class FindCubeBlue2 extends LinearOpMode {
    Wheels wheels;
    Arm arm;
    @Override
    public void runOpMode() throws InterruptedException {
        wheels = new Wheels(hardwareMap, telemetry);
        //long targetTime;
        arm = new Arm(hardwareMap, telemetry);

        arm.pixelServo.setPosition(0.1);
        waitForStart();

        wheels.forwards(30,wheels.driveSpeed);
        wheels.waitSec(2);
        if (wheels.colorSensor1.blue() > 75) {
            telemetry.addLine("Left");
            telemetry.update();


            wheels.right(5,wheels.driveSpeed);
            wheels.absoluteTurnPower(180,wheels.driveSpeed);
            wheels.forwards(3, wheels.driveSpeed);
            wheels.right(13, wheels.driveSpeed);
            wheels.left(3, wheels.driveSpeed);
            arm.pixelServo.setPosition(1);
            wheels.left(3, wheels.driveSpeed);
            wheels.backwards(22, wheels.driveSpeed);
            wheels.absoluteTurnPower(90, wheels.driveSpeed);
            wheels.forwards(60, wheels.driveSpeed);


//            wheels.left(3,wheels.driveSpeed);
//            wheels.forwards(13,wheels.driveSpeed);
//            wheels.waitSec(1);
//            arm.pixelServo.setPosition(1);
//            wheels.waitSec(1);

        } else if (wheels.colorSensor2.blue() > 90) {
            telemetry.addLine("Right");
            telemetry.update();
            wheels.backwards(4,wheels.driveSpeed);
            wheels.right(3,wheels.driveSpeed);
            wheels.left(1.25, wheels.driveSpeed);
            arm.pixelServo.setPosition(1);
            wheels.waitSec(1);

        } else {
            telemetry.addLine("Center");
            telemetry.update();
            wheels.absoluteTurnPower(90, wheels.driveSpeed);
            wheels.left(2.5,wheels.driveSpeed);
            arm.pixelServo.setPosition(1);
            wheels.waitSec(1);

        }

    }
}