
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Identify Cone Blue A2")

public class IdentifyConeBlueA2 extends LinearOpMode {
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
        wheels.right(wheels.cartesionBlock(1)-2,wheels.driveSpeed);
        telemetry.addLine(String.valueOf(position));
        telemetry.update();

        if (position == 1) {
            wheels.forwards(wheels.cartesionBlock(1)-5,wheels.driveSpeed);
            wheels.absoluteTurnPower(0,wheels.driveSpeed);
            wheels.left(wheels.cartesionBlock(2)+4.5,wheels.driveSpeed);


        } else if (position == 2) {
            wheels.forwards(wheels.cartesionBlock(1),wheels.driveSpeed);
            wheels.absoluteTurnPower(0,wheels.driveSpeed);
            wheels.left(wheels.cartesionBlock(1)+3,wheels.driveSpeed);


        } else if (position == 3) {
            wheels.forwards(wheels.cartesionBlock(1), wheels.driveSpeed);

        }
    }
}
