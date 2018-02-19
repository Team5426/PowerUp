package org.usfirst.frc.team5426.robot.commands;

import org.usfirst.frc.team5426.robot.Robot;

public class CommandElevator extends CommandBase {
	
	private double speed = 0.5;
	
	public CommandElevator() {
		requires(elevator);
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		
		boolean leftBumperState  = Robot.controls.getController().bumper_left.get();
		boolean rightBumperState = Robot.controls.getController().bumper_right.get();
		
		if (leftBumperState && rightBumperState) elevator.stop();
		else if (leftBumperState) elevator.adjust(-speed);
		else if (rightBumperState) elevator.adjust(speed);
		else elevator.stop();
	}
	
	protected void interrupted() {
		
	}

	@Override
	protected boolean isFinished() {
		
		return false;
	}

}