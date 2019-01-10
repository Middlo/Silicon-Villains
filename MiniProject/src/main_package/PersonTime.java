package main_package;


public class PersonTime {
	private String ID; //Id of the person
	private int time; //time in minutes
	
	public PersonTime(String ID, int time) {
		this.ID = ID;
		this.time = time;
	}
	
	public String getID() {
		return this.ID;
	}
	
	public int getTime() {
		return this.time;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
}
