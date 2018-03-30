package org.usfirst.frc.team5426.robot.auto;

import edu.wpi.first.wpilibj.command.Command;
import enums.AutoMode;
import enums.Position;

public class AutoSelector {
	
	private Position switchSide;
	private AutoMode selectedMode;
	
	public AutoSelector(Position switchSide, AutoMode selectedMode) {
		this.switchSide = switchSide;
		this.selectedMode = selectedMode;
		
		System.out.println("Selected mode: " + selectedMode);
		System.out.println("Switch side: " + switchSide.toString());
	}
	
	public Command getCommand() {
		if (selectedMode == AutoMode.NONE) return new None();
		if (selectedMode == AutoMode.DROP_STRAIGHT) return new StraightDrop();
		
		if (switchSide.toString() == Position.LEFT.toString()) {
			if (selectedMode == AutoMode.DROP_SIDE) {
				return new DropLeft();
			}
		}
		
		else if (switchSide.toString() == Position.RIGHT.toString()) {
			if (selectedMode == AutoMode.DROP_SIDE) {
				return new DropRight();
			}
		}
		
		System.out.println("Something went wrong");
		return null;
	}

}
