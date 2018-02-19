package org.usfirst.frc.team5426.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Grabber extends Subsystem {
	
	private DoubleSolenoid solenoid;
	
	private Solenoid forward;
	private Solenoid backward;
	
	public Grabber() {
		solenoid = new DoubleSolenoid(0, 1);
		
		//forward  = new Solenoid(0);
		//backward = new Solenoid(1);
	}
	
	public void grab() {
		//backward.set(false);
		//forward.set(true);
		
		solenoid.set(DoubleSolenoid.Value.kForward);
	}
	
	public void release() {
		//forward.set(false);
		//backward.set(true);
		
		solenoid.set(DoubleSolenoid.Value.kReverse);
	}
	
	public DoubleSolenoid getSolenoid() {
		return solenoid;
	}
	
	public boolean isGrabbing() {
		return forward.get();
	}
	
	public boolean isReleased() {
		return backward.get();
	}

	@Override
	protected void initDefaultCommand() {
		
	}

}
