package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "TeleOp Test")
public class TeleOpTest extends OpMode {
    //Wheels wheels;
    Arm arm;
    //Intake intake;
    int initPos;
    @Override
    public void init() {
        //wheels = new Wheels(hardwareMap, telemetry);
         arm = new Arm(hardwareMap,telemetry);
        //intake = new Intake(hardwareMap,telemetry);
       // initPos = (int) arm.armMotor.getCurrentPosition();
        telemetry.addLine(String.valueOf(initPos));
        telemetry.update();



    }

    @Override
    public void loop() {
//
//        if (gamepad1.a) {
//            arm.leftServo.setPosition(1);
//            arm.rightServo.setPosition(0);
//        } else if (gamepad1.b) {
//            arm.leftServo.setPosition(0);
//            arm.rightServo.setPosition(1);
//        }

    }
}
