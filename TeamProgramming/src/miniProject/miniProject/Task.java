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
<<<<<<< HEAD
	public boolean completedTask(int week) {
		if(this.end_week<week)
			return true;
		else
			return false;
	}
	public int LengthOfTask() {
		return this.end_week-this.start_week;
	}
	public String getTaskName() {
		return name;
=======
	public String getTaskName() {
		return taskName;
>>>>>>> 06419f932301cb2a89ba19e9c63789f2168ea20e
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
<<<<<<< HEAD
		return 	"Name: " + this.name + "\n" +
				"Serial Number: " + this.serial_number + "\n" +
				"Start Week: " + this.start_week + "\n" +
				"End Week: " + this.end_week + "\n" +
				"===========================\n" ;
	}

=======
		return 	"Name: " + taskName + "\n" +
				"Serial Number: " + serial_number + "\n" +
				"Start Week: " + start_week + "\n" +
				"End Week: " + end_week + "\n" +
				"===========================\n" ;
	}
>>>>>>> 06419f932301cb2a89ba19e9c63789f2168ea20e

}
