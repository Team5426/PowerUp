package org.usfirst.frc.team5426.robot.subsystems;

import org.usfirst.frc.team5426.robot.Robot;
import org.usfirst.frc.team5426.robot.commands.CommandDrive;
import org.usfirst.frc.team5426.robot.commands.auto.AutonomousRecord;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.hal.HAL;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import enums.Source;
import edu.wpi.first.wpilibj.hal.FRCNetComm.tInstances;
import edu.wpi.first.wpilibj.hal.FRCNetComm.tResourceType;

public class DriveTrain extends Subsystem {

	private WPI_TalonSRX LEFT;
	private WPI_TalonSRX RIGHT;

	private SpeedControllerGroup MOTORS;

	private DifferentialDrive drive;

	public DriveTrain() {

		// Defines the drive motor
		LEFT   = new WPI_TalonSRX(1);
		RIGHT  = new WPI_TalonSRX(2);

		// Combines motors into a group
		MOTORS = new SpeedControllerGroup(LEFT, RIGHT);

		// Defines robot drive
		drive = new DifferentialDrive(LEFT, RIGHT);-
	}

	// this method uses the joystick inputs and moves the robot
	public void drive(double speed, double twist) {

		drive.arcadeDrive(-twist, speed);

		// if an auto routine is in progress, update it
		if (AutonomousRecord.routine != null) {
			AutonomousRecord.routine.handleInstruction(Source.DRIVETRAIN, -twist + "," + speed);
		}
	}

	// stop the robot
	public void stop() {
		MOTORS.set(0.0);
	}

	public void initDefaultCommand() {
		this.setDefaultCommand(new CommandDrive());
	}

	public WPI_TalonSRX getLeft() {
		return LEFT;
	}

	public WPI_TalonSRX getRight() {
		return RIGHT;
	}

}
