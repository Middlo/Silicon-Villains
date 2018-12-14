package miniProject;

public class Task {
	private String taskName;
	private int start_week;
	private int end_week;
	private int serial_number;
	
	
	public Task(String taskName, int start_week, int end_week, int serial_number) {
		this.taskName = taskName;
		this.start_week = start_week;
		this.end_week =end_week;
		this.serial_number = serial_number;
	
	}
	public String getTaskName() {
		return taskName;
	}
	public void setName(String taskName) {
		this.taskName = taskName;
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
	
	public String toString() {
		return 	"Name: " + taskName + "\n" +
				"Serial Number: " + serial_number + "\n" +
				"Start Week: " + start_week + "\n" +
				"End Week: " + end_week + "\n" +
				"===========================\n" ;
	}

}
