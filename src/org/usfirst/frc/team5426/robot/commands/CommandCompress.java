package org.usfirst.frc.team5426.robot.commands;

public class CommandCompress extends CommandBase {
	
	public CommandCompress() {
		requires(pneumatics);
	}
	
	protected void initialize() {
		pneumatics.start();
	}
	
	protected void execute() {
		
	}
	
	protected void end() {
		pneumatics.stop();
	}
	
	protected void interrupted() {
		
	}
	
	protected boolean isFinished() {
		if (this.isCanceled()) return true;
		
		System.out.println(pneumatics.getSwitchStatus());
		return pneumatics.getSwitchStatus();
	}
}
