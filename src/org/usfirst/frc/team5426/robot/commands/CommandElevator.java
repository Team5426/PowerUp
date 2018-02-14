package org.usfirst.frc.team5426.robot.commands;

import org.usfirst.frc.team5426.robot.Robot;

public class CommandElevator extends CommandBase {
	
	public CommandElevator() {
		requires(elevator);
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		
		boolean leftBumperState  = Robot.controls.getController().bumper_left.get();
		boolean rightBumperState = Robot.controls.getController().bumper_left.get();
		
		if (leftBumperState && rightBumperState) elevator.adjust(0.0);
		else if (leftBumperState) elevator.adjust(-1.0);
		else if (rightBumperState) elevator.adjust(1.0);
		else elevator.adjust(0.0);
	}
	
	protected void interrupted() {
		
	}

	@Override
	protected boolean isFinished() {
		
		return false;
	}

}
