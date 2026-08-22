package com.rays.jdbc.preparedstatement;

import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import in.co.rays.util.JDBCDataSource;

public class InsuranceModel {
	
	public void add(InsuranceBean bean) throws Exception {
		
		Connection conn = null;
		
		try {
			conn = JDBCDataSource.getConnection();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			conn.setAutoCommit(false);
			
			PreparedStatement pstmt = conn.prepareStatement("insert into insurance (?, ?, ?, ?, ?)");
			
			pstmt.setInt(1, bean.getPolicyId());
			pstmt.setString(2, bean.getPolicyHolderName());
			pstmt.setString(3, bean.getPolicyType());
			pstmt.setString(4, bean.getPremiumAmount());
			pstmt.setDate(5, new java.sql.Date(bean.getExpiryDate().getTime()));
			
			int i = pstmt.executeUpdate();
			
			conn.commit();
			
			System.out.println("Record inserted successfully ");
			
			
		} catch (Exception e) {
		System.out.println("Exception :-" + e.getMessage());
		conn.rollback();
			
		}
		finally {
			conn.close();
		}
		
	}

}
