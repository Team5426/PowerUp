package org.usfirst.frc.team5426.robot.commands.auto;

import org.usfirst.frc.team5426.robot.commands.CommandBase;

public class AutonomousRaiseElevator extends CommandBase {
	
	private double speed = 0;
	private double seconds = 0;
	
	public AutonomousRaiseElevator(double speed, double seconds) {
		setInterruptible(false);
		setTimeout(seconds);
		
		this.speed = speed;
		this.seconds = seconds;
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		elevator.set(this.speed);
	}
	
	protected void end() {
		elevator.stop();
	}

	@Override
	protected boolean isFinished() {
		
		return this.isTimedOut();
	}

}
