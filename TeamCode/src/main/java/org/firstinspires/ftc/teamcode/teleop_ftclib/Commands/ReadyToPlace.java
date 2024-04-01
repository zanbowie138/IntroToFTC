package org.firstinspires.ftc.teamcode.teleop_ftclib.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.teleop_ftclib.Subsystems.Arm;

public class ReadyToPlace extends CommandBase {
    private Arm arm;
    private ElapsedTime timer = new ElapsedTime();
    private final double TIME_TO_DEPOSIT = 1;

    public ReadyToPlace(Arm arm) {
        this.arm = arm;
        addRequirements(arm);
    }

    @Override
    public void initialize() {
        arm.deposit();
    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return timer.seconds() > TIME_TO_DEPOSIT;
    }

}
