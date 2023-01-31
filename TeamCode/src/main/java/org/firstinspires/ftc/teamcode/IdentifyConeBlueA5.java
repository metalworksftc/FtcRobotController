
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Identify Cone Blue A5")

public class IdentifyConeBlueA5 extends LinearOpMode {
    Wheels wheels;
    Intake intake;
    CameraCone cameraCone;

    @Override
    public void runOpMode() throws InterruptedException {
        wheels = new Wheels(hardwareMap, telemetry);
        intake = new Intake(hardwareMap,telemetry);
        cameraCone = new CameraCone(hardwareMap,telemetry,this);
        int position;
        telemetry.addLine("Initialized");
        telemetry.update();
        waitForStart();

        position = Integer.parseInt(cameraCone.findCone());
        telemetry.addLine(String.valueOf(position));
        telemetry.update();

        if (position == 1) {
            wheels.left(wheels.block(1)+2,wheels.driveSpeed);
            wheels.forwards(wheels.block(2),wheels.driveSpeed);


        } else if (position == 2) {
            wheels.forwards(wheels.block(2),wheels.driveSpeed);


        } else if (position == 3) {
            wheels.right(wheels.block(1)+2,wheels.driveSpeed);
            wheels.forwards(wheels.block(2),wheels.driveSpeed);

        }
    }
}