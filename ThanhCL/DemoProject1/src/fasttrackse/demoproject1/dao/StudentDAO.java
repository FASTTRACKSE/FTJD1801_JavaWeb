package fasttrackse.demoproject1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fasttrackse.demoproject1.entity.SinhVien;
import fasttrackse.demoproject1.utils.ConnectionFactory;

/**
 * DAO for the Student entity.
 * 
 *
 */
public class StudentDAO {
	private Connection connection;

	private Statement statement;
	private PreparedStatement preparedStatement;

	public StudentDAO() {
		super();
	}

	public List<SinhVien> getAllSinhVien() {
		String query = "SELECT * FROM SinhVien";

		List<SinhVien> list = new ArrayList<SinhVien>();
		SinhVien sinhVien = null;

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				sinhVien = new SinhVien(rs.getInt("id"), rs.getString("hoten"), rs.getInt("namsinh"));
				list.add(sinhVien);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public void addNewSinhVien(SinhVien sv) {
		String query = "INSERT INTO sinhVien(hoten, namsinh) VALUES(?, ?)";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, sv.getHoTen());
			preparedStatement.setInt(2, sv.getNamSinh());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}