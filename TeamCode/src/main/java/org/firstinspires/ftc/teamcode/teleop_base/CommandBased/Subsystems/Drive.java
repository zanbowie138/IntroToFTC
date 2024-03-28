package org.firstinspires.ftc.teamcode.teleop_base.CommandBased.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.IMU;
import com.sun.tools.javac.util.List;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import java.util.Arrays;

public class Drive extends SubsystemBase {
    private DcMotorEx leftFront, leftRear, rightFront, rightRear;

    private Telemetry telemetry;

    private List<DcMotorEx> motors;

    private HardwareMap hardwareMap;

    private Gamepad driveGamepad;

    public Drive(HardwareMap hMap, Telemetry telemetry, Gamepad driveGamepad) {
        // Driving motors setup
        rightFront = hMap.get(DcMotorEx.class, "rightFront");
        rightRear = hMap.get(DcMotorEx.class, "rightRear");
        leftFront = hMap.get(DcMotorEx.class, "leftFront");
        leftRear = hMap.get(DcMotorEx.class, "leftRear");

        leftFront.setDirection(DcMotorEx.Direction.REVERSE);
        leftRear.setDirection(DcMotorEx.Direction.REVERSE);
        rightFront.setDirection(DcMotorEx.Direction.FORWARD);
        rightRear.setDirection(DcMotorEx.Direction.FORWARD);

        this.hardwareMap = hMap;
        this.telemetry = telemetry;
        this.driveGamepad = driveGamepad;
    }

    public void setDrivePower(double x, double y, double r, double driveMultiplier) {
        // Denominator is the largest motor power (absolute value) or 1
        // This ensures all the powers maintain the same ratio,
        // but only if at least one is out of the range [-1, 1]
        double denominator = Math.max(Math.abs(x) + Math.abs(y) + Math.abs(r), 1);

        double leftFrontPower =  (y + x + r) / denominator * driveMultiplier;
        double leftBackPower =   (y - x + r) / denominator * driveMultiplier;
        double rightFrontPower = (y - x - r) / denominator * driveMultiplier;
        double rightBackPower =  (y + x - r) / denominator * driveMultiplier;

        telemetry.addData("leftFrontPower: ", leftFrontPower);
        telemetry.addData("leftBackPower: ", leftBackPower);
        telemetry.addData("rightFrontPower: ", rightFrontPower);
        telemetry.addData("rightBackPower: ", rightBackPower);

        this.setMotorPower(leftFrontPower, leftBackPower, rightFrontPower, rightBackPower);
    }

    public void setMotorPower(double lf, double lr, double rf, double rr) {
        leftFront.setPower(lf);
        leftRear.setPower(lr);
        rightFront.setPower(rf);
        rightRear.setPower(rr);
    }

    public void setDrivePower(double x, double y, double r) {
        setMotorPower(x, y, r, 1.0);
    }

    @Override
    public void periodic() {
        setDrivePower(driveGamepad.left_stick_x, driveGamepad.left_stick_y, driveGamepad.right_stick_x);
    }

}
