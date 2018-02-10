package org.usfirst.frc.team5426.robot;

import org.usfirst.frc.team5426.robot.commands.CommandWinch;

import enums.Direction;
import utils.LogitechController;

public class OI {
	
	private LogitechController controller;
	
	public OI() {
		controller = new LogitechController(0);
	}
	
	public void registerControls() {
		
		controller.button_A.whileHeld(new CommandWinch(Direction.FORWARD, 1));
		
		Robot.log("Controls successfully registered");
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
