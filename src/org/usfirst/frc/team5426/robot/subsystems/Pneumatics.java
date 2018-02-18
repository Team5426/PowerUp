package org.usfirst.frc.team5426.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem {
	
	private Compressor compressor;
	
	public Pneumatics() {
		compressor = new Compressor();
		compressor.setClosedLoopControl(false);
	}
	
	public void compress() {
		compressor.start();
	}
	
	public void stop() {
		compressor.stop();
	}
	
	public boolean running() {
		return compressor.enabled();
	}
	
	public double getCurrent() {
		return compressor.getCompressorCurrent();
	}
	
	public boolean getSwitchStatus() {
		return compressor.getPressureSwitchValue();
	}

	@Override
	protected void initDefaultCommand() {
		
	}
}
