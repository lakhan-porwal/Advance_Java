package in.co.rays.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class JDBCDataSource {

	public static Connection getConnection() {
		System.out.println("in jdbcdatasource getConnection method");
		ResourceBundle rb = ResourceBundle.getBundle("com.rays.jdbc.bundle.system");

		Connection conn = null;

		try {
			Class.forName(rb.getString("driver"));

			conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("password"));
			
			System.out.println("database: " + conn.getCatalog());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;

	}

}
