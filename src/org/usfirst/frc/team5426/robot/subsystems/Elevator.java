package org.usfirst.frc.team5426.robot.subsystems;

import org.usfirst.frc.team5426.robot.Robot;
import org.usfirst.frc.team5426.robot.commands.CommandElevator;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {
	
	private WPI_TalonSRX motor;
	
	public DigitalInput limiter;
	
	//public Position position;
	
	public Elevator() {
		motor = new WPI_TalonSRX(Robot.settings.getInt("TALON_ELEVATOR", -1));
		
		limiter = new DigitalInput(0);
	}
	
	public void stop() {
		motor.set(0.0);
	}
	
	public void adjust(double speed) {
		motor.set(speed);
	}
	
	/*public void up() {
		motor.set(0.5);
	}
	
	public void down() {
		motor.set(-0.5);
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
	
	public Position getPosition() {
		return position;
	}*/

	@Override
	protected void initDefaultCommand() {
		this.setDefaultCommand(new CommandElevator());
	}
}
