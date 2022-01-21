
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.tfod.Recognition;

import java.util.List;

@Autonomous(name = "Identify Ducks")

public class IdentifyDucks extends LinearOpMode {
    Wheels wheels;
    Intake intake;
    CameraDuck camera;
    List<Recognition> updatedRecognitions = null;

    @Override
    public void runOpMode() {
        wheels = new Wheels(hardwareMap, telemetry);
        intake = new Intake(hardwareMap,telemetry);
        camera = new CameraDuck(hardwareMap, telemetry, this);
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
            wheels.backwards(22, wheels.driveSpeed);
            intake.beaterBarOut();
            intake.down(240 ,0.5);
            wheels.forwards(15, wheels.driveSpeed);
            wheels.absoluteTurnPower(-90, wheels.driveSpeed);
            wheels.forwards(90, 0.75);

        } else if (cultMember == 2) {

            wheels.left(16, wheels.driveSpeed);
            wheels.absoluteTurnPower(180, wheels.driveSpeed);
            wheels.backwards(23, wheels.driveSpeed);
            intake.beaterBarOut();
            intake.down(250 ,0.5);
            wheels.forwards(15, wheels.driveSpeed);
            wheels.absoluteTurnPower(-90, wheels.driveSpeed);
            wheels.forwards(85, 0.75);

        } else {

            wheels.left(16, wheels.driveSpeed);
            wheels.absoluteTurnPower(0, wheels.driveSpeed);
            intake.up(1500,0.75);
            wheels.forwards(20, wheels.driveSpeed);
            intake.beaterBarUp();
            intake.down(2000 ,0.5);
            wheels.absoluteTurnPower(-90, wheels.driveSpeed);
            wheels.forwards(80, 0.75);
        }





    }
}
