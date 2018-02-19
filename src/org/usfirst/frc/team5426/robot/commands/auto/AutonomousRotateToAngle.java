package org.usfirst.frc.team5426.robot.commands.auto;

import org.usfirst.frc.team5426.robot.commands.CommandBase;

public class AutonomousRotateToAngle extends CommandBase {
	
	private int angle;
	
	private double kP = 1;
	private double error = 0;
	private double threshold = 3;
	private double rotation = 0;
	
	public AutonomousRotateToAngle(int angle) {
		requires(CommandBase.driveTrain);
		
		this.angle = angle;
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		System.out.println("Current Angle: " + driveTrain.gyro.getAngle());
		
		error = this.angle - CommandBase.driveTrain.gyro.getAngle();
		
		System.out.println("Error: " + error);
		
		if (error > threshold) {
			this.rotation = error * kP;
			
			System.out.println("Need to rotate: " + this.rotation);
		}
		
		else {
			this.rotation = 0;
		}
		
		driveTrain.drive(this.rotation, 0.0);
	}
	
	protected void end() {
		
	}
	
	@Override
	protected boolean isFinished() {
		return this.rotation == 0;
	}
}
