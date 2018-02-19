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
		
		System.out.println("new AutonomousDrive()");
	}
	
	protected void initialize() {
		System.out.println("initialize()");
	}
	
	protected void execute() {
		driveTrain.drive(rotation, -speed);
		System.out.println("execute()");
	}
	
	protected void end() {
		driveTrain.stop();
		System.out.println("end()");
	}
	
	@Override
	protected boolean isFinished() {
		System.out.println("isFinished(): " + this.isTimedOut());
		return this.isTimedOut();
	}
}
