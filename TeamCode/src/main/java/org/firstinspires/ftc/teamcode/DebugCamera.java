
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.tfod.Recognition;

import java.util.List;

@Autonomous(name = "Camera Debug")

public class DebugCamera extends LinearOpMode {
    CameraCube camera;
    List<Recognition> updatedRecognitions = null;

    @Override
    public void runOpMode() {
        camera = new CameraCube(hardwareMap, telemetry, this);
        int cultMemberPosition;
        long move = 0;

        waitForStart();

        int block = camera.findCube();
        telemetry.addLine(String.valueOf(block));
        telemetry.update();
        sleep(30000);

    }
}
