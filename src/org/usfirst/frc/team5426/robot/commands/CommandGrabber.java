package org.usfirst.frc.team5426.robot.commands;

public class CommandGrabber extends CommandBase {
	
	public CommandGrabber() {
		requires(grabber);
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		
		if (grabber.isReleased()) grabber.grab();
		else if (grabber.isGrabbing()) grabber.release();
	}
	
	protected void interrupted() {
		
	}
	
	protected void end() {
		
	}

	@Override
	protected boolean isFinished() {
		
		return true;
	}
}
