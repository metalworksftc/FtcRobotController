
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "April Identify Cone Red F5")

public class AprilIdentifyCubeRedF5 extends LinearOpMode {
    Wheels wheels;
    Intake intake;
    AprilCamera aprilCamera;

    @Override
    public void runOpMode() throws InterruptedException {
        wheels = new Wheels(hardwareMap, telemetry);
        intake = new Intake(hardwareMap,telemetry);
        aprilCamera = new AprilCamera(hardwareMap,telemetry,this);
        int position;
        telemetry.addLine("Initialized");
        telemetry.update();
        waitForStart();
        aprilCamera.initCamera();
        position = aprilCamera.findTag();
        telemetry.addLine(String.valueOf(position));
        telemetry.update();

        if (position == 12) {
            wheels.left(wheels.cartesionBlock(1)-5,wheels.driveSpeed);
            wheels.forwards(wheels.cartesionBlock(1),wheels.driveSpeed);

        } else if (position == 13) {
            wheels.forwards(wheels.cartesionBlock(1),wheels.driveSpeed);


        } else if (position == 14) {
            wheels.right(wheels.cartesionBlock(1)-4,wheels.driveSpeed);
            wheels.absoluteTurnPower(0, wheels.driveSpeed);
            wheels.forwards(wheels.cartesionBlock(1),wheels.driveSpeed);
        } else {
            wheels.forwards(1, wheels.driveSpeed);
        }
    }
}
