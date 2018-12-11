package miniProject;

import java.util.Scanner;

public class Io {
	Scanner scanner;
	
	public Io() {
		scanner = new Scanner(System.in);
	}
	
	public void printMainMenu(){
		System.out.println("Actions");
		System.out.println("1 - Manipulate Projects");
		System.out.println("2 - Manipulate Members");
		System.out.println("3 - Save data to files");
		System.out.println("4 - EXIT");
		System.out.print("Choice: ");
	}
	
	public void printProjectsMenu() {
		System.out.println("Actions");
		System.out.println("1 - Add a Project");
		System.out.println("2 - Remove a Project");
		System.out.println("3 - Edit a Project");
		System.out.println("4 - GO BACK");
		System.out.print("Choice: ");
	}
	
	public void printMembersMenu() {
		System.out.println("Actions");
		System.out.println("1 - Add a Member");
		System.out.println("2 - Remove a Member");
		System.out.println("3 - Edit a Member");
		System.out.println("4 - GO BACK");
		System.out.print("Choice: ");
	}
	
	public void printAddProjectMenu() {
		
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
