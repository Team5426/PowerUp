package org.usfirst.frc.team5426.robot.auto;

import org.usfirst.frc.team5426.robot.Robot;
import org.usfirst.frc.team5426.robot.commands.auto.AutonomousDrive;
import org.usfirst.frc.team5426.robot.commands.auto.AutonomousDrop;
import org.usfirst.frc.team5426.robot.commands.auto.AutonomousGrab;
import org.usfirst.frc.team5426.robot.commands.auto.AutonomousPause;
import org.usfirst.frc.team5426.robot.commands.auto.AutonomousRaiseElevator;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DropLeft extends CommandGroup {
	
	public DropLeft() {
		this.addSequential(new AutonomousPause(Robot.AUTO_DELAY));
		
		this.addSequential(new AutonomousGrab());
		this.addSequential(new AutonomousRaiseElevator(1.0, 0.8));
		this.addSequential(new AutonomousDrive(0.7, 0.0, 1.2));
		this.addSequential(new AutonomousPause(2));
		this.addSequential(new AutonomousDrive(-1.0, 0.0, 0.3));
		this.addSequential(new AutonomousPause(2));
		this.addSequential(new AutonomousDrive(0.0, 1, 0.6));
		this.addSequential(new AutonomousDrive(-1.0, 0.0, 0.25));
		this.addSequential(new AutonomousPause(0.5));
		this.addSequential(new AutonomousDrive(0.5, 0.0, 0.5));
		this.addSequential(new AutonomousPause(1));
		this.addSequential(new AutonomousDrop());
	}
}
