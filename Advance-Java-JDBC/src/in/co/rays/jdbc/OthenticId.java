package in.co.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OthenticId {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo",  "root","root");
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from st_user where loginId = 'atul@gmail.com'");
		
		System.out.println(rs);
		
		while (rs.next()) {
			System.out.println(rs.getInt("id"));
			System.out.println(rs.getString("first_name"));
			System.out.println(rs.getString("last_name"));
			System.out.println(rs.getString("loginId"));
			System.out.println(rs.getString("password"));
			System.out.println(rs.getDate("dob"));
			System.out.println("--------------");
		
	}

}

}
