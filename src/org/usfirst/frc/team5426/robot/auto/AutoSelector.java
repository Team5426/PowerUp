package org.usfirst.frc.team5426.robot.auto;

import edu.wpi.first.wpilibj.DriverStation;
import enums.AutoMode;
import enums.Position;
import utils.Routine;

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
		
		System.out.println("Start Position: " + START_POSITION.toString());
		System.out.println("Switch Position: " + SWITCH_POSITION.toString());
		System.out.println("Auto Mode: " + AUTO_MODE.toString());
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
	
	public Routine getRoutine() {
		if (AUTO_MODE == null) {
			System.out.println("(AutoSelector.java) WARNING: AUTO_MODE IS NULL");
			
			return new Routine("baseline");
		}
		
		if (AUTO_MODE == AutoMode.NONE) {
			System.out.println("(AutoSelector.java) NOTIFICATION: AUTO_MODE IS NONE");
			
			return new Routine("none");
		}
		
		if (SWITCH_POSITION == null) {
			System.out.println("(AutoSelector.java) WARNING: SWITCH_POSITION IS NULL");
			
			return new Routine("baseline");
		}
		
		if (AUTO_MODE.equals(AutoMode.CROSS_LINE)) {
			System.out.println("(AutoSelector.java) NOTIFICATION: AUTO_MODE IS CROSS_LINE");
			
			return new Routine("baseline");
		}
		
		else if (AUTO_MODE.equals(AutoMode.DROP_STRAIGHT)) {
			System.out.println("(AutoSelector.java) NOTIFICATION: AUTO_MODE IS DROP_STRAIGHT");
			
			if (START_POSITION.equals(SWITCH_POSITION)) return new Routine("straightdrop");
			else return new Routine("baseline");
		}
		
		else if (START_POSITION != Position.MIDDLE && AUTO_MODE.equals(AutoMode.DROP_SIDE)) {
			System.out.println("(AutoSelector.java) NOTIFICATION: AUTO_MODE IS DROP_SIDE. SWITCH SIDE IS LEFT");
			//return new DropLeft(START_POSITION);
			
			if (START_POSITION.equals(Position.LEFT) && SWITCH_POSITION.equals(Position.LEFT)) {
				return new Routine("leftstart-leftswitch");
			}
			
			else if (START_POSITION.equals(Position.RIGHT) && SWITCH_POSITION.equals(Position.RIGHT)) {
				return new Routine("rightstart-rightswitch");
			}
			
			else {
				return new Routine("baseline");
			}
		}
		
		else if (START_POSITION.equals(Position.MIDDLE) && AUTO_MODE.equals(AutoMode.MIDDLE_DROP)) {
			if (SWITCH_POSITION.equals(Position.LEFT)) {
				return new Routine("middlestart-leftswitch");
			}
			
			else if (SWITCH_POSITION.equals(Position.RIGHT)) {
				return new Routine("middlestart-rightswitch");
			}
		}
		
		System.out.println("(AutoSelector.java) FATAL: SOMETHING WENT VERY WRONG. DOING NOTHING");
		
		return new Routine("baseline");
	}
}
