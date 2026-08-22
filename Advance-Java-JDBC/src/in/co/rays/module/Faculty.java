package in.co.rays.module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Faculty {
	
	public static void main(String[] args) throws Exception {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
		
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("create table faculty(facultyId int primary key , facultyName varchar(50), subject varchar(50), qualification varchar(50), experience varchar(50) )");
		
		System.out.println("table create successfully ");
		
	}

}
