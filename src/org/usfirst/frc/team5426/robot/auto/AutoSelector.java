package org.usfirst.frc.team5426.robot.auto;

import edu.wpi.first.wpilibj.command.Command;
import enums.AutoMode;
import enums.Position;

public class AutoSelector {
	private char[] GAME_DATA;
	private AutoMode AUTO_MODE;
	private Position SWITCH_POSITION;
	private Position START_POSITION;
	
	public AutoSelector(String gameData, AutoMode autoMode, Position start) {
		GAME_DATA = gameData.toCharArray();
		AUTO_MODE = autoMode;
		SWITCH_POSITION = getSwitchPosition();
		START_POSITION = start;
	}
	
	private Position getSwitchPosition() {
		switch (GAME_DATA[0]) {
		case 'L':
			return Position.LEFT;
		case 'R':
			return Position.RIGHT;
		default:
			return null;
		}
	}
	
	public Command getCommand() {
		if (AUTO_MODE == null) {
			System.out.println("(AutoSelector.java) WARNING: AUTO_MODE IS NULL");
			return new None();
		}
		
		if (AUTO_MODE == AutoMode.NONE) {
			System.out.println("(AutoSelector.java) NOTIFICATION: AUTO_MODE IS NONE");
			return new None();
		}
		
		if (SWITCH_POSITION == null) {
			System.out.println("(AutoSelector.java) WARNING: SWITCH_POSITION IS NULL");
			return new None();
		}
		
		if (AUTO_MODE.equals(AutoMode.CROSS_LINE)) {
			System.out.println("(AutoSelector.java) NOTIFICATION: AUTO_MODE IS CROSS_LINE");
			return new CrossLine(START_POSITION);
		}
		
		if (AUTO_MODE.equals(AutoMode.DROP_STRAIGHT)) {
			System.out.println("(AutoSelector.java) NOTIFICATION: AUTO_MODE IS DROP_STRAIGHT");
			return new StraightDrop();
		}
		
		if (AUTO_MODE.equals(AutoMode.DROP_SIDE) && SWITCH_POSITION.equals(Position.LEFT)) {
			System.out.println("(AutoSelector.java) NOTIFICATION: AUTO_MODE IS DROP_SIDE. SWITCH SIDE IS LEFT");
			return new DropLeft(START_POSITION);
		}
		
		if (AUTO_MODE.equals(AutoMode.DROP_SIDE) && SWITCH_POSITION.equals(Position.RIGHT)) {
			System.out.println("(AutoSelector.java) NOTIFICATION: AUTO_MODE IS DROP_SIDE. SWITCH SIDE IS RIGHT");
			return new DropRight(START_POSITION);
		}
		
		System.out.println("(AutoSelector.java) FATAL: SOMETHING WENT VERY WRONG. DOING NOTHING");
		return new None();
	}
}
