package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentClassDAO {
	private static final String DB_URL = "jdbc:sqlserver://localhost:1433;" + "databaseName=STUDENTMANAGER;";
	private static final String USER_NAME = "sa";
	private static final String PASSWORD = "ThaoPV5123456789";

	static Connection conn;

	public static Connection getConnection(String dbURL, String userName, String password) {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(dbURL, userName, password);
			 System.out.println("connect successfully!");
		} catch (Exception ex) {
			System.out.println("connect failure!");
			ex.printStackTrace();
		}
		return conn;
	}
//	public boolean ckeckID(int id) {
//		conn= getConnection(DB_URL, USER_NAME, PASSWORD);
//		String sql = "select id from STUDENT WHERE id= ?";
//		Statement stmt;
//		try {
//			stmt= conn.createStatement();
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return false;
//	}

}
