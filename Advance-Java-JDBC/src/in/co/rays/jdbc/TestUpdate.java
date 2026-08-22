package in.co.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class TestUpdate {
	
	public static void main(String[] args)  throws Exception {
		
	
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
	
	Statement stmt = conn.createStatement();
	
	int i = stmt.executeUpdate("update st_user set first_name = 'atul', last_name = 'porwal', loginId = 'atul@gmail.com', password = 'atul'  where id = 5");
	
	System.out.println("record updated " + i + "row affected");
	
	}

}
