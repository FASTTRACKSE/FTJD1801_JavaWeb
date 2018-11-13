package springmvc.student.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import springmvc.student.entity.Student;

public class StudentDAO {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int addStudent(Student st) {
		String sql = "insert into sinhvien(TenSV,NamSinh,Avatar) values('" + st.getTenSV() + "'," + st.getNamSinh() + ",'"
				+ st.getAvatar() + "')";
		return template.update(sql);
	}

	public int updateStudent(Student st) {
		String sql = "update sinhvien set TenSV='" + st.getTenSV() + "', NamSinh=" + st.getNamSinh() + ",  Avatar='"
				+ st.getAvatar() + "' where MaSV=" + st.getMaSV() + "";
		return template.update(sql);
	}

	public int deleteStudent(int id) {
		String sql = "delete from sinhvien where MaSV=" + id + "";
		return template.update(sql);
	}

	public Student getStudentById(int id) {
		String sql = "select * from sinhvien where MaSV=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Student>(Student.class));
	}

	public List<Student> getAllStudent() {
		return template.query("select * from sinhvien", new RowMapper<Student>() {
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
	
	public List<Student> getSearchLimitStudent(int start, int total, String name) {
		return template.query("SELECT * FROM sinhvien where TenSV like \'%"+name+"%\' limit "+start+","+total+"", new RowMapper<Student>() {
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
		return template.query("SELECT * FROM sinhvien where TenSV like \'%"+name+"%\'", new RowMapper<Student>() {
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
