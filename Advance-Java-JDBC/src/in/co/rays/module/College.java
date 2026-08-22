package in.co.rays.module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class College {
	public static void main(String[] args) throws Exception {
		
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
		
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("create table college (collegeID int primary key , collegeName varchar(50), city varchar(50), university varchar(50), contactNo int )");
		
		System.out.println("Table create successfully");
	}

}
