package org.usfirst.frc.team5426.robot.subsystems;

import org.usfirst.frc.team5426.robot.Robot;
import org.usfirst.frc.team5426.robot.commands.CommandBoom;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Boom extends Subsystem {
	
	private WPI_TalonSRX motor;
	
	public Boom() {
		motor = new WPI_TalonSRX(Robot.settings.getInt("TALON_BOOM", -1));
	}
	
	public void adjust(double speed) {
		motor.set(speed);
	}

	@Override
	protected void initDefaultCommand() {
		this.setDefaultCommand(new CommandBoom());
	}

}
