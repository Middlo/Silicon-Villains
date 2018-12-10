import java.util.ArrayList;

public class Main{
	ArrayList<Project> projects;
	ArrayList<Person> people;
	
	public Main() {
		projects = new ArrayList<>();
		people = new ArrayList<>();
	}
	
	public static void main (String[]args) {
		Main program = new Main();
		//program.run();
	}
	
	//createProject is Done
	public void createProject(String ID, String name, String desc, int duration, int budget, int RoI, int time) {
		Project project = new Project(ID, name, desc, duration, budget, RoI, time);
		
		if(retrieveProject(ID)==null) {
			this.projects.add(project);
		}else {
			System.out.println("Error: Cannot add project, project already existing");
		}
	}
	
	//removePreject is Done
	public void removeProject(String ID) {
		//Deletes a project with specified ID if it is present in the ArrayList
		Project project = retrieveProject(ID);// we get employee with this ID
		
		if (project != null) {
			this.projects.remove(project);// we remove that employee if he/she exists
		}else {
		System.out.println("Project with this ID:" + ID + " is not registered in the system.");
		}
	}
	
	//retrieveProject is Done
	public Project retrieveProject(String ID) {
		//Retrieves the Project with id specified if it is present in the arraylist
		//otherwise returns null if it is not present
		for (int i = 0; i < this.projects.size(); i++) { 
			if (projects.get(i) != null && projects.get(i).getID().equals(ID)) { 
				return projects.get(i); 
			}
		}
		return null;
	}
	
	//updateProjectName is Done
	public boolean updateProjectName(String ID,String newName) {
		//Returns true if the name is successfully edited, returns false if not
		Project foundProject = retrieveProject(ID);
		if(foundProject != null) {
			foundProject.setName(newName);
			return true;
		}else {
			return false;
		}
	}
	
	//updateProjectDesc is Done
	public boolean updateProjectDesc(String ID,String newDesc) {
		//Returns true if the description is successfully edited, returns false if not
		Project foundProject = retrieveProject(ID);
		if(foundProject != null) {
			foundProject.setDesc(newDesc);
			return true;
		}else {
			return false;
		}
	}
	
	//updateProjectDuration is Done
	public boolean updateProjectDuration(String ID,int newDuration) {
		//Returns true if the duration is successfully edited, returns false if not
		Project foundProject = retrieveProject(ID);
		if(foundProject != null) {
			foundProject.setDuration(newDuration);
			return true;
		}else {
			return false;
		}
	}
	
	//updateProjectBudget is Done
	public boolean updateProjectBudget(String ID,int newBudget) {
		//Returns true if the budget is successfully edited, returns false if not
		Project foundProject = retrieveProject(ID);
		if(foundProject != null) {
			foundProject.setBudget(newBudget);
			return true;
		}else {
			return false;
		}
	}
	
	//updateProjectRoI is Done
	public boolean updateProjectRoI(String ID,int newRoI) {
		//Returns true if the RoI is successfully edited, returns false if not
		Project foundProject = retrieveProject(ID);
		if(foundProject != null) {
			foundProject.setRoI(newRoI);
			return true;
		}else {
			return false;
		}
	}
	
	//updateProjectTime is Done
	public boolean updateProjectTime(String ID,int newTime) {
		//Returns true if the time is successfully edited, returns false if not
		Project foundProject = retrieveProject(ID);
		if(foundProject != null) {
			foundProject.setTime(newTime);
			return true;
		}else {
			return false;
		}
	}
	
	public int getTimeSpent(String ID){
		return 0;
	}
}