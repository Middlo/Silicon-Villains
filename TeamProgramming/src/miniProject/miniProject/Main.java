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
		program.run();
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
	
	int getTimeSpent(String memberId){
		
	}
}