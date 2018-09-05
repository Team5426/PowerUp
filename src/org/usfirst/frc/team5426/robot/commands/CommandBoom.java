package org.usfirst.frc.team5426.robot.commands;

import org.usfirst.frc.team5426.robot.Robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;

public class CommandBoom extends CommandBase {

	// Retrieve trigger deadzone from the dashboard
	private double triggerDeadzone = Robot.settings.getDouble("TRIGGER_DEADZONE", 0.0);

	public CommandBoom() {
		requires(boom);
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		double left = Math.abs(Robot.controls.getController().getLeftTrigger());
		double right = Math.abs(Robot.controls.getController().getRightTrigger());

		// if left has a higher value than right and left is greater than the
		// deadzone, the boom is moved to the left.
		if (left > right && left > triggerDeadzone)
			boom.adjust(-left);

		// if right has a higher value than left and right is greater than the
		// deadzone, the boom is moved to the right.
		else if (right > left && right > triggerDeadzone)
			boom.adjust(right);
			
		// Otherwise, stop the boom.
		else
			boom.adjust(0.0);
	}

	@Override
	protected void interrupted() {

	}

	@Override
	protected boolean isFinished() {

		return false;
	}
}
