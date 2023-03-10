
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "April Identify Cone Blue A2")
public class AprilIdentifyConeBlueA2 extends LinearOpMode {
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
        wheels.radianMove(0,wheels.cartesionBlock(1)+2);
        telemetry.addLine(String.valueOf(position));
        telemetry.update();
        wheels.absoluteTurnPower(0,wheels.driveSpeed);

        if (position == 12) {
            wheels.radianMove(180,wheels.cartesionBlock(1)+4);
            wheels.radianMove(270, 6);
            wheels.radianMove(180,wheels.cartesionBlock(1));
            wheels.absoluteTurnPower(-15,wheels.driveSpeed);
            wheels.radianMove(90,wheels.cartesionBlock(1)-12);


        } else if (position == 13) {
            wheels.radianMove(90,wheels.cartesionBlock(1)-14);
            wheels.absoluteTurnPower(-15,wheels.driveSpeed);
            wheels.radianMove(180,wheels.cartesionBlock(1)+7);


        } else if (position == 14) {
            wheels.radianMove(90,wheels.cartesionBlock(1)-7);

        }
    }
}
