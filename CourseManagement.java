import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CourseManagement {
	private String courseName;
	private int courseID;
	
	public CourseManagement() {
		courseName = "";
		courseID = 0;
	}
	
	public String getCourseName(){
		return courseName;
	}
	
	public void addNewCourse(String courseName, int courseID) {
		this.courseName = courseName;
		this.courseID = courseID;
		//Append course name and course ID to CourseAssignment.txt
		
		int numCourses = 0;
		for(int x = 0; x <= numCourses; x++) {
			
			//creates a new file and handles errors
			try {
				File courseReport = new File("CourseReport.txt");
			      if (courseReport.createNewFile()) {
			    	  System.out.println("New Course Report Created");
			      } else {
			        System.out.println("File already exists.");
			      }
			}
			catch(IOException f){
				System.out.println("Invalid creation");
			      f.printStackTrace();
			}
			
			//appends course to file
			try(FileWriter writer = new FileWriter("CourseReport.txt", true);
					
					
					//use buffer writer to keep appending courses without sacrificing speed
				    BufferedWriter buffer = new BufferedWriter(writer);
				    PrintWriter out = new PrintWriter(buffer))
				{
				    out.println(courseName);
				    
				} catch (IOException f) {
				    System.out.println("Invalid course addition");
				    f.printStackTrace();
				}
			
		}
	}
}
