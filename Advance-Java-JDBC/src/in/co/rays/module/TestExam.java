package in.co.rays.module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestExam {
	
	public static void main(String[] args) throws Exception{
		
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
		
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("insert into Exam values (1201,'MP BOARD','2027-02-10',80,28)");
		
	  	//select * from Exam;
    	//update Exam set (examId = 1,examId = 1201,examDate = yyyy-Mm-dd,totalMarks = 70, passingMarks =30);
		//delete from Exam where examI = 1;
				
		
		System.out.println(i + " Row affected");
	}

}
