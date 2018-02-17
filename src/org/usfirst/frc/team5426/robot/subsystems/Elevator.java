package org.usfirst.frc.team5426.robot.subsystems;

import org.usfirst.frc.team5426.robot.Robot;
import org.usfirst.frc.team5426.robot.commands.CommandElevator;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {
	
	private WPI_TalonSRX motor;
	
	private DigitalInput limiter;
	
	public Elevator() {
		motor = new WPI_TalonSRX(Robot.settings.getInt("TALON_ELEVATOR", -1));
		
		limiter = new DigitalInput(0);
	}
	
	public void adjust(double speed) {
		if (limiter.get()) {
			stop();
			return;
		}
		
		motor.set(speed);
	}
	
	public void stop() {
		motor.set(0.0);
	}

	@Override
	protected void initDefaultCommand() {
		this.setDefaultCommand(new CommandElevator());
	}
}
