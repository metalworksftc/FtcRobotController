
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "April Identify Cone Blue A2")

public class AprilIdentifyConeBlueA2 extends LinearOpMode {
    Wheels wheels;
    Intake intake;
    //AprilCamera aprilCamera;
    CameraCone cameraCone;

    @Override
    public void runOpMode() throws InterruptedException {
        wheels = new Wheels(hardwareMap, telemetry);
        intake = new Intake(hardwareMap,telemetry);
     //   aprilCamera = new AprilCamera(this);
       // cameraCone = new CameraCone(hardwareMap,telemetry,this);
        int position;
        telemetry.addLine("Initialized");
        telemetry.update();
        waitForStart();

        position = Integer.parseInt(cameraCone.findCone());
        telemetry.addLine(String.valueOf(position));
        telemetry.update();
        wheels.right(wheels.block(1)+2,wheels.driveSpeed);
        telemetry.addLine(String.valueOf(position));
        telemetry.update();

        if (position == 1) {
            wheels.forwards(wheels.block(2),wheels.driveSpeed);
            wheels.absoluteTurnPower(0,wheels.driveSpeed);
            wheels.left(wheels.block(2),wheels.driveSpeed);


        } else if (position == 2) {
            wheels.forwards(wheels.block(2),wheels.driveSpeed);
            wheels.absoluteTurnPower(0,wheels.driveSpeed);
            wheels.left(wheels.block(1),wheels.driveSpeed);


        } else if (position == 3) {
            wheels.forwards(wheels.block(1), wheels.driveSpeed);

        }
    }
}
