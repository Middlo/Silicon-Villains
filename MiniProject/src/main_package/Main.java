package main_package;


import java.util.ArrayList;

public class Main{
	ArrayList<Project> projects;
	ArrayList<Person> people;
	JsonIO jsonio;
	
	public Main() throws Exception {
		jsonio = new JsonIO("/Users/Public/Persons.json","/Users/Public/Projects.json");
		projects = jsonio.returnProjectList();
		people = jsonio.returnPersonList();
	}
	
	public static void main (String[]args) throws Exception {
		Main program = new Main();
		program.run();
	}
	
	public void run() {
		
		int mainMenuChoice,projectsMenuChoice,memberMenuChoice,editProjectMenuChoice,editPersonMenuChoice;
		Person foundPerson;
		Project foundProject;
		
		Io io = new Io();
		
		do {
			io.printMainMenu();
			mainMenuChoice = io.getInteger();
			
			switch (mainMenuChoice) {
			case 1:
			//PROJECT MANIPULATION
				
				String id,name,desc,projectId;
				int duration,budget,RoI,age,salary,time;
				
				io.printProjectsMenu();
				projectsMenuChoice = io.getInteger();
				switch (projectsMenuChoice) {
				case 1:
				//ADD PROJECT	
					
					System.out.println("Insert ID:");
					id = io.getString();
					
					if(retrieveProject(id)==null) {
						System.out.println("Insert name:");
						name = io.getString();
						
						System.out.println("Insert desc:");
						desc = io.getString();
						
						System.out.println("Insert duration:");
						duration = io.getInteger();
						
						System.out.println("Insert budget:");
						budget = io.getInteger();
						
						System.out.println("Insert RoI:");
						RoI = io.getInteger();
						
						createProject(id,name,desc,duration,budget,RoI);
						System.out.println("Project created");
					}else {
						io.printProjectExistsError();
					}
					break;
				case 2:
				//REMOVE PROJECT
					
					System.out.println("Insert ID:");
					id = io.getString();
					
					if(retrieveProject(id)!=null) {
						removeProject(id);
						System.out.println("Person removed");
					}else {
						io.printProjectNotExistsError();
					}
					break;
				case 3:
				//EDIT PROJECT
					
					System.out.println("Insert ID:");
					id = io.getString();
					
					foundProject = retrieveProject(id);					
					if(foundProject!=null) {
						System.out.println("Project found:\n" + foundProject);
						do {
							io.printEditProjectMenu();
							editProjectMenuChoice = io.getInteger();
							switch (editProjectMenuChoice) {
							case 1:
								System.out.print("Insert new name: ");
								name = io.getString();
								this.updateProjectName(id, name);
								break;
							case 2:
								System.out.print("Insert new desc: ");
								desc = io.getString();
								this.updateProjectDesc(id, desc);
								break;
							case 3:
								System.out.print("Insert new duration: ");
								duration = io.getInteger();
								this.updateProjectDuration(id, duration);
								break;
							case 4:
								System.out.print("Insert new budget: ");
								budget = io.getInteger();
								this.updateProjectBudget(id, budget);
								break;
							case 5:
								System.out.print("Insert new RoI: ");
								RoI = io.getInteger();
								this.updateProjectRoI(id, RoI);
								break;
							}
						}while(editProjectMenuChoice!=6);
					}else {
						io.printProjectNotExistsError();
					}
					break;
				case 4:
				//VIEW PROJECT
					
					System.out.println("Insert ID:");
					id = io.getString();
					
					foundProject = retrieveProject(id);
					
					if(foundProject!=null) {
						System.out.println(foundProject);
					}else {
						io.printPersonNotExistsError();
					}
					break;
				}
				
				break;
			case 2:
			//MEMBER MANIPULATION
				
				do {
					io.printMembersMenu();
					memberMenuChoice = io.getInteger();
					switch (memberMenuChoice) {
					case 1:
					//ADD MEMBER					
						
						System.out.println("Insert ID:");
						id = io.getString();
						
						if(retrievePerson(id)==null) {
							System.out.println("Insert ID of the project this member is part of:");
							projectId = io.getString();
							Project linkedProject = retrieveProject(projectId);
							if(linkedProject!=null) {
								//Here the member is linked to the project by
								//adding the ID of the member and the time spent in the project
								//(0 in this case because the member is yet to create)
								//by creating an object of type PersonTime and pushing it into the
								//array "times" of type PersonTime in the object of type Project
								//-----
								//See how an Object of type Project is structured
								
								linkedProject.addTime(id,0);
								
								System.out.println("Insert name:");
								name = io.getString();
								
								System.out.println("Insert age:");
								age = io.getInteger();
								
								System.out.println("Insert salary:");
								salary = io.getInteger();
								
								createPerson(id,name,age,salary);
								System.out.println("Person created");
							}else {
								System.out.println("Project " + projectId + " does not exist!");
								System.out.println("Aborting member creation...");
							}
						}else {
							io.printPersonExistsError();
						}
						
						break;
					case 2:
					//REMOVE MEMBER
						
						System.out.println("Insert ID:");
						id = io.getString();
						
						if(retrievePerson(id)!=null) {
							//TODO Remove link between project and member
							if(removeTime(id)) {
								System.out.println("Link removed");
							}else {
								System.out.println("Couldn't remove link");
							}
							removePerson(id);
							System.out.println("Person removed");
						}else {
							io.printPersonNotExistsError();
						}
						break;
					case 3:
					//EDIT MEMBER
						
						System.out.println("Insert ID:");
						id = io.getString();
						
						foundPerson = retrievePerson(id);
						if(foundPerson!=null) {
							System.out.println("Person found:\n" + foundPerson);
							io.printEditPersonMenu();
							editPersonMenuChoice = io.getInteger();
							switch (editPersonMenuChoice) {
							case 1:
								System.out.print("Insert new name: ");
								name = io.getString();
								this.updatePersonName(id, name);
								break;
							case 2:
								System.out.print("Insert new age: ");
								age = io.getInteger();
								this.updatePersonAge(id, age);
								break;
							}
						}else {
							io.printPersonNotExistsError();
						}
						break;
					case 4:
					//VIEW MEMBER
						
						System.out.println("Insert ID:");
						id = io.getString();
						
						foundPerson = retrievePerson(id);
						
						if(foundPerson!=null) {
							System.out.println(foundPerson);
						}else {
							io.printPersonNotExistsError();
						}
						break;
					}
				}while(memberMenuChoice!=5);
					break;
			case 3:
			//FEATURES
				io.printFeaturesMenu();
				break;
			case 4:
			//PRINT EACH PROJECT
				
				for(Project each : this.projects) {
					System.out.println(each);
				}
				break;
			case 5:
			//PRINT EACH MEMBER
				
				for(Person each : this.people) {
					System.out.println(each);
				}
				break;
			case 6:
			//SAVE ALL TO FILE
				
				jsonio.savePerson();
				jsonio.saveProject();
				System.out.println("Saved Projects and People to file!");
				break;
			}
		}while(mainMenuChoice!=7);
	}
	
