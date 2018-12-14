package miniProject;

import java.util.Scanner;

public class Io {
	Scanner scanner;
	
	public Io() {
		scanner = new Scanner(System.in);
	}
	
	public void printMainMenu(){
		System.out.println("==============MAIN MENU==============");
		System.out.println("1 - Manipulate Projects");
		System.out.println("2 - Manipulate Members");
		System.out.println("3 - Print all Projects");
		System.out.println("4 - Print all Members");
		System.out.println("5 - Save data to files");
		System.out.println("6 - EXIT");
		System.out.print("Choice: ");
	}
	
	public void printProjectsMenu() {
		System.out.println("==============PROJECT MENU==============");
		System.out.println("1 - Add a Project");
		System.out.println("2 - Remove a Project");
		System.out.println("3 - Edit a Project");
		System.out.println("4 - View a Project");
		System.out.println("5 - GO BACK");
		System.out.print("Choice: ");
	}
	
	public void printMembersMenu() {
		System.out.println("==============MEMBER MENU==============");
		System.out.println("1 - Add a Member");
		System.out.println("2 - Remove a Member");
		System.out.println("3 - Edit a Member");
		System.out.println("4 - View a Member");
		System.out.println("5 - GO BACK");
		System.out.print("Choice: ");
	}
	
	public void printEditProjectMenu() {
		System.out.println("==============SELECT AN OPTION TO EDIT==============");
		System.out.println("1 - Name");
		System.out.println("2 - Description");
		System.out.println("3 - Duration");
		System.out.println("4 - Budget");
		System.out.println("5 - RoI");
		System.out.println("6 - GO BACK");
		System.out.print("Choice: ");
	}
	
	public void printEditPersonMenu() {
		System.out.println("==============SELECT AN OPTION TO EDIT==============");
		System.out.println("1 - Name");
		System.out.println("2 - Age");
		System.out.println("3 - GO BACK");
		System.out.print("Choice: ");
	}
	
	public void printProjectExistsError() {
		System.err.println("ERROR: The project already exists!");
	}
	
	public void printProjectNotExistsError() {
		System.err.println("ERROR: The project already exists!");
	}
	
	public void printPersonExistsError() {
		System.err.println("ERROR: The person already exists!");
	}
	
	public void printPersonNotExistsError() {
		System.err.println("ERROR: The person does not exists!");
	}
	
	public int getInteger() {
		int number = scanner.nextInt();
		scanner.nextLine();
		return number;
	}
	
	public String getString() {
		return scanner.nextLine();
	}
}
