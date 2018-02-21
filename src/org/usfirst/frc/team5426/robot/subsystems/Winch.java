package org.usfirst.frc.team5426.robot.subsystems;

import org.usfirst.frc.team5426.robot.Robot;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import enums.Position;

public class Winch extends Subsystem {
	
	private WPI_TalonSRX TOP;
	private WPI_TalonSRX BOTTOM;
	
	private SpeedControllerGroup motors;
	
	public Winch() {
		
		TOP = new WPI_TalonSRX(3);
		BOTTOM = new WPI_TalonSRX(4);
		
		motors = new SpeedControllerGroup(TOP, BOTTOM);	
	}
	
	public void start(double power) {
		TOP.set(1);
		BOTTOM.set(-1);
	}
	
	public void stop() {
		motors.set(0.0);
	}

	@Override
	protected void initDefaultCommand() {
		
	}
	
	public SpeedControllerGroup getWinchMotors() {
		return motors;
	}
	
	public WPI_TalonSRX getWinchMotors(Position pos) {
		switch(pos.toString()) {
		case "TOP":
			return TOP;
		case "BOTTOM":
			return BOTTOM;
		default:
			return null;
		}
	}
}