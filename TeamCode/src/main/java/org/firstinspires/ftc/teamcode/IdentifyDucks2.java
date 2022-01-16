
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.tfod.Recognition;

import java.util.List;

@Autonomous(name = "Identify Ducks")

public class IdentifyDucks2 extends LinearOpMode {
    Wheels wheels;
    Intake intake;
    Camera camera;
    List<Recognition> updatedRecognitions = null;

    @Override
    public void runOpMode() {
        wheels = new Wheels(hardwareMap, telemetry);
        intake = new Intake(hardwareMap,telemetry);
        camera = new Camera(hardwareMap, telemetry, this);
        int cultMemberPosition;
        double distance = 0;
        float direction = 0;
        telemetry.addLine("initialized");
        telemetry.update();
        waitForStart();

        int cultMember = camera.findCultMembers();
        telemetry.addLine(String.valueOf(cultMember));
        telemetry.update();
        sleep(500);

        if (cultMember == 1) {

            wheels.left(15, wheels.driveSpeed);
            wheels.absoluteTurnPower(180, wheels.driveSpeed);
            intake.down(200,0.75);
            wheels.backwards(17, wheels.driveSpeed);
            intake.beaterBar();
            intake.down(240 ,0.5);
            wheels.forwards(15, wheels.driveSpeed);
            wheels.absoluteTurnPower(-90, wheels.driveSpeed);
            wheels.forwards(80, 0.75);

        } else if (cultMember == 2) {

            wheels.left(15, wheels.driveSpeed);
            wheels.absoluteTurnPower(180, wheels.driveSpeed);
            wheels.backwards(17, wheels.driveSpeed);
            intake.beaterBar();
            intake.down(250 ,0.5);
            wheels.forwards(15, wheels.driveSpeed);
            wheels.absoluteTurnPower(-90, wheels.driveSpeed);
            wheels.forwards(80, 0.75);

        } else {

            wheels.left(15, wheels.driveSpeed);
            wheels.absoluteTurnPower(0, wheels.driveSpeed);
            intake.up(1500,0.5);
            wheels.forwards(20, wheels.driveSpeed);
            intake.beaterBar();
            intake.down(2000 ,0.5);
            wheels.absoluteTurnPower(-90, wheels.driveSpeed);
            wheels.forwards(80, 0.75);
        }





    }
}
