package org.usfirst.frc.team5426.robot.subsystems;

import org.usfirst.frc.team5426.robot.commands.CommandDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

public class DriveTrain extends Subsystem {
	
	private WPI_TalonSRX FRONT_LEFT;
	private WPI_TalonSRX FRONT_RIGHT;
	private WPI_TalonSRX REAR_LEFT;
	private WPI_TalonSRX REAR_RIGHT;
	
	private MecanumDrive robotDrive;
	
	public DriveTrain() {
		
		FRONT_LEFT  = new WPI_TalonSRX(1);
		FRONT_RIGHT = new WPI_TalonSRX(2);
		REAR_LEFT   = new WPI_TalonSRX(3);
		REAR_RIGHT  = new WPI_TalonSRX(4);
		
		robotDrive = new MecanumDrive(FRONT_LEFT, REAR_LEFT, FRONT_RIGHT, REAR_RIGHT);
	}
	
	public void drive(double x, double y, double z) {
		
		robotDrive.driveCartesian(x, y, z);
	}
	
	@Override
	protected void initDefaultCommand() {
		this.setDefaultCommand(new CommandDrive());
	}
	
	public WPI_TalonSRX getFrontLeft() {
		return FRONT_LEFT;
	}
	
	public WPI_TalonSRX getFrontRight() {
		return FRONT_RIGHT;
	}
	
	public WPI_TalonSRX getRearLeft() {
		return REAR_LEFT;
	}
	
	public WPI_TalonSRX getRearRight() {
		return REAR_RIGHT;
	}

}