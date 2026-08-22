package com.rays.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestUserModel {
	
	public static void main(String[] args) throws Throwable {
		
//		testAdd();
		testUpdate();
//		testDelete();
	}
	
	public static void testAdd () throws Exception {
		
		
		SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd");
		UserModel model = new UserModel ();
		
		UserBean bean = new UserBean();
		
		bean.setId(6);
		bean.setFirst_name("Shreya");
		bean.setLast_name("Kumrawat");
		bean.setLoginId("shreya123@gmail.com");
		bean.setPassword("shreya123@");
		bean.setDob(sdf.parse("2010-01-30"));
		
		 model.add(bean);
		 
	}
	
	
	public static void testUpdate () throws Throwable {
		
		Connection conn = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd");
			UserModel model = new UserModel ();
			
			UserBean bean = new UserBean();
			
			bean.setId(6);
			bean.setFirst_name("Jeevan");
			bean.setLast_name("Patidar");
			bean.setLoginId("Jeevan@gmail.com");
			bean.setPassword("jeevan12@");
			bean.setDob(sdf.parse("2007-11-16"));
			
			
			
			model.update(bean);
			
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		}
		finally {
			conn.close();
		}
		
	}
	
	public static void testDelete () throws SQLException, ParseException {
		
		UserModel model = new UserModel ();
		
		model.delete(6);
		
		
	}

}
