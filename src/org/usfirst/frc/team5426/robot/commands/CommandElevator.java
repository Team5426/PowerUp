package org.usfirst.frc.team5426.robot.commands;

import org.usfirst.frc.team5426.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;

public class CommandElevator extends CommandBase {
	
	private double speed = 0.5;
	
	public CommandElevator() {
		requires(elevator);
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		
		if (DriverStation.getInstance().isOperatorControl()) {
			
			boolean leftBumperState  = Robot.controls.getController().bumper_left.get();
			boolean rightBumperState = Robot.controls.getController().bumper_right.get();
			
			if (leftBumperState && rightBumperState) elevator.stop();
			else if (leftBumperState) elevator.set(-speed);
			else if (rightBumperState) elevator.set(speed);
			else elevator.stop();
		}
	}
	
	protected void interrupted() {
		
	}

	@Override
	protected boolean isFinished() {
		
		return false;
	}

}