package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BHI260IMU;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcontroller.external.samples.SensorIMUOrthogonal;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AngularVelocity;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

public class Wheels {
    DcMotor leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor;
    Telemetry telemetry;
    ColorSensor colorSensor1, colorSensor2;


    PIDY pid_Y;
    PIDX pid_X;
    protected Orientation angles;
    protected BHI260IMU imu;

    static double TOLERANCE;


    public Wheels(HardwareMap hardwareMap, Telemetry telemetry) {
        init(hardwareMap, telemetry);
    }

    private void init(HardwareMap hardwareMap, Telemetry telemetry) {

        rightFrontMotor = hardwareMap.dcMotor.get("rfm");
        rightFrontMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        leftFrontMotor = hardwareMap.dcMotor.get("lfm");
        leftFrontMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftFrontMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        leftBackMotor = hardwareMap.dcMotor.get("lbm");
        leftBackMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        rightBackMotor = hardwareMap.dcMotor.get("rbm");
        rightBackMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.telemetry = telemetry;

        pid_Y = new PIDY();
        pid_X = new PIDX();


        BHI260IMU.Parameters parameters = new BHI260IMU.Parameters(new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.UP, RevHubOrientationOnRobot.UsbFacingDirection.BACKWARD));

        imu = hardwareMap.get(BHI260IMU.class, "imu");
        imu.initialize(parameters);


        colorSensor1 = hardwareMap.colorSensor.get("cs1");
        colorSensor2 = hardwareMap.colorSensor.get("cs2");
    }

    private void normalize(double[] wheelSpeeds) {
        double maxMagnitude = Math.abs(wheelSpeeds[0]);

        for (int i = 1; i < wheelSpeeds.length; i++) {
            double magnitude = Math.abs(wheelSpeeds[i]);

            if (magnitude > maxMagnitude) {
                maxMagnitude = magnitude;
            }
        }

        if (maxMagnitude > 1.0) {
            for (int i = 0; i < wheelSpeeds.length; i++) {
                wheelSpeeds[i] /= maxMagnitude;
            }
        }
    }

    double wheelSpeeds[] = new double[4];

    public void driveCartesian(double x, double y, double rotation) {

        wheelSpeeds[0] = x + y + rotation;
        wheelSpeeds[1] = -x + y - rotation;
        wheelSpeeds[2] = -x + y + rotation;
        wheelSpeeds[3] = x + y - rotation;

        normalize(wheelSpeeds);

        leftFrontMotor.setPower(wheelSpeeds[0]);
        rightFrontMotor.setPower(wheelSpeeds[1]);
        leftBackMotor.setPower(wheelSpeeds[2]);
        rightBackMotor.setPower(wheelSpeeds[3]);
        odometerChange(leftFrontMotor.getCurrentPosition(), rightFrontMotor.getCurrentPosition(), leftBackMotor.getCurrentPosition());


    }   //mecanumDrive_Cartesian

    protected static final double RADIAN_DRIVE_CALIBRATION = 51.66;
    //    protected static final double DRIVE_CALIBRATION = 32.923;
    protected static final double DRIVE_CALIBRATION = 30.109;
    protected static final double CALIBRATION_COUNTS = 10000;
    public static double COUNTS_PER_INCH = CALIBRATION_COUNTS / DRIVE_CALIBRATION;
    double RADIAN_COUNTS_PER_INCH = 10890.118577 / RADIAN_DRIVE_CALIBRATION;

    public void backwards(double distance, double power) {

//        backwardsCount(distance*COUNTS_PER_INCH, power);
    }

