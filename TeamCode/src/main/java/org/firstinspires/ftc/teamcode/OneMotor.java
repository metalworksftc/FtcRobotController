
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "OneMotor")

public class OneMotor extends LinearOpMode {
    Wheels wheels;
    Intake intake;
    DcMotor  motor;
    @Override
    public void runOpMode() {
        wheels = new Wheels(hardwareMap, telemetry);

        waitForStart();


    }
}
