package miniProject;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileWriter;

public class JsonIO 
{
	private String PersonPath="/Users/arvin/Desktop/Persons.json";
	private String ProjectPath="/Users/arvin/Desktop/Projects.json";
	
	private Set<String> PersonKeys;
	private Set<String> ProjectKeys;
	static JSONObject PersonJson = new JSONObject();
	static JSONObject ProjectJson = new JSONObject();
	private ArrayList<Person> personArrayList;
	private ArrayList<Project> projectArrayList;

	public JsonIO(String PersonPath,String ProjectPath) throws Exception 
	{
		this.PersonPath=PersonPath;
		this.ProjectPath=ProjectPath;
		PersonJson=(JSONObject) readJson(PersonPath);
		ProjectJson=(JSONObject) readJson(ProjectPath);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Person> returnPersonList()
	{
		personArrayList=new ArrayList<Person>();
		PersonKeys=PersonJson.keySet();
		for (String Key : PersonKeys) 
		{
		    Person p=new Person(Key,(String) ((JSONObject) PersonJson.get(Key)).get("name"),((Long) ((JSONObject) PersonJson.get(Key)).get("age")).intValue());
		    personArrayList.add(p);
		}
		return personArrayList;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Project> returnProjectList()
	{
		projectArrayList=new ArrayList<Project>();
		ProjectKeys=ProjectJson.keySet();
		for (String Key : ProjectKeys)
		{
			Project p=new Project(Key,(String)((JSONObject) PersonJson.get(Key)).get("name"),(String)((JSONObject) PersonJson.get(Key)).get("desc"),
					((Long) ((JSONObject) PersonJson.get(Key)).get("duration")).intValue(),((Long) ((JSONObject) PersonJson.get(Key)).get("budget")).intValue(),
					((Long) ((JSONObject) PersonJson.get(Key)).get("RoI")).intValue(),((Long) ((JSONObject) PersonJson.get(Key)).get("time")).intValue());
			projectArrayList.add(p);
		}
		return projectArrayList;
	}
	
	
	@SuppressWarnings("unchecked")
	public void addPerson(Person p)
	{
		JSONObject PersonObj = new JSONObject();
		PersonObj.put("name",p.getName());
		PersonObj.put("age",p.getAge());
		if(!personExists(p))
			PersonJson.put(p.getID(),PersonObj);
	}
	
	@SuppressWarnings("unchecked")
	public void addProject(Project p)
	{
		JSONObject ProjectObj = new JSONObject();
		ProjectObj.put("name", p.getName());
		ProjectObj.put("desc", p.getDesc());
		ProjectObj.put("duration", p.getDuration());
		ProjectObj.put("budget", p.getBudget());
		ProjectObj.put("RoI", p.getRoI());
		ProjectObj.put("time", p.getTime());
		if(!projectExists(p))
			ProjectJson.put(p.getID(), ProjectObj);
	}
	
	private boolean personExists(Person p)
	{
		return PersonJson.containsKey(p.getID());
	}
	
	private boolean projectExists(Project p)
	{
		return ProjectJson.containsKey(p.getID());
	}
	
	
	public void removePerson(Person p)
	{
		if(personExists(p))
			PersonJson.remove(p.getID());
	}
	
	public void removeProject(Project p)
	{
		if(projectExists(p))
			ProjectJson.remove(p.getID());
	}
	
	
	public void savePerson()
	{
	    try (FileWriter file = new FileWriter(PersonPath)) 
	    {
	    	file.write(PersonJson.toJSONString());
			System.out.println("Successfully Copied Person JSON Object to File...");
			System.out.println("\nJSON Object: " + PersonJson);
		} catch (IOException e) 
	    {
			e.printStackTrace();
		}
	}
	
	public void saveProject()
	{
		try (FileWriter file = new FileWriter(ProjectPath)) 
	    {
	    	file.write(ProjectJson.toJSONString());
			System.out.println("Successfully Copied Person JSON Object to File...");
			System.out.println("\nJSON Object: " + ProjectJson);
		} catch (IOException e) 
	    {
			e.printStackTrace();
		}
	}
	
	private Object readJson(String filename) throws Exception 
	{  
	    FileReader reader = new FileReader(filename);
	    JSONParser jsonParser = new JSONParser();
	    return jsonParser.parse(reader);
	}

}
