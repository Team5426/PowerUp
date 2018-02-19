package org.usfirst.frc.team5426.robot;

import org.usfirst.frc.team5426.robot.auto.DriveStraight;
import org.usfirst.frc.team5426.robot.commands.CommandBase;

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
	
	public static OI controls;
	
	public static CommandBase commandBase;
	
	public static Preferences settings;
	
	public static String gameData;
	public static Alliance alliance;
	
	private SendableChooser<CommandGroup> auto;
	private Command autoCommand;
	
	// INITIALIZATION METHODS
	@Override
	public void robotInit() {
		System.out.println("robotInit()");
		settings = Preferences.getInstance();
		
		CommandBase.init();
		
		controls = new OI();
		controls.registerControls();
		
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		alliance = DriverStation.getInstance().getAlliance();
		
		auto = new SendableChooser<>();
		auto.addDefault("None", null);
		auto.addObject("Straight", new DriveStraight());
		SmartDashboard.putData("Autonomous Mode: ", auto);
		
		if (gameData.length() > 0) {
			
			if (alliance == Alliance.Red) {
				switch (gameData.charAt(0)) {
				case 'L':
					// red left
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
		}
		
		if (gameData.length() > 0) {
			switch (gameData.charAt(0)) {
			case 'L':
				// left auto code
				break;
			case 'R':
				// right auto code
				break;
			}
		}
		
		
		
		//if (!settings.containsKey("TALON_FRONT_LEFT")) System.out.println("FRONT-LEFT TALON ID NOT SET");
	}
	
	@Override
	public void autonomousInit() {
		autoCommand = auto.getSelected();
		if (autoCommand != null) autoCommand.start();
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
		
		//System.out.println("Gyro Angle: " + CommandBase.driveTrain.gyro.getAngle());
		//System.out.println("Elevator Top Limitter: " + CommandBase.elevator.limiterTop.get());
		//System.out.println("Elevator Bottom Limitter: " + CommandBase.elevator.limiterTop.get());
		//System.out.println("Boom Top Limitter: " + CommandBase.boom.limiterTop.get());
		//System.out.println("Boom Bottom Limitter: " + CommandBase.boom.limiterBottom.get());
		
		//if (CommandBase.boom.limiterBottom.get()) System.out.println("Boom Bottom Limiter is Active");
		//if (CommandBase.boom.limiterTop.get()) System.out.println("Boom Top Limiter is active");
		
		//if (CommandBase.elevator.limiterBottom.get()) System.out.println("Elevator Top Limiter is Active");
		//if (CommandBase.elevator.limiterTop.get()) System.out.println("Elevator Bottom Limiter is active");
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