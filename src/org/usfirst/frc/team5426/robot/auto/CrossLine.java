package org.usfirst.frc.team5426.robot.auto;

import org.usfirst.frc.team5426.robot.Robot;
import org.usfirst.frc.team5426.robot.commands.auto.AutonomousDrive;
import org.usfirst.frc.team5426.robot.commands.auto.AutonomousPause;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CrossLine extends CommandGroup {
	
	public CrossLine() {
		this.addSequential(new AutonomousPause(Robot.AUTO_DELAY));
		
		//this.addSequential(new AutonomousRotateToAngle(90));
		
		this.addSequential(new AutonomousDrive(0.5, 0.0, 3));
		//this.addSequential(new AutonomousDrive(0.0, 0.5, 3));
		
		//this.addSequential(new AutonomousDrive(0.5, 0.0, 2));
		//this.addSequential(new AutonomousDrive(0.0, -0.5, 3));
		//this.addSequential(new AutonomousDrive(-0.5, 0.0, 3));
		
		// 90 DEGREE AT 12.35V
		// this.addSequential(new AutonomousDrive(0, 0.5, 3));
	}
}
