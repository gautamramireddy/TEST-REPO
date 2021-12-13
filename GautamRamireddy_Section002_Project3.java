import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GautamRamireddy_Section002_Project3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Variables to hold student info
		String firstName = "";
		String lastName = "";
		String level = "";
		int userChoice = 0;
		int option = 0;
		int count = 0;
		
		
		//Declares and initializes the Scanner variable
		Scanner scan = new Scanner(System.in);
	
		
		//Prompts the user how many students they will have
		System.out.println("Welcome to Student and Course Management System!\n"
				+ "\n"
				+ "This system will allow you to manage students and courses. Let’s start with the number of students this system will have:\n"
				+ "");
		int numStudents = scan.nextInt();
		
		//Declares and initializes the Student Management object array
		StudentManagement[] studentList = new StudentManagement[numStudents + 30];
		
		scan.nextLine();
		
		//ask
		for(int x = 0; x < numStudents; x++) {
			System.out.println("Enter first name: ");
			firstName = scan.nextLine();
			
			System.out.println("Enter last name: ");
			lastName = scan.nextLine();
			
			System.out.println("Enter level of the student: ");
			level = scan.nextLine();
			
			StudentManagement student = new StudentManagement();
			int ID = (int)(Math.random()*99+1);
			student.addNewStudent(ID, firstName, lastName, level, true);
			studentList[x] = student;
			
			System.out.println(firstName + " " + lastName + " has been added as a "  +level  + " with ID " + ID);
		}
		
		System.out.println("***Welcome to Student and Course Management System***\n"
				+ "\n"
				+ "Press ‘1’ for Student Management System (SMS)\n"
				+ "Press ‘2’ for Course Management System (CMS)\n"
				+ "Press ‘0’ to exit\n");
		option = scan.nextInt();
		
		while(option < 0 || option > 2) {
			System.out.println("Invalid option. Please enter a number between 0-2");
			option = scan.nextInt();
		}
		
		count = numStudents;
		
		while(true) {
			if(option == 1) {
				System.out.println("***Welcome to Student Management System***\n"
						+ "Press ‘1’ to add a student\n"
						+ "Press ‘2’ to deactivate a student\n"
						+ "Press ‘3’ to display all students\n"
						+ "Press ‘4’ to search for a student by ID\n"
						+ "Press ‘5’ to assign on-campus job\n"
						+ "Press ‘6’ to display all students with on-campus jobs\n"
						+ "Press ‘0’ to exit the system\n"
						+ "");
				userChoice = scan.nextInt();
				count = numStudents;
				
				while(true) {
					if(userChoice == 1) {
						scan.nextLine();
						
						System.out.println("Enter first name: ");
						firstName = scan.nextLine();
						
						System.out.println("Enter last name: ");
						lastName = scan.nextLine();
						
						System.out.println("Enter level of the student: ");
						level = scan.nextLine();
						
						StudentManagement student = new StudentManagement();
						int ID = (int)(Math.random()*99+1);
						student.addNewStudent(ID, firstName, lastName, level, true);
						studentList[count] = student;
						count++;
						
						System.out.println(firstName + " " + lastName + " has been added as a "  + level  + " with ID " + ID);
					}
					else if(userChoice == 2) {
						System.out.println("Enter ID of student: ");
						int ID = scan.nextInt();
						
						if(searchForStudent(studentList, numStudents + (count - numStudents), ID) == -1) {
							System.out.println("Student not found");
							continue;
						}
						
						studentList[searchForStudent(studentList, numStudents + (count - numStudents), ID)].activateStudent(false);
						System.out.println(studentList[searchForStudent(studentList, numStudents + (count - numStudents), ID)].getFirstName() + " " + 
										   studentList[searchForStudent(studentList, numStudents + (count - numStudents), ID)].getLastName() + " has been deactivated.");
					}
					else if(userChoice == 3) {
						displayStudents(studentList, numStudents + (count - numStudents));
					}
					else if(userChoice == 4) {
						System.out.println("Enter ID of student:");
						int ID = scan.nextInt();
						
						if(searchForStudent(studentList, numStudents + (count - numStudents), ID) == -1) {
							System.out.println("Student not found");
							continue;
						}
						
						studentList[searchForStudent(studentList, numStudents + (count - numStudents), ID)].display();	
					}
					else if(userChoice == 5) {
						System.out.println("Enter student ID:\n");
						int stuID = scan.nextInt();
						
						scan.nextLine();
						
						System.out.println("Enter job:\n");
						String job = scan.nextLine();
						
						System.out.println("Enter job type:\n");
						String jobType = scan.nextLine();
						
						studentList[searchForStudent(studentList, numStudents + (count - numStudents), stuID)].addJob(job, jobType);
						System.out.println(studentList[searchForStudent(studentList, numStudents + (count - numStudents), stuID)].getFirstName() + " " + 
										   studentList[searchForStudent(studentList, numStudents + (count - numStudents), stuID)].getLastName() + " has been assigned " +
										   jobType + " " + job + " job.");
					}
					else if(userChoice == 6) {
						displayStudentsWithJob(studentList, numStudents + (count - numStudents));
					}
					else {
						break;
					}
					
					System.out.println("***Welcome to Student Management System***\n"
							+ "Press ‘1’ to add a student\n"
							+ "Press ‘2’ to deactivate a student\n"
							+ "Press ‘3’ to display all students\n"
							+ "Press ‘4’ to search for a student by ID\n"
							+ "Press ‘5’ to assign on-campus job\n"
							+ "Press ‘6’ to display all students with on-campus jobs\n"
							+ "Press ‘0’ to exit the system\n"
							+ "");
					userChoice = scan.nextInt();
				}
			}
			else if(option == 2) {
				System.out.println("***Welcome to CMS***\n"
						+ "\n"
						+ "Press ‘1’ to add a new course\n"
						+ "Press ‘2’ to assign student a new course\n"
						+ "Press ‘3’ to display student with assigned courses\n"
						+ "Press ‘0’ to exit CMS\n");
				userChoice = scan.nextInt();
				
				while(true) {
					if(userChoice == 1) {
						CourseManagement course = new CourseManagement();
						
						System.out.println("Enter course ID:\n");
						int ID = scan.nextInt();
						
						scan.nextLine();
						
						System.out.println("Enter course name:\n");
						String name = scan.nextLine();
						
						course.addNewCourse(name, ID);
						System.out.println("Confirmation: New course " + ID + " has been added\n");
					}
					else if(userChoice == 2) {
						System.out.println("Enter student ID:\n");
						int stuID = scan.nextInt();
						
						System.out.println("Enter course ID:\n");
						int courseID = scan.nextInt();
						
						studentList[searchForStudent(studentList, numStudents + (count - numStudents), stuID)].addCourseToList(courseID);
						System.out.println("Confirmation: " + studentList[searchForStudent(studentList, numStudents + (count - numStudents), stuID)].getFirstName() + " " + 
										   studentList[searchForStudent(studentList, numStudents + (count - numStudents), stuID)].getLastName() + 
										   " has been assigned course " + courseID);
					}
					else if(userChoice == 3) {
						displayStudentAndCourses(studentList, numStudents + (count - numStudents));
					}
					else {
						break;
					}
					
					System.out.println("***Welcome to CMS***\n"
							+ "\n"
							+ "Press ‘1’ to add a new course\n"
							+ "Press ‘2’ to assign student a new course\n"
							+ "Press ‘3’ to display student with assigned courses\n"
							+ "Press ‘0’ to exit CMS\n");
					userChoice = scan.nextInt();
				}
			}
			else {
				System.out.println("Good Bye!!!");
				System.exit(0);
			}
			
			System.out.println("***Welcome to Student and Course Management System***\n"
					+ "\n"
					+ "Press ‘1’ for Student Management System (SMS)\n"
					+ "Press ‘2’ for Course Management System (CMS)\n"
					+ "Press ‘0’ to exit\n");
			option = scan.nextInt();
			
			while(option < 0 || option > 2) {
				System.out.println("Invalid option. Please enter a number between 0-2");
				option = scan.nextInt();
			}
		}
	}

	//Returns the index of the student in the array
	public static int searchForStudent(StudentManagement[] list, int numStudents, int studentID) {
		for(int x = 0; x < numStudents; x++) {
			if(list[x].getStudentId() == studentID) {
				return x;
			}
		}
		
		//Returns -1 if the student is not found
		return -1;
	}
	
	//Displays students in alphabetical order
	public static void displayStudents(StudentManagement[] list, int numStudents) {
		ArrayList<String> firstNames = new ArrayList<>();
		StudentManagement[] newList = new StudentManagement[numStudents];
		
		for(int x = 0; x < numStudents; x++) {
			firstNames.add(list[x].getFirstName());
		}
		
		Collections.sort(firstNames);
		
		for(int x = 0; x < numStudents; x++) {
			for(int y = 0; y < numStudents; y++) {
				if(list[y].getFirstName().equals(firstNames.get(x)) && list[y].getStatus()) {
					list[y].display();
				}
			}
			
			System.out.println("\n");
		}
		
		for(int x = 0; x < numStudents; x++) {
			//Write each name out to file named StudentReport.txt
			//list[x].getFirstName() + " " + list[x].getLastName()
			//overwrite every time
			
			//Create new file and file writing plus exception handling
			try {
				File studentReport = new File("StudentReport.txt");
				if(studentReport.createNewFile()) {
					System.out.println("File " + studentReport.getName() + " created.");
				}
				
				else {
					System.out.println("Cannot create this file.");
				}
				
			}
			catch(IOException f){
				System.out.println("Invalid creation of file");
				f.printStackTrace();
				
			}
			
			try {
			      FileWriter myWriter = new FileWriter("StudentReport.txt");
			      myWriter.write(list[x].getFirstName() + " " + list[x].getLastName());
			      myWriter.close();
			      
			    } 
			catch (IOException f) {
			      System.out.println("An error occurred.");
			      f.printStackTrace();
			    }
		}
	}
	
	public static void displayStudentsWithJob(StudentManagement[] list, int numStudents) {
		for(int x = 0; x < numStudents; x++) {
			if(list[x].hasJobOrNot()) {
				System.out.println(list[x].getFirstName() + " " + list[x].getLastName());
				System.out.println("ID - " + list[x].getStudentId());
				System.out.println(list[x].getJobType() + " " + list[x].getJob());
			}
		}
	}
	
	private static void displayStudentAndCourses(StudentManagement[] list, int numStudents) {
		for(int x = 0; x < numStudents; x++) {
			System.out.println(list[x].getFirstName() + " " + list[x].getLastName());
			System.out.println("ID - " + list[x].getStudentId());
			list[x].displayCourseList();
		}
	}
}








