package org.usfirst.frc.team5426.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot {
	
	public static OI controls;
	
	public static Preferences settings;
	
	// INITIALIZATION METHODS
	@Override
	public void robotInit() {
		settings = Preferences.getInstance();
		
		controls = new OI();
		controls.registerControls();
	}
	
	@Override
	public void autonomousInit() {
		
	}
	
	@Override
	public void teleopInit() {
		
	}
	
	@Override
	public void disabledInit() {
		
	}
	
	// PERIODIC METHODS
	@Override
	public void robotPeriodic() {
		
	}
	
	@Override
	public void teleopPeriodic() {
		
		Scheduler.getInstance().run();
	}
	
	@Override
	public void autonomousPeriodic() {
		
	}
	
	@Override
	public void disabledPeriodic() {
		
	}
	
	// LOGGING METHODS
	public static void log(String message) {
		
		DriverStation.reportWarning("[EVENT] " + message, false);
	}
	
	public static void warn(String message) {
		
		DriverStation.reportWarning("[WARNING] " + message, false);
	}
	
	public static void error(String message) {
		
		DriverStation.reportWarning("[ERROR] " + message, false);
	}
	
	
}