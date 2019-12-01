package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.bean.DayOff;
import model.bean.Student;

public class StudentDAO {
	private static final String DB_URL = "jdbc:sqlserver://localhost:1433;" + "databaseName=STUDENTMANAGER;";
	private static final String USER_NAME = "sa";
	private static final String PASSWORD = "ThaoPV5123456789";

	static Connection conn;

	public static Connection getConnection(String dbURL, String userName, String password) {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(dbURL, userName, password);
//			 System.out.println("connect successfully!");
		} catch (Exception ex) {
			System.out.println("connect failure!");
			ex.printStackTrace();
		}
		return conn;
	}

	public void insertStudent(Student student) {
		conn = getConnection(DB_URL, USER_NAME, PASSWORD);
		String sql = "select * from STUDENT";
		Statement stmt;
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(sql);
			rs.moveToInsertRow();
			rs.updateString("name", student.getName());
			rs.updateInt("age", student.getAge());
			rs.insertRow();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void studentDayOff(DayOff dayOff) {
		conn = getConnection(DB_URL, USER_NAME, PASSWORD);
		String sql = "select * from DayOff";
		Statement stmt;
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(sql);
			rs.moveToInsertRow();
			rs.updateInt("StudentID", dayOff.getIdStudent());
			SimpleDateFormat parseday = new SimpleDateFormat("dd-MM-yyyy");
			Date day;
			try {
				day = parseday.parse(dayOff.getDayOff());	
				rs.updateDate("dayOff", new java.sql.Date(day.getTime()));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			rs.insertRow();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
