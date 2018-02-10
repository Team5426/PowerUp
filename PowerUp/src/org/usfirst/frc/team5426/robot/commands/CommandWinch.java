package org.usfirst.frc.team5426.robot.commands;

import enums.Direction;

public class CommandWinch extends CommandBase {
	
	private double power;
	
	public CommandWinch(Direction direction, double timeout) {
		requires(winch);
		
		double powerInitial = 0.5;
		double powerMultiplier;
		
		switch (direction.toString()) {
			case "FORWARD":
				powerMultiplier = 1.0;
				break;
			case "BACKWARDS":
				powerMultiplier = -1.0;
				break;
			default:
				powerMultiplier = 0;
				break;
		}
		
		power = powerInitial * powerMultiplier;
		
		this.setTimeout(timeout);
	}
	
	@Override
	protected void initialize() {
		
	}
	
	@Override
	protected void execute() {
		winch.start(power);
	}
	
	@Override
	protected void interrupted() {
		end();
	}
	
	@Override
	protected void end() {
		winch.stop();
	}

	@Override
	protected boolean isFinished() {
		
		return this.isCanceled() || this.isTimedOut();
	}
}
