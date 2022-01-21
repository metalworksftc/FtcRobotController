
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.tfod.Recognition;

import java.util.List;

@Autonomous(name = "Identify Cube")

public class IdentifyCube extends LinearOpMode {
    Wheels wheels;
    Intake intake;
    CameraCube camera;
    List<Recognition> updatedRecognitions = null;

    @Override
    public void runOpMode() {
        wheels = new Wheels(hardwareMap, telemetry);
        intake = new Intake(hardwareMap,telemetry);
        camera = new CameraCube(hardwareMap, telemetry, this);
        int blockPosition;
        double distance = 0;
        float direction = 0;
        telemetry.addLine("initialized");
        telemetry.update();
        waitForStart();

        int cube = camera.findCube();
        telemetry.addLine(String.valueOf(cube));
        telemetry.update();
        sleep(500);

        if (cube == 1) {

            wheels.left(2, wheels.driveSpeed);
            wheels.forwards(10, wheels.driveSpeed);
            wheels.left(15, wheels.driveSpeed);
            wheels.absoluteTurnPower(180, wheels.driveSpeed);
            wheels.forwards(2.5, wheels.driveSpeed);
            intake.spin(2500);
            wheels.left(50, wheels.driveSpeed);
            intake.down(180,0.75);
            wheels.backwards(12, wheels.driveSpeed);
            intake.beaterBarOut();
            wheels.forwards(10, wheels.driveSpeed);
            wheels.absoluteTurnPower(90, wheels.driveSpeed);
            wheels.backwards(70, wheels.driveSpeed);

        } else if (cube == 2) {

            wheels.left(2, wheels.driveSpeed);
            wheels.forwards(10, wheels.driveSpeed);
            wheels.left(15, wheels.driveSpeed);
            wheels.absoluteTurnPower(180, wheels.driveSpeed);
            wheels.forwards(2.5, wheels.driveSpeed);
            intake.spin(2500);
            wheels.left(50, wheels.driveSpeed);
            wheels.backwards(12, wheels.driveSpeed);
            intake.beaterBarOut();
            wheels.forwards(10, wheels.driveSpeed);
            wheels.absoluteTurnPower(90, wheels.driveSpeed);
            wheels.backwards(70, wheels.driveSpeed);

        } else {

            wheels.left(2, wheels.driveSpeed);
            wheels.forwards(10, wheels.driveSpeed);
            wheels.left(15, wheels.driveSpeed);
            wheels.absoluteTurnPower(180, wheels.driveSpeed);
            wheels.forwards(2.5, wheels.driveSpeed);
            intake.spin(2500);
            wheels.left(50, wheels.driveSpeed);
            wheels.absoluteTurnPower(0, wheels.driveSpeed);
            intake.up(1500,0.75);
            wheels.forwards(12, wheels.driveSpeed);
            intake.beaterBarUp();
            wheels.backwards(10, wheels.driveSpeed);
            wheels.absoluteTurnPower(90, wheels.driveSpeed);
            wheels.backwards(70, wheels.driveSpeed);

        }
    }
}
