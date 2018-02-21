package org.usfirst.frc.team5426.robot.subsystems;

import org.usfirst.frc.team5426.robot.Robot;
import org.usfirst.frc.team5426.robot.commands.CommandBoom;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Boom extends Subsystem {
	
	private WPI_TalonSRX motor;
	
	public DigitalInput limiterTop;
	public DigitalInput limiterBottom;
	
	public Boom() {
		motor = new WPI_TalonSRX(6);
		
		limiterTop = new DigitalInput(2);
		limiterBottom = new DigitalInput(3);
	}
	
	public void adjust(double speed) {
		
		motor.set(speed);
	}
	
	public void stop() {
		motor.set(0.0);
	}

	@Override
	protected void initDefaultCommand() {
		this.setDefaultCommand(new CommandBoom());
	}

}
