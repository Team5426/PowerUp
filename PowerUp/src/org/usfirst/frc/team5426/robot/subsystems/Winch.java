package org.usfirst.frc.team5426.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Winch extends Subsystem {
	
	private WPI_TalonSRX TOP;
	private WPI_TalonSRX BOTTOM;
	
	private SpeedControllerGroup motors;
	
	public Winch() {
		
		TOP = new WPI_TalonSRX(4);
		BOTTOM = new WPI_TalonSRX(5);
	}
	
	public void start(double power) {
		motors.set(power);
	}
	
	public void stop() {
		motors.set(0.0);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
