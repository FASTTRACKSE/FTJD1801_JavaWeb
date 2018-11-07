package quanlysinhvien.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import quanlysinhvien.entity.SinhVien;

public class SinhVienDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(SinhVien sv) {
		String sql = "insert into sinhvien(hoTen,namSinh,email,gioiTinh,diaChi,lopHoc,anhThe) " + "values('"
				+ sv.getHoTen() + "'," + sv.getNamSinh() + ",'" + sv.getEmail() + "','" + sv.getGioiTinh() + "','"
				+ sv.getDiaChi() + "','" + sv.getLopHoc() + "','" + sv.getAnhThe() + "')";
		return template.update(sql);
	}

	public int update(SinhVien sv) {
		String sql = "update sinhvien set hoTen ='" + sv.getHoTen() + "',namSinh = " + sv.getNamSinh() + ",email = '"
				+ sv.getEmail() + "',gioiTinh = '" + sv.getGioiTinh() + "',diaChi = '" + sv.getDiaChi() + "',lopHoc = '"
				+ sv.getLopHoc() + "', anhThe='" + sv.getAnhThe() + "' where id =" + sv.getId() + "";
		return template.update(sql);
	}

	public int delete(int id) {
		String sql = "delete from sinhvien where id =" + id + "";
		return template.update(sql);
	}

	public SinhVien getEmpById(int id) {
		String sql = "select * from sinhvien where id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<SinhVien>(SinhVien.class));
	}

	public List<SinhVien> getDsSinhVien(int pageId, int total) {
		return template.query("select * from sinhvien limit " + (pageId - 1) + ", " + total + "",
				new RowMapper<SinhVien>() {
					public SinhVien mapRow(ResultSet rs, int row) throws SQLException {
						SinhVien sv = new SinhVien();
						sv.setId(rs.getInt(1));
						sv.setHoTen(rs.getString(2));
						sv.setNamSinh(rs.getInt(3));
						sv.setEmail(rs.getString(4));
						sv.setGioiTinh(rs.getString(5));
						sv.setDiaChi(rs.getString(6));
						sv.setLopHoc(rs.getString(7));
						sv.setAnhThe(rs.getString(8));
						return sv;
					}
				});
	}
}
