
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Autonomous(name = "April Identify Cone Blue A5")

public class AprilIdentifyConeBlueA5 extends LinearOpMode {
    Wheels wheels;
    Intake intake;
    AprilCamera aprilCamera;
    Arm arm;

    @Override
    public void runOpMode() throws InterruptedException {
        wheels = new Wheels(hardwareMap, telemetry);
        intake = new Intake(hardwareMap,telemetry);
        aprilCamera = new AprilCamera(hardwareMap,telemetry,this);
        arm = new Arm(hardwareMap,telemetry);
        int position;
        aprilCamera.initCamera();
        telemetry.addLine("Initialized");
        telemetry.update();
        waitForStart();
        position = aprilCamera.findTag();
        telemetry.addLine(String.valueOf(position));
        telemetry.update();

        if (position == 12) {
            wheels.radianMove(180,wheels.cartesionBlock(1)+20);
            wheels.absoluteTurnPower(0,wheels.driveSpeed);
            wheels.radianMove(90,wheels.cartesionBlock(1));
        } else if (position == 13) {
            wheels.radianMove(90,wheels.cartesionBlock(1));

        } else if (position == 14) {
            wheels.radianMove(0,wheels.cartesionBlock(1)+6);
            wheels.absoluteTurnPower(5,wheels.driveSpeed);
            wheels.radianMove(90,wheels.cartesionBlock(1));

        } else {
            wheels.radianMove(90,wheels.cartesionBlock(1));
        }
    }
}
