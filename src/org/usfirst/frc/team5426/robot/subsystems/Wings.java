package org.usfirst.frc.team5426.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Wings extends Subsystem {
	
	private Solenoid solenoid;
	
	public Wings() {
		solenoid = new Solenoid(2);
		
		solenoid.set(false);
	}
	
	public void deploy() {
		solenoid.set(true);
	}

	@Override
	protected void initDefaultCommand() {
		
	}

}
