package org.usfirst.frc.team5426.robot.commands.auto;

import org.usfirst.frc.team5426.robot.Robot;
import org.usfirst.frc.team5426.robot.commands.CommandBase;

public class AutoDelaySetter extends CommandBase {
	
	private double delay;
	
	public AutoDelaySetter(double delay) {
		this.delay = delay;
	}
	
	protected void initialize() {
		Robot.setAutoDelay(delay);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
