package in.co.rays.module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestResult {
	

	public static void main(String[] args) throws Exception {
		
		
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
	
	Statement stmt = conn.createStatement();
	
	int i = stmt.executeUpdate("insert into result values (1,101,87.12,'A','PASS')");
	
     System.out.println("Data Inserted " + i + " Row affected");
	

}
}