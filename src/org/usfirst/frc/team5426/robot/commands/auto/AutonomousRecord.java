package org.usfirst.frc.team5426.robot.commands.auto;

import org.usfirst.frc.team5426.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import enums.Source;
import utils.Routine;

public class AutonomousRecord extends CommandBase {
	
	public static Routine routine = null;
	private long startTime;
	
	public AutonomousRecord(double timeout) {
		this.setTimeout(timeout);
	}
	
	protected void initialize() {
		if (routine != null) {
			System.out.println("A recording is already running");
			this.cancel();
			return;
		}
		
		routine = new Routine();
		this.startTime = System.currentTimeMillis();
	}
	
	protected void execute() {
		Value grabberStatus = grabber.getSolenoidValue();
		
		if (grabberStatus.equals(Value.kReverse)) routine.handleInstruction(Source.GRABBER, "1"); // grabber is grabbing
		else if (grabberStatus.equals(Value.kForward)) routine.handleInstruction(Source.GRABBER, "-1"); // grabber is releasing
		else routine.handleInstruction(Source.GRABBER, "0"); // grabber status not yet updated
		
		if (routine.allDataReceived()) {
			routine.addInstruction(
				System.currentTimeMillis() + "," +
				routine.getData(Source.DRIVETRAIN) + "," + 
				routine.getData(Source.ELEVATOR) + "," +
				routine.getData(Source.GRABBER)
			);
		}
		
//		System.out.println(
//			routine.getData(Source.DRIVETRAIN) + "," + 
//			routine.getData(Source.ELEVATOR) + "," +
//			routine.getData(Source.GRABBER)
//		);
	}
	
	protected void end() {
		routine.save();
		routine = null;
		
		System.out.println("Recording finished");
	}
	
	protected boolean isFinished() {
		return this.isTimedOut();
	}
}
