package org.usfirst.frc.team5426.robot.commands.auto;

import org.usfirst.frc.team5426.robot.commands.CommandBase;

public class AutonomousPause extends CommandBase {
	
	public AutonomousPause(double seconds) {
		this.setTimeout(seconds);
	}

	@Override
	protected boolean isFinished() {
		
		return this.isTimedOut();
	}
}
