package org.usfirst.frc.team5426.robot.subsystems;

import org.usfirst.frc.team5426.robot.Robot;
import org.usfirst.frc.team5426.robot.commands.CommandDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.hal.HAL;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.hal.FRCNetComm.tInstances;
import edu.wpi.first.wpilibj.hal.FRCNetComm.tResourceType;

public class DriveTrain extends Subsystem {
	
	private WPI_TalonSRX FRONT_LEFT;
	private WPI_TalonSRX FRONT_RIGHT;
	private WPI_TalonSRX REAR_LEFT;
	private WPI_TalonSRX REAR_RIGHT;
	
	private SpeedControllerGroup LEFT_MOTORS;
	private SpeedControllerGroup RIGHT_MOTORS;
	private SpeedControllerGroup MOTORS;
	
	public ADXRS450_Gyro gyro;
	
	private DifferentialDrive drive;
	
	public DriveTrain() {
		
		FRONT_LEFT  = new WPI_TalonSRX(1);
		FRONT_RIGHT = new WPI_TalonSRX(2);
		REAR_LEFT   = new WPI_TalonSRX(3);
		REAR_RIGHT  = new WPI_TalonSRX(4);
		
		LEFT_MOTORS = new SpeedControllerGroup(FRONT_LEFT, REAR_LEFT);
		RIGHT_MOTORS = new SpeedControllerGroup(FRONT_RIGHT, REAR_RIGHT);
		MOTORS = new SpeedControllerGroup(FRONT_LEFT, REAR_LEFT, FRONT_RIGHT, REAR_RIGHT);
		
		gyro = new ADXRS450_Gyro(Port.kOnboardCS0);
		gyro.calibrate();
		
		drive = new DifferentialDrive(LEFT_MOTORS, RIGHT_MOTORS);
	}
	
	public void drive(double speed, double twist) {
		
		drive.arcadeDrive(speed, twist);
		
		SmartDashboard.putNumber("FRONT_LEFT", FRONT_LEFT.get());
		SmartDashboard.putNumber("FRONT_RIGHT", FRONT_RIGHT.get());
		SmartDashboard.putNumber("REAR_LEFT", REAR_LEFT.get());
		SmartDashboard.putNumber("REAR_RIGHT", REAR_RIGHT.get());
		
		drive.arcadeDrive(speed, twist);
	}
	
	public void stop() {
		MOTORS.set(0.0);
	}
	
	public void initDefaultCommand() {
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