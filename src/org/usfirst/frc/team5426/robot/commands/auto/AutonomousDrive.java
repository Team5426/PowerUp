package org.usfirst.frc.team5426.robot.commands.auto;

import org.usfirst.frc.team5426.robot.commands.CommandBase;

public class AutonomousDrive extends CommandBase {
	
	private double speed;
	private double rotation;
	
	public AutonomousDrive(double speed, double rotation, double seconds) {
		requires(CommandBase.driveTrain);
		
		setTimeout(seconds);
		setInterruptible(false);
		
		this.speed = speed;
		this.rotation = rotation;
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		driveTrain.drive(rotation, -speed);
	}
	
	protected void end() {
		driveTrain.stop();
	}
	
	@Override
	protected boolean isFinished() {
		return this.isTimedOut();
	}
}
