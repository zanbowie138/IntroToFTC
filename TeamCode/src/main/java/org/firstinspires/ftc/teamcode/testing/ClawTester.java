package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class ClawTester extends OpMode {
    private Servo clawServo;
    private double clawPos = 0.5;

    @Override
    public void init() {
        clawServo = hardwareMap.get(Servo.class, "clawServo");
    }

    @Override
    public void loop() {
        clawPos += -gamepad1.left_stick_y * 0.001;
        telemetry.addData("Claw Position", clawPos);
    }
}
