package org.usfirst.frc.team5426.robot.subsystems;

import org.usfirst.frc.team5426.robot.commands.CommandElevator;
import org.usfirst.frc.team5426.robot.commands.auto.AutonomousRecord;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import enums.Source;

public class Elevator extends Subsystem {
	
	private WPI_TalonSRX motor;
	
//	public DigitalInput limiterTop;
//	public DigitalInput limiterBottom;
	
	//public Position position;
	
	public Elevator() {
		motor = new WPI_TalonSRX(5);
		motor.setNeutralMode(NeutralMode.Brake);
		
//		limiterTop = new DigitalInput(0);
//		limiterBottom = new DigitalInput(1);
	}
	
	public void stop() {
		
		motor.set(0.0);
		
		if (AutonomousRecord.routine != null) {
			AutonomousRecord.routine.handleInstruction(Source.ELEVATOR, "" + 0.0);
		}
	}
	
	public void set(double speed) {
		motor.set(speed);
		
		if (AutonomousRecord.routine != null) {
			AutonomousRecord.routine.handleInstruction(Source.ELEVATOR, "" + speed);
		}
	}

	@Override
	protected void initDefaultCommand() {
		this.setDefaultCommand(new CommandElevator());
	}
}
