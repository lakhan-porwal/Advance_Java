 package com.rays.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.co.rays.util.JDBCDataSource;

public class MarksheetModel {

	public void add(MarksheetBean bean) throws SQLException {
		System.out.println("in add method");
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();

			System.out.println("database: " + conn.getCatalog());

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values (?, ?, ?, ?, ?, ?, ?, ?)");

			pstmt.setInt(1, bean.getId());
			pstmt.setInt(2, bean.getRollNo());
			pstmt.setString(3, bean.getName());
			pstmt.setInt(4, bean.getEnglish());
			pstmt.setInt(5, bean.getHindi());
			pstmt.setInt(6, bean.getPhysics());
			pstmt.setInt(7, bean.getChemistry());
			pstmt.setInt(8, bean.getMaths());

			int i = pstmt.executeUpdate();
			System.out.println("commit method");
			conn.commit();

			System.out.println("Record inserted Successfully " + i);

		} catch (Exception e) {
			e.getStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

}
