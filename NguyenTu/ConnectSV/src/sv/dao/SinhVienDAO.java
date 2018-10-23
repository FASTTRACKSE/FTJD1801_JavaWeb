package sv.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import sv.entity.*;
import sv.utils.ConnectionFactory;

public class SinhVienDAO {
	private Connection connection;

	private java.sql.Statement statement;
	private java.sql.PreparedStatement preparedStatement;

	public SinhVienDAO() {
		super();
	}

	public List<SinhVien> getAllSinhVien() {
		String query = "SELECT * FROM sinhvienmana.sinhvien ";

		List<SinhVien> list = new ArrayList<SinhVien>();
		SinhVien sinhVien = null;

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				sinhVien = new SinhVien(rs.getInt("id"), rs.getString("hoten"), rs.getString("date"), rs.getString("image"));
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

	public ArrayList<SinhVien> getSearchSinhVien(int start, int total, String name) {
		String query = "SELECT * FROM sinhvien where hoten like \'%" + name + "%\' limit " + start + "," + total + "";

		ArrayList<SinhVien> list_sv = new ArrayList<SinhVien>();
		SinhVien sinhVien = null;

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {

				sinhVien = new SinhVien(rs.getInt("id"), rs.getString("hoten"), rs.getString("date"),rs.getString("image"));
				list_sv.add(sinhVien);
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
		return list_sv;
	}

	public int selectCount(String name) {
		int count = 0;
		String query = "SELECT * FROM sinhvien where hoten like \'%" + name + "%\'";

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				count++;
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
		return count;
	}

	public void addNewSinhVien(SinhVien sv) {
		String query = "INSERT INTO sinhvien(id,hoten,date,image) VALUES(?,?,?,?)";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			preparedStatement.setInt(1, sv.getiD());
			preparedStatement.setString(2, sv.getHoTen());
			preparedStatement.setString(3, sv.getDate());
			preparedStatement.setString(4, sv.getImage());
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

	public SinhVien selectSinhVien(String id) {

		SinhVien sinhVien = null;

		try {
			String query = "SELECT * FROM sinhvien where id=?";
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				sinhVien = new SinhVien(rs.getInt("id"), rs.getString("hoten"), rs.getString("date"),rs.getString("image"));
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
		return sinhVien;
	}

	public void updateSinhVien(SinhVien sv) {
		String query = "UPDATE sinhvien SET hoten = ?, date = ?, image = ? WHERE id = ? ";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, sv.getHoTen());
			preparedStatement.setString(2, sv.getDate());
			preparedStatement.setString(3, sv.getImage());
			preparedStatement.setInt(4, sv.getiD());
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

	public void removeSinhVien(SinhVien sv) {
		String query = "DELETE FROM sinhvien WHERE id = ?";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, sv.getiD());
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
