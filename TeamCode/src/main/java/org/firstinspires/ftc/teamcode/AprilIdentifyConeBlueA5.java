
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "April Identify Cone Blue A5")

public class AprilIdentifyConeBlueA5 extends LinearOpMode {
    Wheels wheels;
    Intake intake;
    AprilCamera aprilCamera;

    @Override
    public void runOpMode() throws InterruptedException {
        wheels = new Wheels(hardwareMap, telemetry);
        intake = new Intake(hardwareMap,telemetry);
        aprilCamera = new AprilCamera(hardwareMap,telemetry,this);
        int position;
        aprilCamera.initCamera();
        telemetry.addLine("Initialized");
        telemetry.update();
        waitForStart();
        position = aprilCamera.findTag();
        telemetry.addLine(String.valueOf(position));
        telemetry.update();

        if (position == 12) {
            wheels.left(wheels.cartesionBlock(1)+2,wheels.driveSpeed);
            wheels.absoluteTurnPower(0,wheels.driveSpeed);
            wheels.forwards(wheels.cartesionBlock(1),wheels.driveSpeed);
        } else if (position == 13) {
            wheels.forwards(wheels.cartesionBlock(1),wheels.driveSpeed);

        } else if (position == 14) {
            wheels.right(wheels.cartesionBlock(1)+2,wheels.driveSpeed);
            wheels.absoluteTurnPower(13,wheels.driveSpeed);
            wheels.forwards(wheels.cartesionBlock(1),wheels.driveSpeed);

        } else {
            wheels.forwards(wheels.cartesionBlock(1),wheels.driveSpeed);
        }
    }
}
