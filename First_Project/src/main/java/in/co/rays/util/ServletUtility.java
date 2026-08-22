package in.co.rays.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletUtility {

	public static Connection getConnection() {

		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.system");

		Connection conn = null;

		try {

			Class.forName(rb.getString("driver"));

			conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("password"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;

	}

	public static void forward(String string, HttpServletRequest request, HttpServletResponse response) {
		
	}

}