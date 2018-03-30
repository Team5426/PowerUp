package org.usfirst.frc.team5426.robot;

import org.usfirst.frc.team5426.robot.auto.AutoSelector;
import org.usfirst.frc.team5426.robot.commands.AutoModeSetter;
import org.usfirst.frc.team5426.robot.commands.CommandBase;
import org.usfirst.frc.team5426.robot.commands.CommandBoom;
import org.usfirst.frc.team5426.robot.commands.CommandCompress;
import org.usfirst.frc.team5426.robot.commands.CommandDrive;
import org.usfirst.frc.team5426.robot.commands.CommandElevator;
import org.usfirst.frc.team5426.robot.commands.auto.AutoDelaySetter;
import org.usfirst.frc.team5426.robot.subsystems.Pneumatics;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.hal.CompressorJNI;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import enums.AutoMode;
import enums.Position;

public class Robot extends IterativeRobot {
	
	public static double AUTO_DELAY = 0;
	public static AutoMode AUTO_MODE = null;
	
	public static OI controls;
	
	public static CommandBase commandBase;
	
	public static Preferences settings;
	
	public static String gameData = null;
	public static Alliance alliance = null;
	private Position switchSide = null;
	
	private SendableChooser<Command> auto;
	private SendableChooser<Command> delay;
	
	// INITIALIZATION METHODS
	@Override
	public void robotInit() {
		settings = Preferences.getInstance();
		
		CommandBase.init();
		
		controls = new OI();
		controls.registerControls();
		
		auto = new SendableChooser<>();
		auto.addDefault("None", new AutoModeSetter(AutoMode.NONE));
		auto.addObject("Cross Line", new AutoModeSetter(AutoMode.CROSS_LINE));
		auto.addObject("Straight Drop", new AutoModeSetter(AutoMode.DROP_STRAIGHT));
		auto.addObject("Drop", new AutoModeSetter(AutoMode.DROP_SIDE));
		SmartDashboard.putData("Autonomous Mode:", auto);
		
		delay = new SendableChooser<>();
		delay.addDefault("0 seconds", new AutoDelaySetter(0));
		delay.addObject("1 seconds",  new AutoDelaySetter(1));
		delay.addObject("2 seconds",  new AutoDelaySetter(2));
		delay.addObject("3 seconds",  new AutoDelaySetter(3));
		delay.addObject("4 seconds",  new AutoDelaySetter(4));
		delay.addObject("5 seconds",  new AutoDelaySetter(5));
		delay.addObject("6 seconds",  new AutoDelaySetter(6));
		delay.addObject("7 seconds",  new AutoDelaySetter(7));
		delay.addObject("8 seconds",  new AutoDelaySetter(8));
		delay.addObject("9 seconds",  new AutoDelaySetter(9));
		delay.addObject("10 seconds", new AutoDelaySetter(10));
		SmartDashboard.putData("Autonomous Delay:", delay);
	}
	
	@Override
	public void autonomousInit() {
		CommandBase.pneumatics.stop();
		
		/*while (AUTO_MODE == null) {
			System.out.println("Robot.java AUTO_MODE still null");
			
			auto.getSelected().start();
			delay.getSelected().start();
		}
		
		System.out.println("AUTO_MODE: " + AUTO_MODE);
		
		if (gameData.length() > 0) {
			
			System.out.println("> 0 true");
			
			char firstChar = gameData.charAt(0);
			switch (firstChar) {
				case 'L':
					switchSide = Position.LEFT;
					break;
				case 'R':
					switchSide = Position.RIGHT;
					break;
			}
		}
		
		else {
			System.out.println("> 0 false");
		}
		
		Command autoCmd = new AutoSelector(switchSide, AUTO_MODE).getCommand();
		System.out.println("FINAL AUTO COMMAND: " + autoCmd);*/
	}
	
	@Override
	public void teleopInit() {
		CommandBase.pneumatics.stop();
		
		// We don't want these periodic default commands to fire
		// during autonomous or they bog down the RIO. We only want
		// them to constantly fire in teleop;
		
		CommandBase.driveTrain.setDefaultCommand(new CommandDrive());
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
		// Scheduler.getInstance().run();
		
		gameData = DriverStation.getInstance().getGameSpecificMessage();
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
	
	public static void setAutoDelay(double delay) {
		Robot.AUTO_DELAY = delay;
	}
	
	public static void setAutoMode(AutoMode mode) {
		System.out.println("setAutoMode() " + mode);
		Robot.AUTO_MODE = mode;
	}
	
	
}