package org.usfirst.frc.team5426.robot.commands.auto;

import org.usfirst.frc.team5426.robot.commands.CommandBase;

public class AutonomousDrop extends CommandBase {
	
	public AutonomousDrop() {
		requires(CommandBase.grabber);
		
		setInterruptible(false);
	}
	
	protected void initialize() {
		grabber.release();
	}
	
	protected void execute() {
		
	}
	
	protected void end() {
		
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
