
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "April Identify Cone Red F2")

public class AprilIdentifyCubeRedF2 extends LinearOpMode {
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
        wheels.left(wheels.cartesionBlock(1),wheels.driveSpeed);
        telemetry.addLine(String.valueOf(position));
        telemetry.update();
        //wheels.absoluteTurnPower(0,wheels.driveSpeed);

        if (position == 12) {
            wheels.forwards(wheels.cartesionBlock(1)-7,wheels.driveSpeed);
            wheels.absoluteTurnPower(0,wheels.driveSpeed);
            wheels.right(wheels.cartesionBlock(2)+5,wheels.driveSpeed);


        } else if (position == 13) {
            wheels.forwards(wheels.cartesionBlock(1)-14,wheels.driveSpeed);
            wheels.absoluteTurnPower(0,wheels.driveSpeed);
            wheels.right(wheels.cartesionBlock(1)+2,wheels.driveSpeed);


        } else if (position == 14) {
            wheels.absoluteTurnPower(0,wheels.driveSpeed);
            wheels.forwards(wheels.cartesionBlock(1)-7, wheels.driveSpeed);
        }
    }
}
