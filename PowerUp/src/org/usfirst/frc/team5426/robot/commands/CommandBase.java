package org.usfirst.frc.team5426.robot.commands;

import org.usfirst.frc.team5426.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5426.robot.subsystems.Winch;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

public abstract class CommandBase extends Command {
	
	public DriveTrain driveTrain;
	public Winch winch;
	
	public MecanumDrive drive;
	
	public CommandBase() {
		
		driveTrain = new DriveTrain();
		winch = new Winch();
		
		drive = new MecanumDrive(
			driveTrain.getFrontLeft(),
			driveTrain.getRearLeft(), 
			driveTrain.getFrontRight(), 
			driveTrain.getRearRight()
		);	
	}
}
