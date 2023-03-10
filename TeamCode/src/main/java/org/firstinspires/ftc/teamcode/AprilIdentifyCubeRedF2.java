
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
        wheels.radianMove(180,wheels.cartesionBlock(1)+6);
        telemetry.addLine(String.valueOf(position));
        telemetry.update();
        //wheels.absoluteTurnPower(0,wheels.driveSpeed);

        if (position == 14) {
            wheels.radianMove(0,wheels.cartesionBlock(2)+10);
            wheels.absoluteTurnPower(0,wheels.driveSpeed);
            wheels.radianMove(90,wheels.cartesionBlock(1));

        } else if (position == 13) {
            wheels.radianMove(90,wheels.cartesionBlock(1)-5);
            wheels.absoluteTurnPower(0,wheels.driveSpeed);
            wheels.radianMove(0,wheels.cartesionBlock(1)+14);

        } else if (position == 12) {
            wheels.absoluteTurnPower(0,wheels.driveSpeed);
            wheels.radianMove(90,wheels.cartesionBlock(1)-7);
        }
    }
}
