package in.co.rays.module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Result {
	
	public static void main(String[] args) throws Exception {
		
		
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
	
	Statement stmt = conn.createStatement();
	
	int i = stmt.executeUpdate("create table result (resultId int primary key , studentId int , percentage double , grade char(2), resultStatus varchar(20) )");
	
	System.out.println("Table create successfully");

	}

}
