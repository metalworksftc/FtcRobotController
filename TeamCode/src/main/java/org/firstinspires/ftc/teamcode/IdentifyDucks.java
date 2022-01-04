
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.tfod.Recognition;

import java.util.List;

@Autonomous(name = "Identify Ducks")

public class IdentifyDucks extends LinearOpMode {
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
        double move = 0;
        telemetry.addLine("initialized");
        telemetry.update();
        waitForStart();

        int cultMember = camera.findCultMembers();
        telemetry.addLine(String.valueOf(cultMember));
        telemetry.update();

        if (cultMember == 1) {
            move = 150;
        } else if (cultMember == 2) {
            move = 200;
        } else {
            move = 250;
        }

        wheels.left(15, wheels.driveSpeed);
        intake.move(move,0.5);
        wheels.forwards(15, wheels.driveSpeed);
        intake.beaterBar();
        intake.move(move,-0.5);
        wheels.backwards(15, wheels.driveSpeed);
        wheels.absoluteTurnPower(-90, wheels.driveSpeed);
        wheels.forwards(60, 0.75);



    }
}
