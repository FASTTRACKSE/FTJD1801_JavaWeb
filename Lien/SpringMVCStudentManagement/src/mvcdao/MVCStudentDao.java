package mvcdao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import mvcentity.Student;

public class MVCStudentDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(Student p) {
		String sql = "insert into sinhvien(tenSV,namSinh,avatar)" + "values('" + p.getTenSV() + "'," + p.getNamSinh()
				+ ",'" + p.getAvatar() + "')";
		return template.update(sql);
	}

	public int update(Student p) {
		String sql = "update mvcstudent set tenSV='" + p.getTenSV() + "', namSinh=" + p.getNamSinh()
				+ ",         avatar='" + p.getAvatar() + "' where maSV=" + p.getMaSV() + "";
		return template.update(sql);
	}

	public int delete(int maSV) {
		String sql = "delete from sinhvien where maSV=" + maSV + "";
		return template.update(sql);
	}

	public Student getEmpById(int id) {
		String sql = "select * from sinhvien where maSV=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Student>(Student.class));
	}

	public List<Student> getEmployees() {
		return template.query("select * from sinhvien", new RowMapper<Student>() {
			public Student mapRow(ResultSet rs, int row) throws SQLException {
				Student student = new Student();
				student.setMaSV(rs.getInt(1));
				student.setTenSV(rs.getString(2));
				student.setNamSinh(rs.getInt(3));
				student.setAvatar(rs.getString(4));
				return student;
			}
		});

	}

	public List<Student> getSearchLimitStudent(int start, int total, String name) {
		return template.query(
				"SELECT * FROM sinhvien where tenSV like \'%" + name + "%\' limit " + start + "," + total + "",
				new RowMapper<Student>() {
					public Student mapRow(ResultSet rs, int row) throws SQLException {
						Student e = new Student();
						e.setMaSV(rs.getInt(1));
						e.setTenSV(rs.getString(2));
						e.setNamSinh(rs.getInt(3));
						e.setAvatar(rs.getString(4));
						return e;
					}
				});
	}

	public List<Student> countStudent(String name) {
		return template.query("SELECT * FROM sinhvien where tenSV like \'%" + name + "%\'", new RowMapper<Student>() {
			public Student mapRow(ResultSet rs, int row) throws SQLException {
				Student e = new Student();
				e.setMaSV(rs.getInt(1));
				e.setTenSV(rs.getString(2));
				e.setNamSinh(rs.getInt(3));
				e.setAvatar(rs.getString(4));
				return e;
			}
		});
	}
}
