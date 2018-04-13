package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import org.usfirst.frc.team5426.robot.Robot;
import org.usfirst.frc.team5426.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import enums.Source;

/**
 * @author Duncan Snider | Team 5426
 * @version 1.0
 * 
 * Copyright (c) Team 5426
 */

public class Routine {
	
	private String name;
	
	private int number;
	
	private HashMap<Source, String> data;
	private HashMap<Source, Boolean> received;
	
	private ArrayList<String> instructions;
	
	private Thread recordingThread;
	
	private boolean recording = false;
	
	private long recordingEndTime;
	
	public Routine() {
		
		System.out.println("==== getRoutineDirectory() start");
		this.number = getRoutineDirectory().listFiles().length;
		System.out.println("==== getRoutineDirectory() end");
		this.name = "routine-" + number + ".auto";
		
		this.data = new HashMap<>();
		this.data.put(Source.DRIVETRAIN, null);
		this.data.put(Source.ELEVATOR, null);
		this.data.put(Source.GRABBER, null);
		
		this.received = new HashMap<>();
		this.received.put(Source.DRIVETRAIN, false);
		this.received.put(Source.ELEVATOR, false);
		this.received.put(Source.GRABBER, false);
		
		this.instructions = new ArrayList<>();
	}
	
	public Routine(String name) {
		this.name = name + ".auto";
		
		data = new HashMap<>();
		data.put(Source.DRIVETRAIN, null);
		data.put(Source.ELEVATOR, null);
		data.put(Source.GRABBER, null);
		
		received = new HashMap<>();
		received.put(Source.DRIVETRAIN, false);
		received.put(Source.ELEVATOR, false);
		received.put(Source.GRABBER, false);
		
		instructions = new ArrayList<>();
	}
	
	public void play() throws IOException {
		BufferedReader reader = null;
		
		FileReader fileReader;
		try {
			fileReader = new FileReader(getRoutineFile());
			reader = new BufferedReader(fileReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<String> lines = new ArrayList<>();
		
		for (Object lineObj : reader.lines().toArray()) {
			lines.add(lineObj.toString());
		}
		
		try {
			Thread.sleep(((long) Robot.AUTO_DELAY * 1000));
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		for (int i = 0; i < lines.size(); i++) {
			String line = lines.get(i);
			String[] values = line.split(",");
			
			String previousLine = "";
			if (i != 0) previousLine = lines.get(i - 1);
			
			String[] previousValues = {};
			if (i != 0) previousValues = previousLine.split(",");
			
			long previousTimestamp = 0;
			if (i != 0) previousTimestamp = Long.parseLong(previousValues[0]);
			
			long timestamp = Long.parseLong(values[0]);
			
			long difference = 0;
			if (i != 0) difference = timestamp - previousTimestamp;
			
			
			//////////
			
			double speed = Double.parseDouble(values[1]);
			double twist = Double.parseDouble(values[2]);
			double elevator = Double.parseDouble(values[3]);
			
			int grabber = Integer.parseInt(values[4]);
			Value currentGrabberValue = CommandBase.grabber.getSolenoidValue();
			
			if (i == 0) System.out.println(i + ": " + grabber);
			
			if (grabber == 1 && (currentGrabberValue.equals(Value.kReverse) || currentGrabberValue.equals(Value.kOff))) {
				CommandBase.grabber.grab();
			}
			else if (grabber == -1 && (currentGrabberValue.equals(Value.kForward) || currentGrabberValue.equals(Value.kOff))) {
				CommandBase.grabber.release();
			}
			
			CommandBase.driveTrain.drive(twist, -speed);
			CommandBase.elevator.set(elevator);
			
			//////////
			
			//System.out.println("Waiting " + difference + "ms");
			
			try {
				Thread.sleep(difference);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Done");
	}
	
	public String getName() {
		return this.name;
	}
	
	public void rename(String newName) {
		File file = getRoutineFile();
		
		file.renameTo(new File("/home/lvuser/routines" + File.separator + newName + ".auto"));
		
		this.name = newName;
	}
	
	public File getRoutineFile() {
		File file = new File("/home/lvuser/routines" + File.separator + this.name);
		
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return file;
	}
	
	public void handleInstruction(Source source, String instruction) {
		if (source.equals(Source.DRIVETRAIN)) {
			this.data.put(Source.DRIVETRAIN, instruction);
			this.received.put(Source.DRIVETRAIN, true);
		}
		
		else if (source.equals(Source.ELEVATOR)) {
			this.data.put(Source.ELEVATOR, instruction);
			this.received.put(Source.ELEVATOR, true);
		}
		
		else if (source.equals(Source.GRABBER)) {
			this.data.put(Source.GRABBER, instruction);
			this.received.put(Source.GRABBER, true);
		}
	}
	
	public void addInstruction(String instruction) {
		System.out.println("Adding instruction: " + instruction);
		
		this.instructions.add(instruction);
		
		this.data.put(Source.DRIVETRAIN, null);
		this.data.put(Source.ELEVATOR, null);
		this.data.put(Source.GRABBER, null);
		
		this.received.put(Source.DRIVETRAIN, false);
		this.received.put(Source.ELEVATOR, false);
		this.received.put(Source.GRABBER, false);
	}
	
	public void save() {
		PrintWriter writer = null;
		
		try {
			writer = new PrintWriter(getRoutineFile());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for (String line : this.instructions) {
			writer.println(line);
		}
		
		writer.close();
		
		System.out.println("Saving routine " + this.name);
	}
	
	public String getData(Source source) {
		return this.data.get(source);
	}
	
	public boolean dataReceived(Source source) {
		return (this.data.get(source) != null);
	}
	
	public boolean allDataReceived() {
		return (this.dataReceived(Source.DRIVETRAIN)
				&& this.dataReceived(Source.ELEVATOR)
				&& this.dataReceived(Source.GRABBER));
	}
	
	/***********************
	 * STATIC METHODS
	 ***********************/
	
	public static File getRoutineDirectory() {
		File folder = new File("/home/lvuser/routines");
		
		if (!folder.exists() || !folder.isDirectory()) {
			folder.mkdirs();
		}
		
		return folder;
	}
	
	public static File[] getRoutineFiles() {
		return getRoutineDirectory().listFiles();
	}
}