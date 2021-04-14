package com.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnectionMgr {

	private final static String _DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final static String _URL = "jdbc:oracle:thin:@localhost:15210:orcl11";
	private final static String _USER = "nsone";
	private final static String _PW = "tiger";
	private static DBConnectionMgr dbMgr = null;

	private DBConnectionMgr() {
		// Lazy Initialization - 선언과 생성이 따로 쓰일 때
	}

	Connection con = null;

	public static DBConnectionMgr getInstance() {
		if (dbMgr == null) {
			dbMgr = new DBConnectionMgr();
		}
		return dbMgr;
	}

	public Connection getConnection() {
		try {
			Class.forName(_DRIVER);
			con = DriverManager.getConnection(_URL, _USER, _PW);
//			con.setAutoCommit(false);
//			con.setAutoCommit(true);
//			con.commit();
//			con.rollback();

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return con;
	}

	// SELECT 반납
	public void freeConnection(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// INSERT, UPDATE, DELETE 반납
	public void freeConnection(Connection con, PreparedStatement pstmt) {
		try {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// PROCEDURE 반납
	public void freeConnection(Connection con, CallableStatement cstmt) {
		try {
			if (cstmt != null)
				cstmt.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void freeConnection(Connection con, CallableStatement cstmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (cstmt != null)
				cstmt.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
