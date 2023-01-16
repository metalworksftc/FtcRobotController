
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.CameraCone;
import org.firstinspires.ftc.teamcode.Intake;
import org.firstinspires.ftc.teamcode.Wheels;

@Autonomous(name = "April Identify Cone Red F2")

public class AprilIdentifyCubeRedF2 extends LinearOpMode {
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
        wheels.left(wheels.block(1)-2,wheels.driveSpeed);
        telemetry.addLine(String.valueOf(position));
        telemetry.update();

        if (position == 1) {
            wheels.forwards(wheels.block(2),wheels.driveSpeed);


        } else if (position == 2) {
            wheels.forwards(wheels.block(2),wheels.driveSpeed);
            wheels.right(wheels.block(1),wheels.driveSpeed);


        } else if (position == 3) {
            wheels.forwards(wheels.block(2)-6, wheels.driveSpeed);
            wheels.right(wheels.block(2),wheels.driveSpeed);

        }
    }
}
