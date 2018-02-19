package org.usfirst.frc.team5426.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Harpoon extends Subsystem {
	
	public Solenoid solenoid;
	
	public Harpoon() {
		solenoid = new Solenoid(3);
		
		//solenoid.set(false);
	}
	
	public void shoot() {
		solenoid.set(true);
	}
	
	public void reload() {
		solenoid.set(false);
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}
}
