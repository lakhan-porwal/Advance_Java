package in.co.rays.module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestFaculty {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:/demo", "root", "root");
		
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("insert into faculty values (101, 'MR. Ramesh Babu' , 'Chemistry', 'B.Ed', '5Years')");
		
		System.out.println("Data Insertesd " + i + " Row affected");
		
		
	}

}
