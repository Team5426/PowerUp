package org.usfirst.frc.team5426.robot.commands;

import enums.Position;

public class CommandElevatorDown extends CommandBase {
	
	public CommandElevatorDown() {
		requires(elevator);
		
		this.setInterruptible(false);
	}
	
	protected void initialize() {
		/*if (elevator.getPosition().equals(Position.TOP)) {
			elevator.down();
		}
		
		else {
			this.cancel();
		}*/
	}
	
	protected void execute() {
		
	}
	
	protected void interrupted() {
		
	}
	
	protected void end() {
		//elevator.stop();
	}

	@Override
	protected boolean isFinished() {
		
		/*if (elevator.limiter.get()) {
			
			elevator.setPosition(Position.BOTTOM);
			
			return true;
		}
		
		return false;*/
		
		return true;
	}

}
