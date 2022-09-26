
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.linearOpMode;

@Autonomous(name = "Identify Cone")

public class IdentifyCone extends LinearOpMode {
    Wheels wheels;
    Intake intake;
    CameraCone cameraCone;

    @Override
    public void runOpMode() {
        wheels = new Wheels(hardwareMap, telemetry);
//        intake = new Intake(hardwareMap,telemetry);
        cameraCone = new CameraCone(hardwareMap,telemetry,this);

        waitForStart();

        cameraCone.findCone();


    }
}
