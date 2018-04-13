package org.usfirst.frc.team5426.robot;

import org.usfirst.frc.team5426.robot.commands.CommandBase;
import org.usfirst.frc.team5426.robot.commands.CommandDeployWings;
import org.usfirst.frc.team5426.robot.commands.CommandGrabber;
import org.usfirst.frc.team5426.robot.commands.CommandMobyDick;
import org.usfirst.frc.team5426.robot.commands.CommandWinch;
import org.usfirst.frc.team5426.robot.commands.auto.AutonomousDrop;
import org.usfirst.frc.team5426.robot.commands.auto.AutonomousGrab;
import org.usfirst.frc.team5426.robot.commands.auto.AutonomousRecord;

import edu.wpi.first.wpilibj.command.Command;
import enums.Direction;
import utils.LogitechController;

public class OI {
	
	private LogitechController controller;
	
	public OI() {
		controller = new LogitechController(0);
	}
	
	public void registerControls() {
		controller.button_A.whileHeld(new CommandWinch(Direction.FORWARD, 1));
		controller.button_X.whenPressed(new CommandGrabber());
		controller.button_B.whenPressed(new CommandDeployWings());
		controller.button_Y.whenPressed(new CommandMobyDick());
		
		controller.start.whenPressed(new AutonomousRecord(15));
		
		System.out.println("Controls successfully registered");
	}
	
	public LogitechController getController() {
		return controller;
	}
	
	public double getXAxis() {
		return controller.getLeftAxisX();
	}
	
	public double getYAxis() {
		return controller.getLeftAxisY();
	}
	
	public double getTwist() {
		return controller.getRightAxisX();
	}
}