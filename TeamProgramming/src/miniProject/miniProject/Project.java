public class Project {

	private String ID;
	private String name;
	private String desc;
	private int duration;
	private int budget;
	private int RoI;
	private int time; // should be array with each member and their time

	Project(String ID, String name, String desc, int duration, int budget, int RoI, int time) {
		this.ID = ID;
		this.name = name;
		this.desc = desc;
		this.duration = duration;
		this.budget = budget;
		this.RoI = RoI;
		this.time = time;
	}

	public double costVariance (int current_week) {
		double earned_Value = earnedValue(current_week);
		double cost_Variance = earned_Value - this.budget;
		return cost_Variance;

		/*
		 * this method should return the cost variance the cost variance = budgeted cost
		 * of the work - actual cost of work
		 */
	
	}

	public int scheduleVariance() {
		/*
		 * this method should return the schedule variance the schedule variance =
		 * budgeted cost of the work performed - budgeted cost of work scheduled
		 */

		return 0;
	}

	public double earnedValue(int current_week) {
		double earned_value=0;
		double completed_work=duration/current_week;
		earned_value=this.budget*completed_work;
		return earned_value;
		
		/*
		 * this method should return the earned value = % of completed
		 * work / budget at completion (BAC)
		 */
	}
	
	public String scheduleActivity() {
		/*
		 * this method will return the project's schedule and planned activity.
		 * it should return the start week and end week of the project
		 */
		return null;
	}
	
	
	//Risk Matrix method; think about this!!!
	
	

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

	public int getTime() {
		return this.time;
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

	public void setTime(int time) {
		this.time = time;
	}
}

