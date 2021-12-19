
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
        //   intake = new Intake(hardwareMap,telemetry);
        camera = new Camera(hardwareMap, telemetry, this);
        int cultMemberPosition;
        long move = 0;

        waitForStart();

        int cultMember = camera.findCultMembers();
        sleep(30000);
        telemetry.addLine(String.valueOf(cultMember));
        telemetry.addLine(String.valueOf(camera.Left));
        telemetry.update();

        wheels.left(15, wheels.driveSpeed);
        wheels.forwards(25, wheels.driveSpeed);
        intake.up(move);
        intake.beaterBar();
        intake.down(move);
        wheels.backwards(15, wheels.driveSpeed);
        wheels.absoluteTurnPower(-90, wheels.driveSpeed);
        wheels.forwards(30, 0.75);

        if (cultMember == 1) {
            move = 3;
        } else if (cultMember == 2) {
            move = 4;
        } else {
            move = 5;
        }

    }
}
