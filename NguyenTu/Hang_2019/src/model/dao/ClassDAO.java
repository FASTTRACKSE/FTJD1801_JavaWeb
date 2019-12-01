package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Class1;

public class ClassDAO {
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

	public void insetClass(Class1 clas) {
		conn = getConnection(DB_URL, USER_NAME, PASSWORD);
		String sql = "select * from CLASS";
		Statement stmt;
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(sql);
			rs.moveToInsertRow();
			rs.updateString("ClassName", clas.getClassName());
			rs.insertRow();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	public ArrayList<Class1> getAllClass() {
		conn = getConnection(DB_URL, USER_NAME, PASSWORD);
		String sql = "select * from CLASS";
		Statement stmt;
		ArrayList<Class1> listClass= new ArrayList<Class1>();
		try {
			Class1 clas ;
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				clas = new Class1();
				clas.setId(rs.getInt("id"));
				clas.setClassName(rs.getString("ClassName"));
				listClass.add(clas);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listClass;
		
	}
}
