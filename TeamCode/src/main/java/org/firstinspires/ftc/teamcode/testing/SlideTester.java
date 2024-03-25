package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

@TeleOp
public class SlideTester extends OpMode {
    private DcMotorEx slideMotorLeft, slideMotorRight;
    @Override
    public void init() {
        slideMotorLeft = hardwareMap.get(DcMotorEx.class, "slideLeft");
        slideMotorLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        slideMotorLeft.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        slideMotorLeft.setPIDFCoefficients(DcMotorEx.RunMode.RUN_TO_POSITION, new PIDFCoefficients(1, 0, 0, 0));
        slideMotorLeft.setTargetPosition(0);
        slideMotorLeft.setPower(1);
        slideMotorLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
    }

    @Override
    public void loop() {
        telemetry.addData("Left Slide Motor Position", slideMotorLeft.getCurrentPosition());
    }
}
