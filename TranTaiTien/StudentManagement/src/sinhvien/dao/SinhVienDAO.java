package sinhvien.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sinhvien.entity.SinhVien;
import sinhvien.utils.ConnectionFactory;

public class SinhVienDAO {
	private Connection connection;

	private Statement statement;
	private PreparedStatement preparedStatement;

	public SinhVienDAO() {
		super();
	}

	public ArrayList<SinhVien> getAllSinhVien(int start, int total) {
		String query = "SELECT * FROM sinhvien limit "+start+","+total+"";

		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
		SinhVien sinhVien = null;

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				int tuoi = 2018 - rs.getInt("NamSinh");
				sinhVien = new SinhVien(rs.getInt("MaSV"), rs.getString("TenSV"),tuoi, rs.getString("Avatar"));
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
		String query = "SELECT * FROM sinhvien where TenSV like \'%"+name+"%\' limit "+start+","+total+"";

		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
		SinhVien sinhVien = null;

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				int tuoi = 2018 - rs.getInt("NamSinh");
				sinhVien = new SinhVien(rs.getInt("MaSV"), rs.getString("TenSV"),tuoi, rs.getString("Avatar"));
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
	
	public int selectCount(String name) {
		int count = 0;
		String query = "SELECT * FROM sinhvien where TenSV like \'%"+name+"%\'";

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
		String query = "INSERT INTO sinhvien(TenSV, NamSinh, Avatar) VALUES(?, ?, ?)";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, sv.getHoTen());
			preparedStatement.setInt(2, sv.getNamSinh());
			preparedStatement.setString(3, sv.getAvatar());
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
		String query = "DELETE FROM sinhvien WHERE MaSV = ?";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, sv.getMaSV());
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
		String query = "SELECT * FROM sinhvien WHERE MaSV = ?";

		SinhVien sinhVien = null;

		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				sinhVien = new SinhVien(rs.getInt("MaSV"), rs.getString("TenSV"), rs.getInt("NamSinh"), rs.getString("Avatar"));
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
		String query = "UPDATE sinhvien SET TenSV = ?, NamSinh = ?, Avatar = ? WHERE MaSV = ? ";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, sv.getHoTen());
			preparedStatement.setInt(2, sv.getNamSinh());
			preparedStatement.setString(3, sv.getAvatar());
			preparedStatement.setInt(4, sv.getMaSV());
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