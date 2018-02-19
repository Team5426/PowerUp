package org.usfirst.frc.team5426.robot.commands;

public class CommandDeployWings extends CommandBase {
	
	public CommandDeployWings() {
		requires(CommandBase.wings);
	}
	
	protected void initialize() {
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
