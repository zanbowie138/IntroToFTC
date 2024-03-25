package org.firstinspires.ftc.teamcode.teleop_base;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class Teleop extends OpMode {
    private Drive drive;
    private Transport transport;

    @Override
    public void init() {
        drive = new Drive(hardwareMap, telemetry, gamepad1);
        transport = new Transport(hardwareMap, telemetry, gamepad1);
    }

    @Override
    public void loop() {
        drive.update();
        transport.update();
    }
}
