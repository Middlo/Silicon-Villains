package miniProject;

public class Task {
	private String name;
	private int start_week;
	private int end_week;
	private int serial_number;
	
	
	public Task(String name, int sw, int ew, int sn) {
		this.name=name;
		this.start_week=sw;
		this.end_week=ew;
		this.serial_number=sn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSerial_number() {
		return serial_number;
	}
	public void setSerial_number(int serial_number) {
		this.serial_number = serial_number;
	}
	public int getEnd_week() {
		return end_week;
	}
	public void setEnd_week(int end_week) {
		this.end_week = end_week;
	}
	public int getStart_week() {
		return start_week;
	}
	public void setStart_week(int start_week) {
		this.start_week = start_week;
	}

}
