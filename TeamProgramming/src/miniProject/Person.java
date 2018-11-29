package miniProject;

import java.util.ArrayList;

public class Person {
	private String ID;
	private String name;
	private int age;
	ArrayList<Project> A;
	// add fixed salary

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
}
