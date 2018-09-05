package org.usfirst.frc.team5426.robot.commands;

public class CommandDeployWings extends CommandBase {

	public CommandDeployWings() {
		// require the wing subsystem
		requires(CommandBase.wings);
	}

	protected void initialize() {
		// drop the wings
		wings.deploy();
	}

	protected void execute() {

	}

	protected void end() {

	}

	@Override
	protected boolean isFinished() {

		return true;
	}

}
