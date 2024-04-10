package org.firstinspires.ftc.teamcode.teleop_base.CommandBased.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.teleop_base.CommandBased.Subsystems.Drive;

public class DriveCommand extends CommandBase {

    private Drive drive;

    public DriveCommand(Drive drive) {
        this.drive = drive;
        addRequirements(drive);
    }

    public void execute() {
        drive.setDrivePower();
    }
}
