package org.usfirst.frc.team5426.robot;

import java.io.File;
import java.io.IOException;

import org.usfirst.frc.team5426.robot.auto.AutoSelector;
import org.usfirst.frc.team5426.robot.commands.CommandBase;
import org.usfirst.frc.team5426.robot.commands.CommandBoom;
import org.usfirst.frc.team5426.robot.commands.CommandElevator;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import enums.AutoMode;
import enums.Position;
import utils.Routine;

public class Robot extends IterativeRobot {
	
	public static double AUTO_DELAY = 0;
	public static AutoMode AUTO_MODE = null;
	
	public static OI controls;
	
	public static CommandBase commandBase;
	
	public static Preferences settings;
	
	public static String GAME_DATA = null;
	
	private SendableChooser<AutoMode> auto;
	private SendableChooser<Integer> delay;
	private SendableChooser<Position> start;
	private SendableChooser<Routine> routines;
	private SendableChooser<Boolean> autoType;
	
	// INITIALIZATION METHODS
	@Override
	public void robotInit() {
		settings = Preferences.getInstance();
		
		CommandBase.init();
		
		controls = new OI();
		controls.registerControls();
		
		auto = new SendableChooser<>();
		auto.addDefault("None", AutoMode.NONE);
		auto.addObject("Cross Line", AutoMode.CROSS_LINE);
		auto.addObject("Straight Drop", AutoMode.DROP_STRAIGHT);
		auto.addObject("Side Drop", AutoMode.DROP_SIDE);
		auto.addObject("Middle Drop", AutoMode.MIDDLE_DROP);
		SmartDashboard.putData("Autonomous Mode:", auto);
		
		delay = new SendableChooser<>();
		delay.addDefault("0 seconds", 0);
		delay.addObject("1 seconds",  1);
		delay.addObject("2 seconds",  2);
		delay.addObject("3 seconds",  3);
		delay.addObject("4 seconds",  4);
		delay.addObject("5 seconds",  5);
		delay.addObject("6 seconds",  6);
		delay.addObject("7 seconds",  7);
		delay.addObject("8 seconds",  8);
		delay.addObject("9 seconds",  9);
		delay.addObject("10 seconds", 10);
		SmartDashboard.putData("Autonomous Delay:", delay);
		
		start = new SendableChooser<>();
		start.addDefault("Middle", Position.MIDDLE);
		start.addObject("Left", Position.LEFT);
		start.addObject("Right", Position.RIGHT);
		SmartDashboard.putData("Start Position:", start);
		
		autoType = new SendableChooser<>();
		autoType.addDefault("Auto Selector", true);
		autoType.addObject("Manual Routine", false);
		SmartDashboard.putData("Auto Mode Type", autoType);
		
		routines = new SendableChooser<>();
		routines.addDefault("None", null);
		for (File routine : Routine.getRoutineFiles()) {
			String name = routine.getName().replace(".auto", "");
			routines.addObject(name, new Routine(name));
		}
		SmartDashboard.putData("Routines", routines);
	}
	
	@Override
	public void autonomousInit() {
		CommandBase.pneumatics.stop();
		Robot.AUTO_DELAY = delay.getSelected();
		
		System.out.println("Autonomous Init");
		
		if (autoType.getSelected()) {
			
			System.out.println("Auto Selector is being used");
			
			if (GAME_DATA.length() == 3) {
				System.out.println("(Robot.java) NOTIFICATION: GAME DATA IS > 0");
				
				Routine autoRoutine = new AutoSelector(GAME_DATA, auto.getSelected(), start.getSelected()).getRoutine();
				
				System.out.println("(Robot.java) INFO: autoCommand is " + autoRoutine.getName());
				
				try {
					autoRoutine.play();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			else {
				System.out.println("(Robot.java) FATAL: COULD NOT RETRIEVE GAME DATA");
			}
		}
		
		else {
			Routine routine = routines.getSelected();
			
			if (routine != null) {
				try {
					routine.play();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public void teleopInit() {
		CommandBase.pneumatics.stop();
		
		routines = new SendableChooser<>();
		routines.addDefault("None", null);
		for (File routine : Routine.getRoutineFiles()) {
			System.out.println(routine.getName());
			String name = routine.getName().replace(".auto", "");
			routines.addObject(name, new Routine(name));
		}
		SmartDashboard.putData("Routines", routines);
		
		// We don't want these default commands to fire
		// during autonomous or they bog down the RIO. 
		// We only want them to fire repeatedly in teleop;
		
		CommandBase.elevator.setDefaultCommand(new CommandElevator());
		CommandBase.boom.setDefaultCommand(new CommandBoom());
	}
	
	@Override
	public void disabledInit() {
		CommandBase.pneumatics.stop();
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
		Scheduler.getInstance().run();
	}
	
	@Override
	public void disabledPeriodic() {
		GAME_DATA = DriverStation.getInstance().getGameSpecificMessage();
	}
	
	@Override
	public void testPeriodic() {
		CommandBase.pneumatics.start();
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