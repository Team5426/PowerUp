package org.usfirst.frc.team5426.robot.auto;

import org.usfirst.frc.team5426.robot.Robot;
import org.usfirst.frc.team5426.robot.commands.auto.AutonomousDrive;
import org.usfirst.frc.team5426.robot.commands.auto.AutonomousDrop;
import org.usfirst.frc.team5426.robot.commands.auto.AutonomousPause;
import org.usfirst.frc.team5426.robot.commands.auto.AutonomousRaiseElevator;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StraightDrop extends CommandGroup {
	
	public StraightDrop() {
		this.addSequential(new AutonomousPause(Robot.AUTO_DELAY));
		
		this.addSequential(new AutonomousRaiseElevator(1.0, 0.8));
		this.addSequential(new AutonomousDrive(0.7, 0.0, 1));		
		this.addSequential(new AutonomousPause(2));
		this.addSequential(new AutonomousDrop());
		
		//Timer.delay(2.0);
		
		//this.addSequential(new AutonomousDrop());
		
		//this.addSequential(new AutonomousDrive(0.1, 0.0, 1.0));
		//this.addSequential(new AutonomousRaiseElevator());
	}
}
