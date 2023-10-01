
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;

@Autonomous(name = "Find Cube Blue")

public class FindCubeBlue extends LinearOpMode {
    Wheels wheels;
    //Arm arm;
    @Override
    public void runOpMode() {
        wheels = new Wheels(hardwareMap, telemetry);
        //arm = new Arm(hardwareMap, telemetry);


        waitForStart();

        wheels.forwards(24,wheels.driveSpeed);

        if (wheels.colorSensor1.blue() > 75) {
            telemetry.addLine("Left");
            //ADD Drop Purple Pixel Here
            wheels.absoluteTurnPower(90, wheels.driveSpeed);
            wheels.forwards(30,wheels.driveSpeed);
            //ADD Drop Yellow Pixel Here
        } else if (wheels.colorSensor2.blue() > 75) {
            telemetry.addLine("Center");
            //ADD Drop Purple Pixel Here
            wheels.absoluteTurnPower(90, wheels.driveSpeed);
            wheels.forwards(30,wheels.driveSpeed);
            //ADD Drop Yellow Pixel Here
        } else {
            telemetry.addLine("Right");
            //ADD Drop Purple Pixel Here
            wheels.absoluteTurnPower(90, wheels.driveSpeed);
            wheels.forwards(30,wheels.driveSpeed);
            //ADD Drop Yellow Pixel Here
        }
        telemetry.update();

        wheels.right(24,wheels.driveSpeed);
        wheels.forwards(10, wheels.driveSpeed);
    }
}