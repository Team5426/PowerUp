package org.usfirst.frc.team5426.robot.commands;

import org.usfirst.frc.team5426.robot.Robot;

public class CommandBoom extends CommandBase {
	
	private double triggerDeadzone = Robot.settings.getDouble("TRIGGER_DEADZONE", 0.0);
	
	public CommandBoom() {
		requires(boom);
	}
	
	@Override
	protected void initialize() {
		
	}
	
	@Override
	protected void execute() {
		
		// Grabs the inputs from the left and right triggers and makes sure they
		// are positive numbers
		double left  = Math.abs(Robot.controls.getController().getLeftTrigger());
		double right = Math.abs(Robot.controls.getController().getRightTrigger());
		
		// checks which trigger is pressed more and moves it accordingly
		// while applying a deadzone to prevent accidental presses
		// if none of them are being pressed, ensure the motor is pressed
		if (left > right && left > -triggerDeadzone) boom.adjust(-left);
		else if (right > left && right > triggerDeadzone) boom.adjust(right);
		else boom.adjust(0.0);
	}
	
	@Override
	protected void interrupted() {
		
	}

	@Override
	protected boolean isFinished() {
		
		return false;
	}
}
