package main_package;


import java.util.ArrayList;

public class Project {

	private String ID;
	private String name;
	private String desc;
	private int duration;//in weeks
	private int budget;
	private int RoI;
	private ArrayList<PersonTime> times; // should be array with each member and their time
	private ArrayList<Task> tasks;

	public Project(String ID, String name, String desc, int duration, int budget, int RoI) {
		this.ID = ID;
		this.name = name;
		this.desc = desc;
		this.duration = duration;
		this.budget = budget;
		this.RoI = RoI;
		this.times = new ArrayList<>();
		this.tasks = new ArrayList<>();
	}
	
	public Project(String ID, String name, String desc, int duration, int budget, int RoI, ArrayList<PersonTime> times, ArrayList<Task> tasks) {
		this.ID = ID;
		this.name = name;
		this.desc = desc;
		this.duration = duration;
		this.budget = budget;
		this.RoI = RoI;
		this.times = times;
		this.tasks = tasks;
	}

	public double costVariance(int current_week) {

		double earned_Value = earnedValue(current_week);
		double cost_Variance = 0;
		cost_Variance = earned_Value - this.budget;
		return cost_Variance;
	}
	
	public double scheduleVariance(int current_week) {
		
		return (this.earnedValue(current_week)-this.plannedValue(current_week));


	}
	public double plannedValue(int current_week) {
		
		int projectDuration=this.duration;
		
		double percentageOfProjectDone=(double)(current_week/projectDuration);
		double plannedValue=percentageOfProjectDone*this.budget;
		
		return plannedValue;
		
	}
	public ArrayList<PersonTime> timePerMember() {
		return this.times;
	}

	public boolean updateTime(String personID, int time) {
		boolean found = false;
		for(PersonTime couple : this.times) {
			if(personID.equals(couple.getID())) {
				couple.setTime(time);
				found = true;
			}
		}
		return found;
	}
	
	public void createTask(String name, int start_week,int end_week,int sn) {
		this.tasks = new ArrayList<>();
		Task task = new Task(name, start_week, end_week,sn);
		this.tasks.add(task);
	}
	public int getNumberOfTasks() {
		return tasks.size();
	}
	public Task getTask(int position) {
		return this.tasks.get(position);
	}
	public double retrieveCompletedPercentage(int week) {
		
		double completedPercentage=0.0;
		int completedTasks=0;
		int allTasks=0;

		for (Task task : this.tasks) {
			if(tasks != null) {
				allTasks+=task.LengthOfTask();
				if(task.completedTask(week))
					completedTasks+=task.LengthOfTask();
			}
		}
		completedPercentage=allTasks/completedTasks;
		return completedPercentage;
	}
	public double earnedValue(int current_week) {
		
		double earned_value=0;
		double completed_work=retrieveCompletedPercentage(current_week);
		
		earned_value=this.budget*completed_work;
		return earned_value;

	}
	
	public int[] scheduleActivity(int position) {
		int startWeek = this.tasks.get(position).getStart_week();
		int endWeek = this.tasks.get(position).getEnd_week();
		
		return new int[] {startWeek, endWeek};
	}
	
	public String riskMatrix(int probability, int impact) {
		
		int riskMatrix = probability * impact;
		
		if (riskMatrix > 3) {
			if (riskMatrix > 7) {
				if (riskMatrix > 11) {
					return "Dangerous";
				}
				return "High";
			}
			return "Medium";
		}	
		return "Safe";
	}
	
	public void addTime(String ID, int time) {
		PersonTime couple = new PersonTime(ID,time);
		this.times.add(couple);
		System.out.println("Added "+couple+" To the array of TIMES");
	}
	
	public void removeTime(String ID) {
		//Function called to remove the element in the ArrayList times (attribute of a project)
		//that has as ID of the member the given "ID"
		PersonTime toRemove = null;
		for(PersonTime each : this.times) {
			if(each.getID().equals(ID)) {
				toRemove = each;
			}
		}
		times.remove(toRemove);
	}
	
	public boolean hasMember(String ID) {
		//Function that returns true if the member with id "ID" is present
		//in the ArrayList times (attribute of a project)
		for(PersonTime each : this.times) {
			if(each.getID().equals(ID)) {
				return true;
			}
		}
		return false;
	}

	public String getID() {
		return this.ID;
	}

	public String getName() {
		return this.name;
	}

	public String getDesc() {
		return this.desc;
	}

	public int getDuration() {
		return this.duration;
	}

	public int getBudget() {
		return this.budget;
	}

	public int getRoI() {
		return this.RoI;
	}

	public ArrayList<PersonTime> getTimes(){
		return this.times;
	}
	
	public ArrayList<Task> getTasks(){
		return this.tasks;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public void setRoI(int roI) {
		RoI = roI;
	}
	
	public String toString() {

		final String END_OF_LINE = System.lineSeparator();
		String projectInfo = "Project with ID: " + this.ID + END_OF_LINE;
		projectInfo += "Name: " + this.name + END_OF_LINE;
		projectInfo += "Decription: " + this.desc + END_OF_LINE;
		projectInfo += "Duration: " + this.duration + END_OF_LINE;
		projectInfo += "Budget: " + this.budget + " SEK per month" + END_OF_LINE;
		projectInfo += END_OF_LINE + "********* Extra Info *********";
		projectInfo += END_OF_LINE + "Group members:" + END_OF_LINE;
		if(this.times.size()==0) {
			projectInfo += "None" + END_OF_LINE;
		}else {
			for(PersonTime each : this.times) {
				projectInfo += "Member " + each.getID() + " spent " + each.getTime() + " minutes" + END_OF_LINE;
			}
		}
		
		return projectInfo;
	}

}

