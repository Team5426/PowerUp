package org.usfirst.frc.team5426.robot.commands;

import org.usfirst.frc.team5426.robot.subsystems.Boom;
import org.usfirst.frc.team5426.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5426.robot.subsystems.Elevator;
import org.usfirst.frc.team5426.robot.subsystems.Grabber;
import org.usfirst.frc.team5426.robot.subsystems.Harpoon;
import org.usfirst.frc.team5426.robot.subsystems.Pneumatics;
import org.usfirst.frc.team5426.robot.subsystems.Winch;
import org.usfirst.frc.team5426.robot.subsystems.Wings;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

public abstract class CommandBase extends Command {
	
	public static DriveTrain driveTrain;
	public static Winch winch;
	public static Grabber grabber;
	public static Elevator elevator;
	public static Boom boom;
	public static Wings wings;
	public static Harpoon harpoon;
	public static Pneumatics pneumatics;
	
	public static MecanumDrive drive;
	
	public static void init() {
		pneumatics = new Pneumatics();
		driveTrain = new DriveTrain();
		grabber = new Grabber();
		elevator = new Elevator();
		winch = new Winch();
		boom = new Boom();
		wings = new Wings();
		harpoon = new Harpoon();
	}
}