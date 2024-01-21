
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Auto Test")

public class AutoTest extends LinearOpMode {
    Wheels wheels;
    Arm arm;
    //AprilTagAuto aprilTag;

    @Override
    public void runOpMode() {
       wheels = new Wheels(hardwareMap, telemetry);
       arm = new Arm(hardwareMap,telemetry);
       //aprilTag = new AprilTagAuto(hardwareMap,telemetry);

        //aprilTag.initAprilTag(hardwareMap);
        arm.pixelServo.setPosition(0.1);
        waitForStart();

     //   int targetTag = 1;
       // int foundTag = 0;
        //int count = 0;

        //wheels.left(20, wheels.driveSpeed);
//        double n = 0.1;
//        while (n <= 1) {
//            arm.pixelServo.setPosition(-.9);
//            n+= .01;
//        }
//
//
//
//        wheels.waitSec(1);



        wheels.absoluteTurnPower(-90, .25);



    }
}