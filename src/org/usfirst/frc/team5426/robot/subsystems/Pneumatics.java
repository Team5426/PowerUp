package org.usfirst.frc.team5426.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem {
	
	private Compressor compressor;
	
	public Pneumatics() {
		compressor = new Compressor(0);
		compressor.setClosedLoopControl(false);
	}
	
	public void start() {
		compressor.start();
	}
	
	public void stop() {
		compressor.stop();
	}
	
	public boolean getSwitchStatus() {
		return compressor.getPressureSwitchValue();
	}

	@Override
	protected void initDefaultCommand() {
		
	}
}
