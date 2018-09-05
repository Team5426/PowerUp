package org.usfirst.frc.team5426.robot.commands;

public class CommandMobyDick extends CommandBase {

	public CommandMobyDick() {
		requires(CommandBase.harpoon);
	}

	protected void initialize() {

	}

	protected void execute() {

		// Fires the harpoon
		harpoon.shoot();
	}

	protected void end() {

	}

	@Override
	protected boolean isFinished() {

		return true;
	}
}
