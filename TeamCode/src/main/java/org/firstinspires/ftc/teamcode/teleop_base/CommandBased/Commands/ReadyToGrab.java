package org.firstinspires.ftc.teamcode.teleop_base.CommandBased.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.teleop_base.CommandBased.Subsystems.Arm;
import org.firstinspires.ftc.teamcode.teleop_base.CommandBased.Subsystems.Claw;

public class ReadyToGrab extends CommandBase {
    private Arm arm;
    private Claw claw;
    private ElapsedTime timer = new ElapsedTime();

    private final double TIME_TO_READY_TO_GRAB = 1;
    public ReadyToGrab(Arm arm, Claw claw) {
        this.arm = arm;
        this.claw = claw;
        addRequirements(arm);
    }

    @Override
    public void initialize() {
        arm.idle();
        claw.openLeft();
        claw.openRight();
    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return timer.seconds() > TIME_TO_READY_TO_GRAB;
    }

}
