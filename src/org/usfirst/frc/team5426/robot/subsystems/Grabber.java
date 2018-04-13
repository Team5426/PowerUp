package org.usfirst.frc.team5426.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Grabber extends Subsystem {
	
	private DoubleSolenoid solenoid;
	
	public Grabber() {
		solenoid = new DoubleSolenoid(0, 1);
	}
	
	public void grab() {
		solenoid.set(Value.kForward);
	}
	
	public void release() {
		solenoid.set(Value.kReverse);
	}
	
	public DoubleSolenoid getSolenoid() {
		return solenoid;
	}
	
	public Value getSolenoidValue() {
		return solenoid.get();
	}

	@Override
	protected void initDefaultCommand() {
		
	}

}
