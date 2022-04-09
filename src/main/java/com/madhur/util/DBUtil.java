package com.madhur.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	private final String URL = "jdbc:mysql://localhost:3306/servletdatabase";
	private final String USERNAME = "root";
	private final String PASSWORD = "My$ql123";
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	Connection connection;

	public Connection getConnection() throws SQLException, ClassNotFoundException {
			Class.forName(DRIVER);
			System.out.println("Connecting to Database...");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connected Successfully");
			
			return connection;
	}
	
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) throws SQLException {
		System.out.println("Closing connection");
		if (conn != null)
			conn.close();

		if (pstmt != null)
			pstmt.close();

		if (rs != null)
			rs.close();
	}

	public void close(Connection conn, PreparedStatement pstmt) throws SQLException {
		System.out.println("Closing connection");
		if (conn != null)
			conn.close();

		if (pstmt != null)
			pstmt.close();

	}

	public void close(Connection conn) throws SQLException {
		System.out.println("Closing connection");
		if (conn != null)
			conn.close();
	}

	public void close(ResultSet rs) throws SQLException {
		System.out.println("Closing connection");

		if (rs != null)
			rs.close();
	}

	public void close(PreparedStatement pstmt) throws SQLException {
		System.out.println("Closing connection");
		if (pstmt != null)
			pstmt.close();

	}
}
