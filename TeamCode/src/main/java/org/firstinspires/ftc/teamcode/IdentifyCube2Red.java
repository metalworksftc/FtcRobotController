
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.tfod.Recognition;

import java.util.List;

@Autonomous(name = "Identify Cube 2 Red")

public class IdentifyCube2Red extends LinearOpMode {
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
        intake.servoDown();
        telemetry.addLine("initialized");
        telemetry.update();
        waitForStart();

        int cube = camera.findCube();
        telemetry.addLine(String.valueOf(cube));
        telemetry.update();
        sleep(500);

        if (cube == 1) {

            wheels.left(2.75, wheels.driveSpeed);
            wheels.forwards(10, .45);
            wheels.left(15, wheels.driveSpeed);
            wheels.absoluteTurnPower(180, wheels.driveSpeed);
            wheels.forwards(4, wheels.driveSpeed);
            intake.spin(3000);
            wheels.left(50, wheels.driveSpeed);
            intake.down(180,0.75);
            wheels.backwards(12, wheels.driveSpeed);
            intake.beaterBarUp();
            wheels.absoluteTurnPower(90,wheels.driveSpeed);
            intake.down(180,.75);
            wheels.backwards(30, wheels.driveSpeed);
            intake.beaterBarUp();
            wheels.forwards(8, wheels.driveSpeed);
            wheels.absoluteTurnPower(0, wheels.driveSpeed);
            intake.up(2250,0.75);
            intake.beaterBarUp();
            intake.down(1000,0.75);
            wheels.backwards(10, wheels.driveSpeed);
            wheels.absoluteTurnPower(90, wheels.driveSpeed);
            wheels.backwards(85, 0.65);

        } else if (cube == 2) {

            wheels.left(2.75, wheels.driveSpeed);
            wheels.forwards(10, .45);
            wheels.left(15, wheels.driveSpeed);
            wheels.absoluteTurnPower(180, wheels.driveSpeed);
            wheels.forwards(4, wheels.driveSpeed);
            intake.spin(3000);
            wheels.left(50, wheels.driveSpeed);
            intake.down(180,.75);
            wheels.backwards(30, wheels.driveSpeed);
            intake.beaterBarUp();
            wheels.forwards(8, wheels.driveSpeed);
            wheels.absoluteTurnPower(0, wheels.driveSpeed);
            intake.up(2250,0.75);
            intake.beaterBarUp();
            intake.down(1000,0.75);
            wheels.backwards(10, wheels.driveSpeed);
            wheels.absoluteTurnPower(90, wheels.driveSpeed);
            wheels.backwards(85, 0.65);

        } else {

            wheels.left(2.75, wheels.driveSpeed);
            wheels.forwards(10, .45);
            wheels.left(15, wheels.driveSpeed);
            wheels.absoluteTurnPower(180, wheels.driveSpeed);
            wheels.forwards(4, wheels.driveSpeed);
            intake.spin(3000);
            wheels.left(50, wheels.driveSpeed);
            wheels.absoluteTurnPower(0, wheels.driveSpeed);
            intake.up(1500,0.75);
            wheels.forwards(20, wheels.driveSpeed);
            intake.beaterBarOut();
            wheels.backwards(8, wheels.driveSpeed);
            wheels.absoluteTurnPower(0, wheels.driveSpeed);
            intake.up(2250,0.75);
            intake.beaterBarUp();
            intake.down(1000,0.75);
            wheels.backwards(10, wheels.driveSpeed);
            wheels.absoluteTurnPower(90, wheels.driveSpeed);
            wheels.backwards(85, 0.65);
        }
    }
}