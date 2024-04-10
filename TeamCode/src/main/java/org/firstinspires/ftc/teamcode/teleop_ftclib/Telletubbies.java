package org.firstinspires.ftc.teamcode.teleop_base.CommandBased;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.teleop_base.CommandBased.Commands.DriveCommand;
import org.firstinspires.ftc.teamcode.teleop_base.CommandBased.Commands.Grab;
import org.firstinspires.ftc.teamcode.teleop_base.CommandBased.Commands.ReadyToGrab;
import org.firstinspires.ftc.teamcode.teleop_base.CommandBased.Commands.ReadyToPlace;
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
        driverGamepad = new GamepadEx(gamepad1);
        operatorGamepad = new GamepadEx(gamepad2);

        drive = new Drive(hardwareMap, telemetry, gamepad1);
        arm = new Arm(hardwareMap);
        claw = new Claw(hardwareMap);

        operatorGamepad.getGamepadButton(GamepadKeys.Button.A).whenPressed(new ReadyToGrab(arm, claw));
        operatorGamepad.getGamepadButton(GamepadKeys.Button.X).whenPressed(new Grab(arm, claw));
        operatorGamepad.getGamepadButton(GamepadKeys.Button.Y).whenPressed(new ReadyToPlace(arm));
        operatorGamepad.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenPressed(new InstantCommand(() -> claw.close()));
        operatorGamepad.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenPressed(new InstantCommand(() -> claw.open()));
        drive.setDefaultCommand(new DriveCommand(drive));
    }

    @Override
    public void loop() {

    }
}
