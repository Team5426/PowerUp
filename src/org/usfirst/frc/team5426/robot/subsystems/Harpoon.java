package org.usfirst.frc.team5426.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Harpoon extends Subsystem {

	public Solenoid solenoid;

	public Harpoon() {
		// Defines the solenoid
		solenoid = new Solenoid(3);
	}

	public void shoot() {
		// Activate the solenoid
		solenoid.set(true);
	}

	public void reload() {
		// Release the solenoid
		solenoid.set(false);
	}

	@Override
	protected void initDefaultCommand() {

	}
}
