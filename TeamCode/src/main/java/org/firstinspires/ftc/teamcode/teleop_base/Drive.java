package org.firstinspires.ftc.teamcode.teleop_base;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Drive {
    private DcMotorEx leftFront, leftRear, rightRear, rightFront;
    private Gamepad gamepad1;
    private Telemetry telemetry;

    public Drive(HardwareMap hardwareMap, Telemetry telemetry, Gamepad gamepad1) {
        leftFront = hardwareMap.get(DcMotorEx.class, "leftFront");
        leftRear = hardwareMap.get(DcMotorEx.class, "leftRear");
        rightRear = hardwareMap.get(DcMotorEx.class, "rightRear");
        rightFront = hardwareMap.get(DcMotorEx.class, "rightFront");

        this.telemetry = telemetry;
        this.gamepad1 = gamepad1;
    }

    public void update() {
        double forward = -gamepad1.left_stick_y; // Remember, Y stick is reversed!
        double strafe = gamepad1.left_stick_x;
        double rotation = gamepad1.right_stick_x;

        leftFront.setPower(forward + strafe + rotation);
        leftRear.setPower(forward - strafe + rotation);
        rightRear.setPower(forward - strafe - rotation);
        rightFront.setPower(forward + strafe - rotation);
    }
}
