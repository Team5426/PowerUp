package org.usfirst.frc.team5426.robot.commands;

import org.usfirst.frc.team5426.robot.Robot;

import enums.AutoMode;

public class AutoModeSetter extends CommandBase {
	
	private AutoMode autoMode;
	
	public AutoModeSetter(AutoMode mode) {
		this.autoMode = mode;
	}
	
	protected void initialize() {
		Robot.setAutoMode(autoMode);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
