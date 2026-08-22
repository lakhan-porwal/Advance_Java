package com.rays.jdbc.preparedstatement;

import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.co.rays.util.JDBCDataSource;

public class Insurance {
	
	public static void main(String[] args) throws SQLException {
		
	Connection conn = JDBCDataSource.getConnection();
	
	PreparedStatement pstmt = conn.prepareStatement("create table insurance (policyId int primary key , policyHolderName varchar(50), policyType varchar(50), premiumAmount varchar(50), expiryDate date)");
		
	System.out.println("table create successfully..");
	}

}
