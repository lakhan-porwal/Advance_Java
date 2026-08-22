package in.co.rays.module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestCollege {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
		
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("insert into college values (1201,'Government Holkar Science College', 'Indroe','Devi Ahiliya Vishwavidyalaya',0731-2478800)");
		//select * from college;
		//update college set collegeID = 1, collegeName = 'midnn', city = 'mdidi', university = 'mdiddj', contactNo = 2421 )");
		//delete from college where collegeID = 1;
		
		
		System.out.println(i + " Row affected");
		
		
	}

}
