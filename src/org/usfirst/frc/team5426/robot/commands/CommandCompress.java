package org.usfirst.frc.team5426.robot.commands;

public class CommandCompress extends CommandBase {
	
	public CommandCompress() {
		requires(pneumatics);
	}
	
	protected void initialize() {
		pneumatics.compress();
	}
	
	protected void execute() {
		System.out.println("Compressor should be running: " + pneumatics.getSwitchStatus());
	}
	
	protected void end() {
		pneumatics.stop();
	}
	
	protected void interrupted() {
		
	}
	
	protected boolean isFinished() {
		
		return pneumatics.getSwitchStatus();
	}
}
