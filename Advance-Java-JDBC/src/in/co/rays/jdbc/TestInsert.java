package in.co.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {
	
public static void main(String[] args) throws Exception {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
		
	    Statement stmt =	conn.createStatement();
		
		int i = stmt.executeUpdate("insert into st_user values (7,'Ayush','Porwal','Aysuh@gmail.com','Ayush','2026-02-05')");
		
		System.out.println("Record inserted " + i + " Row affected ");

}
}