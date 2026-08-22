package in.co.rays.module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Branch {
	
	public static void main(String[] args) throws Exception {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
		
		Statement stmt = conn.prepareStatement("create table Branch (branchId int primary key , branchName varchar(50), city varchar(50), mangername varchar(50), contactNo varchar(50)  )");
		
		System.out.println("Table create successfully ");
		
	}

}
