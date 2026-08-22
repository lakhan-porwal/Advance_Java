package in.co.rays.module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.rays.jdbc.preparedstatement.UserBean;

import in.co.rays.util.JDBCDataSource;

public class TestBranch {
	
	public static void main(String[] args)  throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
		
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("insert into branch values (1,'NCS', 'Indore' , 'Atul', 179381265 )");
		
		System.out.println("Record Inserted Successfully :- " + i );
		
	}
	
}
