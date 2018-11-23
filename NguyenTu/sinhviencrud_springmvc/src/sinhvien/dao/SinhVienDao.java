package sinhvien.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import sinhvien.beans.*;

import sinhvien.beans.SinhVien;

public class SinhVienDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int add(SinhVien p) {
		String sql = "insert into sinhvien(hoTen,namSinh,email,diaChi,lop,image)  values('" + p.getTenSv() + "',"
				+ p.getNamSinh() + ",'" + p.getEmail() + "','" + p.getDiaChi() + "','" + p.getLop() + "','"
				+ p.getImage() + "')";
		return template.update(sql);
	}

	public int update(SinhVien p) {
		String sql = "update sinhvien set  hoTen='" + p.getTenSv() + "',  namSinh=" + p.getNamSinh() + ",email='"
				+ p.getEmail() + "',diaChi='" + p.getDiaChi() + "',lop='" + p.getLop() + "',image='" + p.getImage()
				+ "' where id=" + p.getId() + "";
		return template.update(sql);
	}

	public int delete(int id) {
		String sql = "delete from sinhvien where id=" + id + "";
		return template.update(sql);
	}

	public SinhVien getSinhVienById(int id) {
		String sql = "select * from sinhvien where id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<SinhVien>(SinhVien.class));
	}

	public List<SinhVien> getEmployees() {
		return template.query("select * from sinhvien", new RowMapper<SinhVien>() {
			public SinhVien mapRow(ResultSet rs, int row) throws SQLException {
				SinhVien e = new SinhVien();
				e.setId(rs.getInt(1));

				e.setTenSv(rs.getString(2));
				e.setNamSinh(rs.getInt(3));
				e.setEmail(rs.getString(4));

				e.setDiaChi(rs.getString(5));
				e.setLop(rs.getString(6));
				e.setImage(rs.getString(7));
				return e;
			}
		});
	}

	public List<SinhVien> getSearchLimitSinhVien(int start, int total, String name) {
		return template.query(
				"SELECT * FROM sinhvien where hoTen like \'%" + name + "%\' limit " + start + "," + total + "",
				new RowMapper<SinhVien>() {
					public SinhVien mapRow(ResultSet rs, int row) throws SQLException {
						
						SinhVien e = new SinhVien();
						e.setId(rs.getInt(1));

						e.setTenSv(rs.getString(2));
						e.setNamSinh(rs.getInt(3));
						e.setEmail(rs.getString(4));

						e.setDiaChi(rs.getString(5));
						e.setLop(rs.getString(6));
						e.setImage(rs.getString(7));
						return e;
					}
				});
	}

	public List<SinhVien> countSinhVien(String name) {
		return template.query("SELECT * FROM sinhvien where hoTen like \'%" + name + "%\'", new RowMapper<SinhVien>() {
			public SinhVien mapRow(ResultSet rs, int row) throws SQLException {
				SinhVien e = new SinhVien();
				e.setId(rs.getInt(1));

				e.setTenSv(rs.getString(2));
				e.setNamSinh(rs.getInt(3));
				e.setEmail(rs.getString(4));

				e.setDiaChi(rs.getString(5));
				e.setLop(rs.getString(6));
				e.setImage(rs.getString(7));
				return e;
			}
		});
	}

}
