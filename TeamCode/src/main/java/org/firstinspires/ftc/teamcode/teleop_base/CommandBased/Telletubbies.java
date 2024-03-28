package org.firstinspires.ftc.teamcode.teleop_base.CommandBased;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.teleop_base.CommandBased.Subsystems.Arm;
import org.firstinspires.ftc.teamcode.teleop_base.CommandBased.Subsystems.Claw;
import org.firstinspires.ftc.teamcode.teleop_base.CommandBased.Subsystems.Drive;

@TeleOp(name = "Telletubbies", group = "Command")
public class Telletubbies extends OpMode {
    private Drive drive;
    private Arm arm;
    private Claw claw;
    private GamepadEx driverGamepad;
    private GamepadEx operatorGamepad;

    @Override
    public void init() {


        drive = new Drive(hardwareMap, telemetry, gamepad1);
        arm = new Arm(hardwareMap);
        claw = new Claw(hardwareMap);
    }

    @Override
    public void loop() {

    }
}
