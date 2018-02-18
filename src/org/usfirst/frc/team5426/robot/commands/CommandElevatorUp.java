package org.usfirst.frc.team5426.robot.commands;

public class CommandElevatorUp extends CommandBase {
	
	public CommandElevatorUp() {
		requires(elevator);
		
		this.setInterruptible(false);
	}
	
	protected void initialize() {
		//elevator.up();
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
		
		//return elevator.limiter.get();
		
		return true;
	}

}
