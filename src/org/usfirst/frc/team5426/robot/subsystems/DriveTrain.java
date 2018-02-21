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
	
	private WPI_TalonSRX LEFT;
	private WPI_TalonSRX RIGHT;

	private SpeedControllerGroup MOTORS;
	
	public ADXRS450_Gyro gyro;
	
	private DifferentialDrive drive;
	
	public DriveTrain() {
		
		LEFT   = new WPI_TalonSRX(1);
		RIGHT  = new WPI_TalonSRX(2);
		
		MOTORS = new SpeedControllerGroup(LEFT, RIGHT);
		
		gyro = new ADXRS450_Gyro(Port.kOnboardCS0);
		gyro.calibrate();
		
		drive = new DifferentialDrive(LEFT, RIGHT);
		//drive.setSafetyEnabled(false);
	}
	
	public void drive(double speed, double twist) {
		
		drive.arcadeDrive(-twist, speed);
	}
	
	public void stop() {
		MOTORS.set(0.0);
	}
	
	public void initDefaultCommand() {
		//this.setDefaultCommand(new CommandDrive());
	}
	
	public WPI_TalonSRX getLeft() {
		return LEFT;
	}
	
	public WPI_TalonSRX getRight() {
		return RIGHT;
	}

}