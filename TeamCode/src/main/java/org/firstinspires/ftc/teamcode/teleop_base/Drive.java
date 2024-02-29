package org.firstinspires.ftc.teamcode.teleop_base;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class Drive extends OpMode {
    private DcMotorEx leftFront, leftRear, rightRear, rightFront;

    @Override
    public void init() {
        leftFront = hardwareMap.get(DcMotorEx.class, "leftFront");
        leftRear = hardwareMap.get(DcMotorEx.class, "leftRear");
        rightRear = hardwareMap.get(DcMotorEx.class, "rightRear");
        rightFront = hardwareMap.get(DcMotorEx.class, "rightFront");
    }

    @Override
    public void loop() {
        telemetry.addData("Gamepad 1 y", gamepad1.left_stick_y);
    }
}
