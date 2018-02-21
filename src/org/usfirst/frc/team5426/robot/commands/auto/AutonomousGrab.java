package org.usfirst.frc.team5426.robot.commands.auto;

import org.usfirst.frc.team5426.robot.commands.CommandBase;

public class AutonomousGrab extends CommandBase {
	
	public AutonomousGrab() {
		requires(CommandBase.grabber);
		
		setInterruptible(false);
	}
	
	protected void initialize() {
		grabber.grab();
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
