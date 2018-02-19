package org.usfirst.frc.team5426.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class CommandGrabber extends CommandBase {
	
	public CommandGrabber() {
		requires(CommandBase.grabber);
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		
		DoubleSolenoid.Value value = grabber.getSolenoid().get();
		
		if (value == DoubleSolenoid.Value.kForward) grabber.release();
		else if (value == DoubleSolenoid.Value.kReverse) grabber.grab();
		else if (value == DoubleSolenoid.Value.kOff) grabber.grab();
		
		//if (grabber.isReleased()) grabber.grab();
		//else if (grabber.isGrabbing()) grabber.release();
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
