
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
        arm.pixelServo.setPosition(0);
        waitForStart();

     //   int targetTag = 1;
       // int foundTag = 0;
        //int count = 0;

        wheels.X_Movement(10);
        wheels.Y_Movement(10);
        wheels.X_Movement(-10);
        wheels.Y_Movement(-10);


        //while (targetTag != foundTag) {
         //   foundTag = aprilTag.findTag(telemetry);
       // }

        //arm.liftCounts(1);


    }
}