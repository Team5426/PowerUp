package org.usfirst.frc.team5426.robot.auto;

import org.usfirst.frc.team5426.robot.Robot;
import org.usfirst.frc.team5426.robot.commands.auto.AutonomousDrive;
import org.usfirst.frc.team5426.robot.commands.auto.AutonomousPause;

import edu.wpi.first.wpilibj.command.CommandGroup;
import enums.Position;

public class CrossLine extends CommandGroup {
	
	public CrossLine(Position start) {
		
		this.addSequential(new AutonomousPause(Robot.AUTO_DELAY));
		
		if (start.equals(Position.MIDDLE)) {
			// turn 90 degrees, move forward then
			// turn -90 degrees then move forward more
		}
		
		else if (start.equals(Position.LEFT)) {
			this.addSequential(new AutonomousDrive(0.5, 0.0, 3));
		}
		
		else if (start.equals(Position.RIGHT)) {
			this.addSequential(new AutonomousDrive(0.5, 0.0, 3));
		}
		
		//this.addSequential(new AutonomousRotateToAngle(90));
		
		
		//this.addSequential(new AutonomousDrive(0.0, 0.5, 3));
		
		//this.addSequential(new AutonomousDrive(0.5, 0.0, 2));
		//this.addSequential(new AutonomousDrive(0.0, -0.5, 3));
		//this.addSequential(new AutonomousDrive(-0.5, 0.0, 3));
		
		// 90 DEGREE AT 12.35V
		// this.addSequential(new AutonomousDrive(0, 0.5, 3));
	}
}
