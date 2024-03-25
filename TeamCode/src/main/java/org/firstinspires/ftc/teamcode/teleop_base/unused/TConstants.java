package org.firstinspires.ftc.teamcode.teleop_base.unused;

import com.qualcomm.robotcore.hardware.PIDFCoefficients;

public class TConstants {
    // Intaking, Intermediate, Bottom, Second, Middle, Middle_High, Top, Hang_Height, Drop_Height
    private static int slidePositions[] = {0, -31, -240, -400, -627, -1081, -2020, -1500, -800};
    private static int slidePlacingPos[] = {};

    // Intaking, Intermediate, Parallel, Up
    private static double armPositions[] = {0.313, 0.37, 0.6852+.02};

    // Intaking, Intermediate, Placing(low, high)
    // 0.95
    // 0.025
    private static double clawPositions[] = {0.947, 0.4, 0, 0.4};

    public static int slideRange[] = {0, -2075};

    // First value is open position, second is closed
    public static final double gRightPos[] = {0.6609, 0.18};
    public static final double[] gLeftPos = {0.30844, 0.8};

    // Closed, intermediate, open, open_wall, stack_pickup
    public static final double[] scoopPos = {0.479, 0.528, 0.564, 0.58, 0.60};

    // Position of lift
    // Stores values of motor and servo encoder positions
    public enum TPos {
        INTAKING("INTAKING",         slidePositions[0], armPositions[0], clawPositions[0]),
        INTAKING_INTERMEDIATE("INTAKING_INTERMEDIATE",  slidePositions[0], armPositions[0]+0.04, clawPositions[0]),
        INTAKING_ABOVE("INTAKING_ABOVE",  slidePositions[0], armPositions[0]+0.01, clawPositions[0]),
        INTERMEDIATE("INTERMEDIATE", slidePositions[1], armPositions[1], clawPositions[1]),
        DRONE("DRONE", slidePositions[7], 0.6, clawPositions[1]),
        HANG("HANG", slidePositions[7], armPositions[0]-.05, clawPositions[1]),
        SAFE_INTER("SAFE_INTER",     slidePositions[0], armPositions[0], clawPositions[3]),//dep
        INTER_SLIDE("INTER_SLIDE",   slidePositions[1], armPositions[2], clawPositions[1]),
        BOTTOM("BOTTOM",             slidePositions[2], armPositions[2], clawPositions[2]),
        SECOND("SECOND",             slidePositions[3], armPositions[2], clawPositions[2]),
        MIDDLE("MIDDLE",             slidePositions[4], armPositions[2], clawPositions[2]),
        MIDDLE_HIGH("MIDDLE_HIGH",   slidePositions[5], armPositions[2], clawPositions[2]),
        TOP("TOP",                   slidePositions[6], armPositions[2], clawPositions[2]);

        private final String debug;
        private final int slidePosition;
        private final double armPosition;
        private final double clawPosition;

        TPos(String debug, int slidePosition, double armPosition, double clawPosition) {
            this.debug = debug;
            this.slidePosition = slidePosition;
            this.armPosition = armPosition;
            this.clawPosition = clawPosition;
        }

        public String toString() { return debug; }
        public int slidePos() { return slidePosition; }
        public double armPos() { return armPosition; }
        public double clawPos() { return clawPosition; }
    }

    public enum ScoopPos {
        CLOSED("CLOSED", 0),
        INTERMEDIATE("INTERMEDIATE", 1),
        OPEN("OPEN", 2),
        OPEN_WALL("OPEN", 3),
        STACK_PICKUP("STACK_PICKUP", 4);

        private String debug;
        private int index;

        ScoopPos(String debug, int index) {
            this.debug = debug;
            this.index = index;
        }
        public String toString() { return debug; }
        public int index() { return index; }

        public double pos() {
            return scoopPos[index];
        }
    }

    // Slide coefficients
    public static PIDFCoefficients getSlidePIDF() {
        return new PIDFCoefficients(11,0,0,0.0);
    }
}
