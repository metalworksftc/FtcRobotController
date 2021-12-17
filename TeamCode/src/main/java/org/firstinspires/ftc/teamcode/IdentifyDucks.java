
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

        String cultMembers = camera.findCultMembers();
        sleep(5000);
        telemetry.addLine(cultMembers);
        telemetry.addLine(String.valueOf(camera.Left));
        telemetry.update();

        if (camera.Left > 750) {
                cultMemberPosition = 2;
                telemetry.addLine("Sees cult member on right");
            } else if (camera.Left < 750 && camera.Left > 1) {
                cultMemberPosition = 1;
                telemetry.addLine("Sees cult member on left");
            } else {
                cultMemberPosition = 3;
            }

        telemetry.update();

        wheels.left(15, wheels.driveSpeed);
        wheels.forwards(25, wheels.driveSpeed);
        intake.up(move);
        intake.beaterBar();
        intake.down(move);
        wheels.backwards(15, wheels.driveSpeed);
        wheels.absoluteTurnPower(-90, wheels.driveSpeed);
        wheels.forwards(30, 0.75);

        if (cultMemberPosition == 1) {
            move = 3;
        } else if (cultMemberPosition == 2) {
            move = 4;
        } else {
            move = 5;
        }

    }
}
