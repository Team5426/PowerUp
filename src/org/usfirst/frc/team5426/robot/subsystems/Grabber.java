package org.usfirst.frc.team5426.robot.subsystems;

import org.usfirst.frc.team5426.robot.Robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Grabber extends Subsystem {
	
	private Solenoid forward;
	private Solenoid backward;
	
	public Grabber() {
		forward 	= new Solenoid(Robot.settings.getInt("SOLENOID_GRABBER_FORWARD", -1));
		backward = new Solenoid(Robot.settings.getInt("SOLENOID_GRABBER_BACKWARD", -1));
	}
	
	public void grab() {
		backward.set(false);
		forward.set(true);
		
		System.out.println("[INFO] Grabber now grabbing");
	}
	
	public void release() {
		forward.set(false);
		backward.set(true);
		
		System.out.println("[INFO] Grabber now releasing");
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
