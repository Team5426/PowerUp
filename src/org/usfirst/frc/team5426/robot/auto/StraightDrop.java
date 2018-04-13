package org.usfirst.frc.team5426.robot.auto;

import org.usfirst.frc.team5426.robot.Robot;
import org.usfirst.frc.team5426.robot.commands.auto.AutonomousDrive;
import org.usfirst.frc.team5426.robot.commands.auto.AutonomousDrop;
import org.usfirst.frc.team5426.robot.commands.auto.AutonomousGrab;
import org.usfirst.frc.team5426.robot.commands.auto.AutonomousPause;
import org.usfirst.frc.team5426.robot.commands.auto.AutonomousRaiseElevator;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import enums.Position;

public class StraightDrop extends CommandGroup {
	
	public StraightDrop(Position startPosition, Position switchPosition) {
		
		this.addSequential(new AutonomousPause(Robot.AUTO_DELAY));
		
		//this.addSequential(new AutonomousRaiseElevator(1.0, 0.9));
		this.addSequential(new AutonomousRaiseElevator(0.5, 1.5));
		this.addSequential(new AutonomousGrab());
		this.addSequential(new AutonomousDrive(0.7, 0.0, 1.75));
		this.addSequential(new AutonomousDrive(0.0, 0.0, 1.0));
		this.addSequential(new AutonomousDrive(0.6, 0.0, 1.5));
		this.addSequential(new AutonomousDrop());
		
		//this.addSequential(new AutonomousPause(2));
		//this.addSequential(new AutonomousDrop());
		
		//Timer.delay(2.0);
		
		//this.addSequential(new AutonomousDrop());
		
		//this.addSequential(new AutonomousDrive(0.1, 0.0, 1.0));
		//this.addSequential(new AutonomousRaiseElevator());
	}
}
