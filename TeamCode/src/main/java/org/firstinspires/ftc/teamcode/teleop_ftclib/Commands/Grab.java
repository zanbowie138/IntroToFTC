package org.firstinspires.ftc.teamcode.teleop_ftclib.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.teleop_base.CommandBased.Subsystems.Arm;
import org.firstinspires.ftc.teamcode.teleop_base.CommandBased.Subsystems.Claw;

public class Grab extends CommandBase {
    Arm arm;
    Claw claw;

    public Grab(Arm arm, Claw claw) {
        this.arm = arm;
        this.claw = claw;
    }

    @Override
    public void initialize() {
        arm.grab();
        // TODO: wait a sec
        claw.close();
    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