//    public void backwardsCount (double distance, double power) {
//
//        int target = rightFrontMotor.getCurrentPosition() - (int)  distance;
//        driveCartesian(0, power, 0);
//
//        while (rightFrontMotor.getCurrentPosition() > target) {
//            odometerChange(leftFrontMotor.getCurrentPosition(), rightFrontMotor.getCurrentPosition(), leftBackMotor.getCurrentPosition());
//            telemetry.addLine(String.valueOf(System.currentTimeMillis()));
//            telemetry.addLine("Driving: " + rightFrontMotor.getCurrentPosition() + " of " + target);
//            telemetry.addLine(" Backwards");
//            telemetry.update();
//        }
//        driveCartesian(0, 0, 0);
//
    public void Y_Movement(double distance) {
        Y_Counts(distance * COUNTS_PER_INCH);
        waitSec(.25);
    }

    public void Y_Counts(double distance) {
        pid_Y.init(distance);

        int target = rightFrontMotor.getCurrentPosition() + (int) (distance);

        double initialPower = pid_Y.calculate(distance, telemetry);
        driveCartesian(0, initialPower, 0);

        telemetry.addLine("Driving:" + rightFrontMotor.getCurrentPosition() + " of " + target);
        telemetry.update();


        double error = distance;
        TOLERANCE = 150;
        while (Math.abs(error) > TOLERANCE) {
            error = rightFrontMotor.getCurrentPosition() - target;
            double power = pid_Y.calculate(error, telemetry) * 0.5;
            telemetry.addLine("Driving:" + rightFrontMotor.getCurrentPosition() + " of " + target);
            telemetry.addLine("Forward");
            telemetry.update();
            driveCartesian(0, power, 0);
        }

        driveCartesian(0, 0, 0);

        pid_Y.reset();
    }

        protected static final double Strafe_CALIBRATION = 38.9895958315;
        protected static final double CALIBRATION_Strafe_COUNTS = 10000;
        static double Strafe_COUNTS_PER_INCH = CALIBRATION_Strafe_COUNTS / Strafe_CALIBRATION;

    public void X_Movement(double distance) {
        distance *= Strafe_COUNTS_PER_INCH;
        pid_X.init(distance);

        int target = leftBackMotor.getCurrentPosition() + (int) (distance);

        double initialPower = pid_X.calculate(distance, telemetry);
        driveCartesian(initialPower, 0, 0);

        telemetry.addLine("Driving:" + leftBackMotor.getCurrentPosition() + " of " + target);
        telemetry.update();


        double error = distance;
        TOLERANCE = 150;
        while (Math.abs(error) > TOLERANCE) {
            error = leftBackMotor.getCurrentPosition() - target;
            double power = pid_X.calculate(error, telemetry) * 0.5;
            telemetry.addLine("Driving:" + leftBackMotor.getCurrentPosition() + " of " + target);
            telemetry.addLine("Forward");
            telemetry.update();
            driveCartesian(power, 0, 0);
        }

        driveCartesian(0, 0, 0);

        pid_X.reset();
        waitSec(.25);
    }

    protected void absoluteTurnPower(float target, double power) {
        //turn left
        float distLeft = target - getHeading();
        if (distLeft < 0) {
            distLeft += 360;
        }
        float distRight = 360 - distLeft;

        telemetry.addLine(String.valueOf("distLeft " + distLeft + "distRight " + distRight));
        telemetry.update();
        if (distLeft < distRight) {
            driveCartesian(0,0,power);
            //turn left
            while (distLeft > 5) {
                telemetry.addLine("Turning Left: " + getHeading() + " of " + target);
                telemetry.update();
                distLeft = target - getHeading();
                if (distLeft < 0) {
                    distLeft += 360;
                }
            }
        } else {
            driveCartesian(0,0,-power);
            //turn right
            while (distRight > 2) {
                telemetry.addLine("Turning Right: " + getHeading() + " of " + target);
                telemetry.update();
                distLeft = target - getHeading();
                if (distLeft < 0) {
                    distLeft += 360;
                }
                distRight = 360 - distLeft;
            }
        }
       driveCartesian(0,0,0);
    }

    Orientation robotOrientation;
    protected float getHeading() {
        robotOrientation = imu.getRobotOrientation(
                AxesReference.INTRINSIC,
                AxesOrder.XYZ,
                AngleUnit.DEGREES
        );
        //angles = robotOrientation.firstAngle;;
        return (float) AngleUnit.DEGREES.normalize((robotOrientation.thirdAngle));
    }

    public void sleep(double milliseconds) {
        try {
            Thread.sleep((long) milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public double driveSpeed = 0.25;
    public double turnSpeed = 0.35;

    public void reversePower( float xPower, float yPower, float rotation){
        driveCartesian(-xPower*0.5,-yPower*0.5,rotation*0.5);
    }

//    public double cartesionBlock(double blocks) {
//        return 23.75 * blocks + 8;
//    }
    public double cartesionBlock(double blocks) {
        return 23.75 * blocks + 6;
    }

    double radianWheelSpeeds[] = new double[2];

    public void radianMove(double degreeAngle, double distance) {
        double radian = (degreeAngle * Math.PI)/ 180;
        double red = Math.sin(radian+(.25*Math.PI));
        double blue = Math.sin(radian-(.25*Math.PI));

        radianWheelSpeeds[0] = red;
        radianWheelSpeeds[1] = blue;
        distance *= RADIAN_COUNTS_PER_INCH;
        int target;
        if (degreeAngle >= 270 && degreeAngle < 360 || degreeAngle >= 0 && degreeAngle < 90) {
          target = rightFrontMotor.getCurrentPosition() + (int) distance;
          driveRadian(radianWheelSpeeds);
          while (rightFrontMotor.getCurrentPosition() < target) {

              telemetry.addLine(String.valueOf(System.currentTimeMillis()));
              telemetry.addLine("Driving: " + rightFrontMotor.getCurrentPosition() + " or " + leftFrontMotor.getCurrentPosition() + " of " + target);
              telemetry.update();
          }
        } else {
            target = rightFrontMotor.getCurrentPosition() - (int) distance;
            driveRadian(radianWheelSpeeds);
            while (rightFrontMotor.getCurrentPosition() > target) {
                telemetry.addLine(String.valueOf(System.currentTimeMillis()));
                telemetry.addLine("Driving: " + rightFrontMotor.getCurrentPosition() + " or " + leftFrontMotor.getCurrentPosition() + " of " + target);
                telemetry.update();
            }
        }
        driveRadian(radianWheelSpeeds);
    }

    public void driveRadian(double[] array) {
        leftFrontMotor.setPower(-array[0]*.75);
        rightFrontMotor.setPower(array[1]*.75);
        leftBackMotor.setPower(-array[1]*.75);
        rightBackMotor.setPower(-array[0]*.75);
    }

    double prevLeftPos = 0;
    double deltaLeft;
    double prevRightPos = 0;
    double deltaRight;
    double prevCenterPos = 0;
    double deltaCenter;
    double rotation;
    double prevRotation = 0;
    double deltaDis;
    double deltaPerp;
    double deltaX;
    double deltaY;
    double xPos;
    double yPos;
    double[] array = new double[3];
    double finalAngle = 0;

    public double[] odometerChange(double leftPos, double rightPos, double centerPos) {
        deltaLeft = leftPos - prevLeftPos;
        deltaRight = rightPos - prevRightPos;
        deltaCenter = centerPos - prevCenterPos;

        rotation = (deltaLeft - deltaRight) / 8.75;
        deltaDis = (deltaLeft + deltaRight) / 2;
        deltaPerp = deltaDis - 7.75 * rotation;

        deltaX = deltaDis * Math.cos(prevRotation) - deltaPerp * Math.sin(prevRotation);
        deltaY = deltaDis * Math.sin(prevRotation) + deltaPerp * Math.cos(prevRotation);

        xPos += deltaX;
        yPos += deltaY;
        prevRotation += rotation;

        prevRightPos = rightPos;
        prevLeftPos = leftPos;
        prevCenterPos = centerPos;
        finalAngle += rotation;

//
//       lemetry.update();

        array[0] = xPos;
        array[1] = yPos;
        array[2] = rotation;
        return array;
    }

    protected void waitSec(double seconds) {

        ElapsedTime time = new ElapsedTime();
        time.startTime();

        while(time.seconds() < seconds ) {
        }

    }

}