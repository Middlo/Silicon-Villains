import java.util.ArrayList;

public class Person {
	private String ID;
	private String name;
	private int age;
	ArrayList<Project> A;
	ArrayList<Person> people;
	private final int Salary= 15000;// add fixed salary

	Person(String ID, String name, int age) {
		this.ID = ID;
		this.name = name;
		this.age = age;
	}
	

	public String getID() {
		return this.ID;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}
	public void setAge(String ID, int newAge) {
		this.age = newAge;
	}
	public void setName(String ID, String newName) {
		this.name = newName;
	}
	public String toString() {

		final String END_OF_LINE = System.lineSeparator();
		String info = "ID of a person: " + this.ID + END_OF_LINE;
		info += "Name: " + this.name + END_OF_LINE;
		info += "Age: " + this.age + " years" + END_OF_LINE;
		info += "Salary: " + this.Salary + " SEK per month" + END_OF_LINE;


		return info;
	}

	public int timePerProject() {
		// this method should return members individual time contribution on all
		// projects.
		return 0;
	}

	public int timePerMember() {
		// this method should return each members individual time contributed on the
		// project.
		return 0;
	}

	public String productsParticipated() {
		// this method should return each members individual time contributed on the
		// project.
		return null;
	}
	public void createPerson(String ID, String name, int age) {

		Person person = new Person(ID, name, age);
		this.people.add(person);
	}
	public Person getPerson(int position) {
		return this.people.get(position);
	}
	public Person retrievePerson(String ID) {

		for (int i = 0; i < this.people.size(); i++) { // we go through the list of employees
			if (people != null && getPerson(i).getID().equals(ID)) { // we check if the ID's are same
				return people.get(i); // if they are same and he/she exists, we get that employee
			}
		}
		System.out.println("Person with this ID:" + ID + " is not registered in the system.");// otherwise we print a
																							// message
		return null;
	}
	public void removePerson(String ID) {

		Person person = retrievePerson(ID);// we get employee with this ID
		if (person != null)
			people.remove(person);// we remove that employee if he/she exists

		else
		System.out.println("Person with this ID:" + ID + " is not registered in the system.");
	}
	public void updateName(String ID, String newName) {

		Person person = retrievePerson(ID);// we get employee with this ID
		if (person != null) {
			person.setName(ID, newName);// we set new name if that employee exists
		} else
			System.out.println("Person with this ID: " + ID + " is not registered in the system.");
	}

	public void updateAge(String ID, int newAge) {

		Person person = retrievePerson(ID);// we get employee with this ID
		if (person != null) {
			person.setAge(ID, newAge);// we update salary if that employee exists
		} else
			System.out.println("Person with this ID: " + ID + " is not registered in the system.");
	}

	public String printOnePerson(String ID) {
		Person exactPerson = retrievePerson(ID);// we get employee with this ID
		if (exactPerson != null) {
			return exactPerson.toString();
		} else
			return "Person with this ID: " + ID + " does not exist.";

	}

}
