package com.rays.jdbc.preparedstatement1;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {
	
	public static void main(String[] args) throws Throwable {
		
//		testAdd();
//		testUpdate();
//		testDelete();
//		testFindByPk();
//		testFindByLoginId();
//		testFindByAuthenticate ();
		testSearch();
		
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

	public static void testFindByPk( ) throws SQLException {
		
		UserBean bean = new UserBean ();
		UserModel model = new UserModel ();
		
		
		bean = model.findByPk(5);
		
		if (bean != null ) {
			System.out.println(bean.getId()); 
			System.out.println(bean.getFirst_name());
			System.out.println(bean.getLast_name());
			System.out.println(bean.getLoginId());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
		}else {
			throw new RuntimeException ("Record Not found ");
		}
	}	
	public static void testFindByLoginId () throws SQLException{
		
		UserBean bean = new UserBean ();
		UserModel model = new UserModel ();
		
		bean = model.findByLoginId("atul@gmail.com");
		

		if (bean != null ) {
			System.out.println(bean.getId()); 
			System.out.println(bean.getFirst_name());
			System.out.println(bean.getLast_name());
			System.out.println(bean.getLoginId());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
		}else {
			throw new RuntimeException ("Record Not found ");
		
	}
}
	public static void testFindByAuthenticate () throws SQLException {
		
		UserBean bean = new UserBean ();
	    UserModel model = new UserModel ();
	    
	    bean = model.FindByAuthenticate("atul@gmail.com", "atul");
	    
	    if (bean != null ) {
			System.out.println(bean.getId()); 
			System.out.println(bean.getFirst_name());
			System.out.println(bean.getLast_name());
			System.out.println(bean.getLoginId());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
		}else {
			throw new RuntimeException ("Record Not found ");
	    
	}
	
	}
	public static void testSearch() throws SQLException {

		UserBean bean = new UserBean();
		UserModel model = new UserModel ();
		
	//	bean.setFirstName("v");
		List<UserBean> list = model.search(bean, 1, 2);

		Iterator<UserBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirst_name());
			System.out.print("\t" + bean.getLast_name());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.println("\t" + bean.getDob());
		}
	}
}
	
	
	

