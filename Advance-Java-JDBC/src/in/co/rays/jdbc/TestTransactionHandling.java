package in.co.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTransactionHandling {
	
	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
			
			conn.setAutoCommit(false);
			
			Statement stmt = conn.createStatement();
			
			int i = stmt.executeUpdate(
					"insert into st_user values(8, 'xyz', 'xyz', 'xyz@gmial.com', 'xyz123', '2001-02-02')");
			i = stmt.executeUpdate(
					"insert into st_user values(8, 'xyz', 'xyz', 'xyz@gmial.com', 'xyz123', '2001-02-02')");
			i = stmt.executeUpdate(
					"insert into st_user values(9, 'xyz', 'xyz', 'xyz@gmial.com', 'xyz123', '2001-02-02')");

			conn.commit();
			
		} catch (Exception e) {
			
			System.out.println("exception " + e.getMessage());
		    
			conn.rollback();
		}
		
		finally {
			conn.close();
			
		}
		
	}

}
