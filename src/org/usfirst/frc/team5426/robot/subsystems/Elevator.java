package org.usfirst.frc.team5426.robot.subsystems;

import org.usfirst.frc.team5426.robot.commands.CommandElevator;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Elevator extends Subsystem {
	
	private WPI_TalonSRX motor;
	
	public DigitalInput limiterTop;
	public DigitalInput limiterBottom;
	
	//public Position position;
	
	public Elevator() {
		motor = new WPI_TalonSRX(5);
		
		limiterTop = new DigitalInput(0);
		limiterBottom = new DigitalInput(1);
		
		SmartDashboard.putData(limiterTop);
		SmartDashboard.putData(limiterBottom);
	}
	
	public void stop() {
		
		motor.set(0.0);
	}
	
	public void set(double speed) {
		motor.set(speed);
	}
	
	/*public void up() {
		motor.set(0.5);
	}
	
	public void down() {
		motor.set(-0.5);
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
	
	public Position getPosition() {
		return position;
	}*/

	@Override
	protected void initDefaultCommand() {
		//this.setDefaultCommand(new CommandElevator());
	}
}
