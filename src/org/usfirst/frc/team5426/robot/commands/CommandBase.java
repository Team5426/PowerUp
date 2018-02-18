package org.usfirst.frc.team5426.robot.commands;

import org.usfirst.frc.team5426.robot.subsystems.Boom;
import org.usfirst.frc.team5426.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5426.robot.subsystems.Elevator;
import org.usfirst.frc.team5426.robot.subsystems.Grabber;
import org.usfirst.frc.team5426.robot.subsystems.Pneumatics;
import org.usfirst.frc.team5426.robot.subsystems.Winch;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

public abstract class CommandBase extends Command {
	
	protected static DriveTrain driveTrain;
	protected static Winch winch;
	protected static Grabber grabber;
	protected static Elevator elevator;
	protected static Boom boom;
	protected static Pneumatics pneumatics;
	
	protected static MecanumDrive drive;
	
	public CommandBase() {
		
		driveTrain = new DriveTrain();
		winch = new Winch();
		grabber = new Grabber();
		elevator = new Elevator();
		boom = new Boom();
		pneumatics = new Pneumatics();
		
		drive = new MecanumDrive(
			driveTrain.getFrontLeft(),
			driveTrain.getRearLeft(), 
			driveTrain.getFrontRight(), 
			driveTrain.getRearRight()
		);
	}
}