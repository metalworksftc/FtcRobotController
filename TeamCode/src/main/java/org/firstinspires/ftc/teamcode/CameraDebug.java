
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.tfod.Recognition;

import java.util.List;

@Autonomous(name = "Camera Debug")

public class CameraDebug extends LinearOpMode {
    Camera camera;
    List<Recognition> updatedRecognitions = null;

    @Override
    public void runOpMode() {
        camera = new Camera(hardwareMap, telemetry, this);
        int cultMemberPosition;
        long move = 0;

        waitForStart();

        int cultMember = camera.findCultMembers();
        telemetry.addLine(String.valueOf(cultMember));
        telemetry.update();
        sleep(30000);

    }
}
