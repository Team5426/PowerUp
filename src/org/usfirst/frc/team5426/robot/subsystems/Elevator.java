package org.usfirst.frc.team5426.robot.subsystems;

import org.usfirst.frc.team5426.robot.Robot;
import org.usfirst.frc.team5426.robot.commands.CommandElevator;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {
	
	private WPI_TalonSRX motor;
	
	public Elevator() {
		motor = new WPI_TalonSRX(Robot.settings.getInt("TALON_ELEVATOR", -1));
	}
	
	public void adjust(double speed) {
		motor.set(speed);
	}

	@Override
	protected void initDefaultCommand() {
		this.setDefaultCommand(new CommandElevator());
	}
}
