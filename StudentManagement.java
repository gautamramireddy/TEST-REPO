import java.util.ArrayList;

public class StudentManagement {
	//Declares the necessary variables to represent a student
	private int studentId;
	private String firstName;
	private String lastName;
	private String studentLevel;
	private boolean active;
	private String job;
	private String jobType;
	private boolean hasJob;
	private int[] courseList;
	private int count;
	
	//DEfault constructor to initialize student
	public StudentManagement() {
		studentId = 0;
		firstName = "";
		lastName = "";
		studentLevel = "";
		active = false;
		job = "";
		jobType = "";
		hasJob = false;
		courseList = new int[20];
		count = 0;
	}
	
	//Returns student ID
	public int getStudentId() {
		return studentId;
	}
	
	//Returns first name
	public String getFirstName() {
		return firstName;
	}
	
	//Returns last name
	public String getLastName() {
		return lastName;
	}
	
	//Method to add new student object
	public void addNewStudent(int studentId, String firstName, String lastName, String studentLevel, boolean active) {
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentLevel = studentLevel;
		this.active = active;
	}
	
	//Method to set a student to active or inactive
	public void activateStudent(boolean active) {
		this.active = active;
	}
	
	//Method to return active status of student
	public boolean getStatus() {
		return active;
	}
	
	public void addCourseToList(int courseID) {
		courseList[count] = courseID;
		count++;
	}
	
	public void addJob(String job, String jobType) {
		this.job = job;
		this.jobType = jobType;
		hasJob = true;
	}
	
	public String getJob() {
		return job;
	}
	
	public String getJobType() {
		return jobType;
	}
	
	public boolean hasJobOrNot() {
		return hasJob;
	}
	
	public void displayCourseList() {
		System.out.println("Courses:");
		
		for(int x = 0; x < count; x++) {
			System.out.println(courseList[x]);
		}
	}
	
	//Display the single StudentManagement object
	public void display() {
		System.out.println("Student ID: " + studentId);
		System.out.println("Name: " + firstName + " " + lastName);
		System.out.println("Student Level: " + studentLevel);
		System.out.println("Active: " + active);
	}
}
