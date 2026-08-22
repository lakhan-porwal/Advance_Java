package com.rays.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class UserModel {
		
		public void add(UserBean bean) throws SQLException {
          
			Connection conn = null;
			
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				
			    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
				
				conn.setAutoCommit(false);
				
				PreparedStatement pstmt = conn.prepareStatement("insert into st_user values (?, ?, ?, ?, ?, ?)");
				
				pstmt.setInt(1, bean.getId());
				pstmt.setString(2, bean.getFirst_name());
				pstmt.setString(3, bean.getLast_name());
				pstmt.setString(4, bean.getLoginId());
				pstmt.setString(5, bean.getPassword());
				pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
				
				int i = pstmt.executeUpdate();
				
				conn.commit();
				
				System.out.println("Record Inserted Seccessfully :- " + i);
				
				
			} catch (Exception e) {
                    e.printStackTrace();
                    conn.rollback();
			}
			finally {
				conn.close();
			}
		}
	


        public void update (UserBean bean) throws Throwable {
        	
        	Connection conn = null;
        	
        	try {
        		
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
				
				conn.setAutoCommit(false);
				
				PreparedStatement pstmt = conn.prepareStatement("update st_user set first_name = ?, last_name = ?, loginId = ?, password = ?, dob = ? where id = ?");
				
				pstmt.setString(1,bean.getFirst_name() );
				pstmt.setString(2, bean.getLast_name());
				pstmt.setString(3, bean.getLoginId());
				pstmt.setString(4, bean.getPassword());
				pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
				pstmt.setInt(6, bean.getId());
				
				int i = pstmt.executeUpdate();
				
				conn.commit();
				
				System.out.println("Record update successfully :-" + i);
				
				
			} catch (Exception e) {
				e.printStackTrace();
				conn.rollback();
			}
        	finally {
				conn.close();
				
			}
        }
        
        public void delete (int id ) throws SQLException {
        	Connection conn = null ;
        	
        	try {
        		
        		Class.forName("com.mysql.cj.jdbc.Driver");
        		
        		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
        		
        		conn.setAutoCommit(false);
        		
        		PreparedStatement pstmt = conn.prepareStatement("delete from st_user where id = ?");
				
        		pstmt.setInt(1, id);
        		
        		int i = pstmt.executeUpdate();
        		
        		conn.commit();
        		
        		System.out.println("Record deleted Successfully :- " + i);
        		
			} catch (Exception e) {
				
              e.printStackTrace();
              conn.rollback();
              
			}
        	finally {
				conn.close();
				
			}
        }
        

}
