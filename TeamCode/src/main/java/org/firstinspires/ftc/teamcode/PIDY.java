package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class PIDY {

    static double KP = 0.135 / Wheels.COUNTS_PER_INCH;
    static double KI = 0;
    static double KD = 0.015;

    double previous_error;
    double previous_time;
    double i, p, d;
    double current_time, current_error;
    double max_i;

    public PIDY() {}

    public void init(double initial_error) {
        previous_error = initial_error;
        previous_time = System.currentTimeMillis();
    }

    public double calculate(double error, Telemetry telemetry) {

        current_time = System.currentTimeMillis();
        current_error = error;


        p = KP * current_error;
        //i += KI * (current_error * (current_time - previous_time));

        d = KD * (current_error - previous_error) / (current_time - previous_time);

        previous_time = current_time;
        previous_error = current_error;


        return (p + d) * .5;

    }

    public void reset() {
        previous_error = 0;
        previous_time = 0;
        i = 0;
    }
}
