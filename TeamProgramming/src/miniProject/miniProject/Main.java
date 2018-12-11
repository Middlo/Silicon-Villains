package miniProject;

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
	
	public boolean createPerson(String ID, String name, int age) {
		Person person = new Person(ID, name, age);
		
		if(retrievePerson(ID)==null) {
			this.people.add(person);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean removePerson(String ID) {
		//Deletes a project with specified ID if it is present in the ArrayList
		Person person = retrievePerson(ID);// we get employee with this ID
			
		if (person != null) {
			this.people.remove(person);// we remove that employee if he/she exists
			return true;
		}else {
			return false;
		}
	}
	
	public Person retrievePerson(String ID) {
		//Retrieves the Project with id specified if it is present in the arraylist
		//otherwise returns null if it is not present

//		for each option
//		for(Person each : people){
//			if(each != null && each.getID().equals(ID) ){
//				return each;
//			}
//		}

		for (int i = 0; i < this.people.size(); i++) { 
			if (people.get(i) != null && people.get(i).getID().equals(ID)) { 
				return people.get(i); 
			}
		}
		return null;
	}
	
	//updatePersonName is Done
	public boolean updatePersonName(String ID,String newName) {
		//Returns true if the name is successfully edited, returns false if not
		Person foundPerson= retrievePerson(ID);
		if(foundPerson != null) {
			foundPerson.setName(newName);
			return true;
		}else {
			return false;
		}
	}
	
	//updatePersonAge is Done
		public boolean updatePersonAge(String ID,int newAge) {
			//Returns true if the name is successfully edited, returns false if not
			Person foundPerson= retrievePerson(ID);
			if(foundPerson != null) {
				foundPerson.setAge(newAge);
				return true;
			}else {
				return false;
			}
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

//		for each option
//		for(Project each : projects){
//			if(each != null && each.getID().equals(ID) ){
//				return each;
//			}
//		}

		for (int i = 0; i < this.projects.size(); i++) {
			if (projects.get(i) != null && projects.get(i).getID().equals(ID)) { 
				return projects.get(i);
			}
		}
		return null;
	}

	// Shifted from Person.java to here
	// More appropriate, as Person.java is for creating a template of person
	// When you create a person, you would not know the projects he/she participated in
	// Same goes for the Project.java file, you create only a project template
	// Should be able to retrieve each project done based on id
	// Stores them into a new ArrayList
	// Displays them by printing out (??? toString ???)

	public String productsParticipated(String ID) {
		// this method should return each members work products participated on the
		// project.
		ArrayList<Project> ParticipationList = new ArrayList<>();
		ParticipationList.add(retrieveProject(ID));

		System.out.println(ParticipationList);
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
	public boolean updateProjectTime(String ID, String personID,int newTime) {
		//Returns true if the time is successfully edited, returns false if not
		Project foundProject = retrieveProject(ID);
		if(foundProject != null) {
			return foundProject.updateTime(personID, newTime);
		}else {
			return false;
		}
	}
}