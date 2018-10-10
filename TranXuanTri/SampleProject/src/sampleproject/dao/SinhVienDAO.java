package sampleproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sampleproject.entity.SinhVien;
import sampleproject.utils.ConnectionFactory;

public class SinhVienDAO {

	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;

	public SinhVienDAO() {
		super();
	}

	public List<SinhVien> getAllSinhVien(int start, int total) {
		String query = "SELECT * FROM SinhVien limit " + start + "," + total + "";

		List<SinhVien> list = new ArrayList<SinhVien>();
		SinhVien sinhVien = null;

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				sinhVien = new SinhVien(rs.getInt("id"), rs.getString("hoten"), rs.getInt("namsinh"), rs.getString("anh"));
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

	public int getNumberOfRows() {
		int numOfRows = 0;
		try {
			String query = "SELECT COUNT(*) FROM sinhvien";

			connection = ConnectionFactory.getInstance().getConnection();
			statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				return numOfRows = rs.getInt(1);
			}
		} catch (SQLException | ClassNotFoundException ex) {

		}
		return numOfRows;
	}

	public void addNewSinhVien(SinhVien sv) {
		String query = "INSERT INTO sinhVien(id,hoten, namsinh,anh) VALUES(?,?,?,?)";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, sv.getId());
			preparedStatement.setString(2, sv.getHoTen());
			preparedStatement.setInt(3, sv.getNamSinh());
			preparedStatement.setString(4, sv.getFileName());
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

	public void updateSinhVien(SinhVien sv) {
		String query = "UPDATE sinhvien set hoTen=?, namSinh=?, anh=? where id=?";
		try {
			if (sv.getFileName().equals("")) {
				query = "UPDATE sinhvien set hoTen=?, namSinh=? where id=?";
				connection = ConnectionFactory.getInstance().getConnection();
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, sv.getHoTen());
				preparedStatement.setInt(2, sv.getNamSinh());
				preparedStatement.setInt(3, sv.getId());
				preparedStatement.executeUpdate();
			} else {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, sv.getHoTen());
			preparedStatement.setInt(2, sv.getNamSinh());
			preparedStatement.setString(3, sv.getFileName());
			preparedStatement.setInt(4, sv.getId());
			preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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

	public void deleteSinhVien(int id) {
		String query = "delete from sinhvien where id=?";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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

	public List<SinhVien> searchSinhVien(String name, int start, int total) {
		String query = "Select * from sinhvien where hoTen like \"%" + name + "%\" limit " + start + "," + total + " ";
		List<SinhVien> list = new ArrayList<SinhVien>();
		SinhVien sinhVien = null;
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			statement = connection.createStatement();
			
			ResultSet rs = statement.executeQuery(query);
			
			while (rs.next()) {
				sinhVien = new SinhVien(rs.getInt("id"), rs.getString("hoten"), rs.getInt("namsinh"),rs.getString("anh"));
				list.add(sinhVien);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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
	public int getNumberOfRowsSearch(String name) {
		int numOfRows = 0;
		try {
			String query = "SELECT COUNT(*) FROM sinhvien where hoTen like \"%" + name + "%\"  ";

			connection = ConnectionFactory.getInstance().getConnection();
			statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				return numOfRows = rs.getInt(1);
			}
		} catch (SQLException | ClassNotFoundException ex) {

		}
		return numOfRows;
	}
}