	public boolean createPerson(String ID, String name, int age, double salary) {
		Person person = new Person(ID, name, age, salary);
		
		if(retrievePerson(ID)==null) {
			this.people.add(person);
			jsonio.addPerson(person);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean removeTime(String ID) {
		//Function that removes the link between a Project and a Member
		//by deleting the object of type PersonTime in the ArrayList times
		//which is an attribute of the Project
		//------
		//This is called on deletion of a member to delete the unnecessary 
		//link between the Project and the deleted member
		for(Project each : this.projects) {
			if(each.hasMember(ID)) {
				each.removeTime(ID);
				return true;
			}
		}
		return false;
	}
	
	public boolean removePerson(String ID) {
		//Deletes a project with specified ID if it is present in the ArrayList
		Person person = retrievePerson(ID);// we get employee with this ID
			
		if (person != null) {
			this.people.remove(person);// we remove that employee if he/she exists
			jsonio.removePerson(person);
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
	public void createProject(String ID, String name, String desc, int duration, int budget, int RoI) {
		Project project = new Project(ID, name, desc, duration, budget, RoI);
		
		if(retrieveProject(ID)==null) {
			this.projects.add(project);
			jsonio.addProject(project);
		}else {
			System.err.println("Error: Cannot add project, project already existing");
		}
	}
	//removePreject is Done
	public void removeProject(String ID) {
		//Deletes a project with specified ID if it is present in the ArrayList
		Project project = retrieveProject(ID);// we get employee with this ID
		
		if (project != null) {
			this.projects.remove(project);// we remove that employee if he/she exists
			jsonio.removeProject(project);
		}else {
		System.out.println("Project with this ID:" + ID + " is not registered in the system.");
		}
	}
	
	//retrieveProject is Done
	public Project retrieveProject(String ID) {
		//Retrieves the Project with id specified if it is present in the arraylist
		//otherwise returns null if it is not present


		for(Project each : projects){
			if(each != null && each.getID().equals(ID) ){
				return each;
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

	public ArrayList<Project> productsParticipated(String ID) {
		// this method should return each members work products participated on the
		// project.
		ArrayList<Project> ParticipationList = new ArrayList<>();
		//for each Project
		//for each PeronTime
		//check if ID equals to
		for (Project each : projects){
			for(PersonTime every:each.getTimes() ){
				if(every.getID().equals(ID)){
					ParticipationList.add(each);
				}
			}
		}
		return ParticipationList;
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
	
	public int timeSpent(String ID) {
		int sum = 0;
		
		for(Project eachProject : this.projects) {
			for(PersonTime eachTime : eachProject.getTimes()) {
				if(eachTime.getID().equals(ID)) {
					sum += eachTime.getTime();
				}
			}
		}
		
		return sum;
	}
}