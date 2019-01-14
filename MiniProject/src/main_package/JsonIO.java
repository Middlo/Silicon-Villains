package main_package;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import java.io.FileWriter;

public class JsonIO {
	private String PersonPath = "/Users/public/Persons.json";
	private String ProjectPath = "/Users/public/Projects.json";

	private Set<String> PersonKeys;
	private Set<String> ProjectKeys;
	static JSONObject PersonJson = new JSONObject();
	static JSONObject ProjectJson = new JSONObject();
	private ArrayList<Person> personArrayList;
	private ArrayList<Project> projectArrayList;

	public JsonIO(String PersonPath, String ProjectPath) throws Exception {
		this.PersonPath = PersonPath;
		this.ProjectPath = ProjectPath;
		try {
			PersonJson = (JSONObject) readJson(PersonPath);
			ProjectJson = (JSONObject) readJson(ProjectPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Person> returnPersonList() {
		personArrayList = new ArrayList<Person>();
		PersonKeys = PersonJson.keySet();
		for (String Key : PersonKeys) {
			Person p = new Person(Key, (String) ((JSONObject) PersonJson.get(Key)).get("name"),
					((Long) ((JSONObject) PersonJson.get(Key)).get("age")).intValue(),
					((Long) ((JSONObject) PersonJson.get(Key)).get("salary")).intValue());
			personArrayList.add(p);
		}
		return personArrayList;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Project> returnProjectList() {
		projectArrayList = new ArrayList<Project>();
		ProjectKeys = ProjectJson.keySet();
		for (String Key : ProjectKeys) {
			PersonTime[] timesArray;
			try {
				timesArray = (PersonTime[])((JSONObject) ProjectJson.get(Key)).get("times");
			}
			catch(NullPointerException e) {
				timesArray = new PersonTime[0];
			}
			//The simple array is read from the file 
			
			ArrayList<PersonTime> times = new ArrayList<PersonTime>(Arrays.asList(timesArray));
			//The simple array is converted into ArrayList and saved
			//Same process below...
			Task[] tasksArray;
			try{
				tasksArray = (Task[])((JSONObject) ProjectJson.get(Key)).get("tasks");
			}
			catch(NullPointerException e) {
				tasksArray = new Task[0];
			}
			ArrayList<Task> tasks = new ArrayList<Task>(Arrays.asList(tasksArray));
			
			//Because an ArrayList can't be stored in a JSON file
			//the simple arrays stored in the JSON file are converted into an arraylist
			//and put in an object of type Project
			
			Project p = new Project(Key, (String) ((JSONObject) ProjectJson.get(Key)).get("name"),
					(String) ((JSONObject) PersonJson.get(Key)).get("desc"),
					((Long) ((JSONObject) PersonJson.get(Key)).get("duration")).intValue(),
					((Long) ((JSONObject) PersonJson.get(Key)).get("budget")).intValue(),
					((Long) ((JSONObject) PersonJson.get(Key)).get("RoI")).intValue(),
					(times),
					(tasks)
					);
			
			projectArrayList.add(p);
		}
		return projectArrayList;
	}

	@SuppressWarnings("unchecked")
	public void addPerson(Person p) {
		JSONObject PersonObj = new JSONObject();
		PersonObj.put("name", p.getName());
		PersonObj.put("age", p.getAge());
		if (!personExists(p))
			PersonJson.put(p.getID(), PersonObj);
	}

	@SuppressWarnings("unchecked")
	public void addProject(Project p) {	
		JSONObject ProjectObj = new JSONObject();
		
		
		//Because an ArrayList can't be stored in a JSON file
		//the ArrayLists times and tasks are converted into simple arrays and stored
		
		ArrayList<PersonTime> timesList = p.getTimes();
		System.out.println(timesList);
		//PersonTime[] times = (PersonTime[]) timesList.toArray(new PersonTime[timesList.size()]);
		
		String times = JSONValue.toJSONString(timesList);
		
		ArrayList<Task> tasksList = p.getTasks();
		//Task[] tasks = (Task[]) tasksList.toArray(new Task[tasksList.size()]);
		
		String tasks = JSONValue.toJSONString(tasksList);
		
		//-----
		
		ProjectObj.put("name", p.getName());
		ProjectObj.put("desc", p.getDesc());
		ProjectObj.put("duration", p.getDuration());
		ProjectObj.put("budget", p.getBudget());
		ProjectObj.put("RoI", p.getRoI());
		ProjectObj.put("times", times);
		ProjectObj.put("tasks", tasks);
		if (!projectExists(p))
			ProjectJson.put(p.getID(), ProjectObj);
	}

	private boolean personExists(Person p) {
		return PersonJson.containsKey(p.getID());
	}

	private boolean projectExists(Project p) {
		return ProjectJson.containsKey(p.getID());
	}

	public void removePerson(Person p) {
		if (personExists(p))
			PersonJson.remove(p.getID());
	}

	public void removeProject(Project p) {
		if (projectExists(p))
			ProjectJson.remove(p.getID());
	}

	public void savePerson() {
		try (FileWriter file = new FileWriter(PersonPath)) {
			file.write(PersonJson.toJSONString());
			System.out.println("Successfully Copied Person JSON Object to File...");
			System.out.println("\nJSON Object: " + PersonJson);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveProject() {
		try (FileWriter file = new FileWriter(ProjectPath)) {
			file.write(ProjectJson.toJSONString());
			System.out.println("Successfully Copied Person JSON Object to File...");
			System.out.println("\nJSON Object: " + ProjectJson);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Object readJson(String filename) throws Exception {
		FileReader reader = new FileReader(filename);
		JSONParser jsonParser = new JSONParser();
		return jsonParser.parse(reader);
	}
	
	@SuppressWarnings("unchecked")
	public void updateTimes(String Key, Project p) {
		JSONObject ProjectObj = ((JSONObject) ProjectJson.get(Key));
		ArrayList<PersonTime> timesList = p.getTimes();
		
		String times = JSONValue.toJSONString(timesList);
		
		ProjectObj.put("times", times);
		System.out.println("TIMES = "+times);
		ProjectJson.put(Key, ProjectObj);
	}
}
