package org.usfirst.frc.team5426.robot;

import org.usfirst.frc.team5426.robot.auto.CrossLine;
import org.usfirst.frc.team5426.robot.auto.DropLeft;
import org.usfirst.frc.team5426.robot.auto.DropRight;
import org.usfirst.frc.team5426.robot.auto.StraightDrop;
import org.usfirst.frc.team5426.robot.commands.CommandBase;
import org.usfirst.frc.team5426.robot.commands.CommandDrive;
import org.usfirst.frc.team5426.robot.commands.CommandElevator;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	
	public static double AUTO_DELAY = 0;
	
	public static OI controls;
	
	public static CommandBase commandBase;
	
	public static Preferences settings;
	
	public static String gameData = null;
	public static Alliance alliance = null;
	
	private SendableChooser<CommandGroup> auto;
	private Command autoCommand;
	
	private SendableChooser<Boolean> delay;
	
	// INITIALIZATION METHODS
	@Override
	public void robotInit() {
		System.out.println("robotInit()");
		settings = Preferences.getInstance();
		
		CommandBase.init();
		
		controls = new OI();
		controls.registerControls();
		
		auto = new SendableChooser<>();
		auto.addDefault("None", null);
		auto.addObject("Cross Line", new CrossLine());
		auto.addObject("Straight Drop", new StraightDrop());
		auto.addObject("Drop Left", new DropLeft());
		auto.addObject("Drop Right", new DropRight());
		SmartDashboard.putData("Autonomous Mode:", auto);
		
		delay = new SendableChooser<>();
		delay.addDefault("0 seconds", setAutoDelay(0));
		delay.addDefault("1 seconds", setAutoDelay(1));
		delay.addDefault("2 seconds", setAutoDelay(2));
		delay.addDefault("3 seconds", setAutoDelay(3));
		delay.addDefault("4 seconds", setAutoDelay(4));
		delay.addDefault("5 seconds", setAutoDelay(5));
		delay.addDefault("6 seconds", setAutoDelay(6));
		delay.addDefault("7 seconds", setAutoDelay(7));
		delay.addDefault("8 seconds", setAutoDelay(8));
		delay.addDefault("9 seconds", setAutoDelay(9));
		delay.addDefault("10 seconds", setAutoDelay(10));
		SmartDashboard.putData("Autonomous Delay:", delay);
		
		/*if (gameData.length() > 0) {
			
			if (alliance == Alliance.Red) {
				switch (gameData.charAt(0)) {
				case 'L':
					//autoCommand = new DropLeft();
					break;
				case 'R':
					// red right
					break;
				}
			}
			
			else if (alliance == Alliance.Blue) {
				switch (gameData.charAt(0)) {
				case 'L':
					// blue left
				case 'R':
					// blue right
				}
			}
		}*/
	}
	
	@Override
	public void autonomousInit() {
		if (gameData.length() > 0) {
			
			char firstChar = gameData.charAt(0);
			if (alliance == Alliance.Red) {
				switch (firstChar) {
				case 'L':
					// left side auto
					break;
				case 'R':
					// right side auto
					break;
				}
			}
			
			else if (alliance == Alliance.Blue) {
				switch (firstChar) {
				case 'L':
					// left side auto
					break;
				case 'R':
					// right side auto
					break;
				}
			}
		}
	}
	
	@Override
	public void teleopInit() {
		
		CommandBase.elevator.setDefaultCommand(new CommandElevator());
		CommandBase.driveTrain.setDefaultCommand(new CommandDrive());
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
		
		Scheduler.getInstance().run();
	}
	
	@Override
	public void disabledPeriodic() {
		gameData = DriverStation.getInstance().getGameSpecificMessage();
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
	
	public boolean setAutoDelay(double delay) {
		this.AUTO_DELAY = delay;
		
		return true;
	}
	
	
}