package in.co.rays.module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Exam {
	
	public static void main(String[] args) throws Exception {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
		
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("create table Exam (examId int primary key , examName varchar(50),examDate date, totalMarks int ,passingMarks int )");
		
		System.out.println("Table create successfully");
		
	}

}
