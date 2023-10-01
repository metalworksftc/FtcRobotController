
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Auto Test")

public class AutoTest extends LinearOpMode {
    //Wheels wheels;
    AprilTagAuto aprilTag;

    @Override
    public void runOpMode() {
        //wheels = new Wheels(hardwareMap, telemetry);
        aprilTag = new AprilTagAuto(hardwareMap,telemetry);

        aprilTag.initAprilTag(hardwareMap);

        waitForStart();
        int targetTag = 1;
        int foundTag = 0;
        int count = 0;


        while (targetTag != foundTag) {
            foundTag = aprilTag.findTag(telemetry);
        }


    }
}