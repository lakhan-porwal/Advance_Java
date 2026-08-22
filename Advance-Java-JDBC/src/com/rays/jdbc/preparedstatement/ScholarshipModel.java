package com.rays.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import in.co.rays.util.JDBCDataSource;

public class ScholarshipModel {
	
	public void Update(ScholarshipBean bean ) throws SQLException {
		
		Connection conn = null;
	
		
		try {
			 
			conn = JDBCDataSource.getConnection();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			conn.setAutoCommit(false);
			
			PreparedStatement pstmt = conn.prepareStatement("insert into scholarship values (?, ?, ?, ?, ?)");
			
			pstmt.setInt(1, bean.getScholarshipId());
			pstmt.setString(2, bean.getScholarshipName());
			pstmt.setInt(3, bean.getAmount());
			pstmt.setString(4, bean.getEligibility());
			pstmt.setDate(5,new java.sql.Date(bean.getLastdate().getTime()));
			
			int i = pstmt.executeUpdate();
			conn.commit();
			
			System.out.println("Record inserted successfully");
			
		} catch (Exception e) { 
			System.out.println(e.getMessage());
			conn.rollback();

		}
		finally {
			conn.close();
		}
		
		
	}

}
