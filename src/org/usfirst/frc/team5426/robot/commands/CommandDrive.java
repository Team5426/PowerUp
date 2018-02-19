package org.usfirst.frc.team5426.robot.commands;

import org.usfirst.frc.team5426.robot.Robot;

import edu.wpi.first.wpilibj.Timer;

public class CommandDrive extends CommandBase {
	
	public CommandDrive() {
		requires(CommandBase.driveTrain);
	}
	
	protected void initialize() {
		
	}

	protected void execute() {
		
		driveTrain.drive(Robot.controls.getXAxis(), Robot.controls.getYAxis());
		
		Timer.delay(0.005);
	}
	
	protected void interupted() {
		
	}
	
	protected void end() {
		
	}

	protected boolean isFinished() {
		return false;
	}

}