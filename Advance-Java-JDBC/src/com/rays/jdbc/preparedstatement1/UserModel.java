package com.rays.jdbc.preparedstatement1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.util.JDBCDataSource;

public class UserModel {
		
		public void add(UserBean bean) throws SQLException {
          
			Connection conn = null;
			
			try {
				conn = JDBCDataSource.getConnection();
				
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
        	
        	public UserBean findByPk(int id ) throws SQLException {
        		
        		Connection conn = null;
        		UserBean bean = null;
        		
        		try {
					
        			conn = JDBCDataSource.getConnection();
        			
        			PreparedStatement pstmt = conn.prepareStatement("select * from st_user where id = ? ");
        			
        			pstmt.setInt(1, id);
        			
        			ResultSet rs =  pstmt.executeQuery();
        			
        			while (rs.next()) {
        				bean = new UserBean ();
        				bean.setId(rs.getInt("id"));
        				bean.setFirst_name(rs.getString("first_name"));
        				bean.setLast_name(rs.getString("last_name"));
        				bean.setLoginId(rs.getString("loginId"));
        				bean.setPassword(rs.getString("password"));
        				bean.setDob(rs.getDate("dob"));
        				
        			}
        			
				} catch (Exception e) {
					e.getMessage();
					
				}
        		finally {
					conn.close();
				}
        	return bean;	
        	
        }
        	
        	public UserBean findByLoginId (String loginId) throws SQLException{
        		
        		Connection conn = null;
        		UserBean bean = null; 
        		
        		try {
					
        			conn = JDBCDataSource.getConnection();
        			
        			PreparedStatement pstmt = conn.prepareStatement("select * from st_user where loginId = ?");
        			
        			pstmt.setString(1, loginId);
        			
        			ResultSet rs = pstmt.executeQuery();
        			
        			while (rs.next()) {
        				bean = new UserBean();
        				
        		       bean.setId(rs.getInt("id"));
        		       bean.setFirst_name(rs.getString("First_name"));
        		       bean.setLast_name(rs.getString("last_name"));
        		       bean.setLoginId(rs.getString("loginId"));
        		       bean.setPassword(rs.getString("password"));
        		       bean.setDob(rs.getDate("dob"));
        				
        			}
        			
        			
				} catch (Exception e) {
					e.printStackTrace();
				}
        		finally {
					conn.close();
				}
        		return bean;
        		
        	}
        	// Authentcate loginId && Password
        	
        	public UserBean FindByAuthenticate (String loginId, String password) throws SQLException {
        		
        		Connection conn = null;
        		UserBean bean = null;
        		
        		try {
        		    
        			conn = JDBCDataSource.getConnection();
        			
        			PreparedStatement pstmt = conn.prepareStatement("select * from st_user where loginId = ? and password = ?");
        			
        			pstmt.setString(1, loginId);
        			pstmt.setString(2, password);
        			
        			ResultSet rs = pstmt.executeQuery();
        			
        			while (rs.next()) {
        				
        			 bean = new UserBean ();
        			 
        			 bean.setId(rs.getInt("id"));
        			 bean.setFirst_name(rs.getString("first_name"));
        			 bean.setLast_name(rs.getString("last_name"));
        			 bean.setLoginId(rs.getString("loginId"));
        			 bean.setPassword(rs.getString("password"));
        			 bean.setDob(rs.getDate("dob"));
        				
        			}
        		
        		} catch (Exception e) {
        			e.printStackTrace();
        			
				}finally {
					conn.close();
				}
        		return bean;
   }	
        	
        	public UserBean authenticate(String loginId ,String password) throws SQLException {
        		
        		UserBean bean = findByLoginId(loginId);
        		if ( bean != null && bean.getPassword().equals(password)) {
        			return bean ;
        		}
        		return null;		
        	}
        	
        	public List <UserBean> search (UserBean bean , int pageNo, int pageSize) throws SQLException {
        		
        		Connection conn = null;
        		List <UserBean> list = new ArrayList<UserBean>();
        		StringBuffer sql = new StringBuffer("select * from st_user where 1=1 ");
        		
        		if (bean != null) {
        			
        			if (bean.getFirst_name() != null &&  bean.getFirst_name().length() > 0) {
        				sql.append("and First_name like ' " + bean.getFirst_name() + "%'");
        			}	
        			if (bean.getLast_name() != null &&  bean.getLast_name().length() > 0) {
        				sql.append("and Last_name like ' " + bean.getLast_name() + "%'");
        			}	
        			if (bean.getLoginId() != null &&  bean.getLoginId().length() > 0) {
        				sql.append("and LoginId( like ' " + bean.getLoginId() + "%'");
        			}	
        			if (bean.getPassword() != null &&  bean.getPassword().length() > 0) {
        				sql.append("and Password like ' " + bean.getPassword() + "%'");
        			}	
        			if (bean.getDob() != null &&  bean.getDob().getTime() > 0) {
        				sql.append("and Dob like ' " + bean.getDob() + "%'");
        			}
        			
        			if (pageSize > 0) {
        				int index = (pageNo -1) * pageSize;
        				sql.append(" limit " + index + "," + pageSize);
        				
        			}

        			conn = JDBCDataSource.getConnection();
        			
        			System.out.println("sql search query =====>" + sql.toString());
        			
        			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
        			
        			ResultSet rs = pstmt.executeQuery();
        			
        			while(rs.next()) {
        				bean = new UserBean();
        				bean.setId(rs.getInt("id"));
        				bean.setFirst_name(rs.getString("first_name"));
        				bean.setLast_name(rs.getString("last_name"));
        				bean.setLoginId(rs.getString("loginId"));
        				bean.setPassword(rs.getString("password"));
        				bean.setDob(rs.getDate("dob"));
        				list.add(bean);
        				
        			}
                 try {
                	 
					
				} catch (Exception e) {
					e.printStackTrace();
					
				}
                 finally {
					conn.close();
				}
                 
        		}
        		return list;

        		 
        	}
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
}
