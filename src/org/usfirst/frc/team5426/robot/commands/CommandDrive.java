package org.usfirst.frc.team5426.robot.commands;

import org.usfirst.frc.team5426.robot.Robot;

import edu.wpi.first.wpilibj.Timer;

public class CommandDrive extends CommandBase {
	
	public CommandDrive() {
		
		requires(driveTrain);
	}
	
	@Override
	public void initialize() {
		
	}
	
	@Override
	public void execute() {
		
		drive.driveCartesian(
			Robot.controls.getYAxis(),
			Robot.controls.getXAxis(),
			Robot.controls.getTwist()
		);
		
		Timer.delay(0.005);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

}