package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import entity.Emp;

public class EmpDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(Emp p) {
		String sql = "insert into Emp99(name,tuoi,email,gioiTinh,diaChi,lopHoc,anhThe) " + "values('" + p.getName()
				+ "','" + p.getTuoi() + "','" + p.getEmail() + "','" + p.getGioiTinh() + "','" + p.getDiaChi() + "','"
				+ p.getLopHoc() + "','" + p.getAnhThe() + "')";
		return template.update(sql);
	}

	public int update(Emp p) {
		String sql = "update Emp99 set name='" + p.getName() + "', tuoi=" + p.getTuoi() + ", email='" + p.getEmail()
				+ "'," + "gioiTinh='" + p.getGioiTinh() + "', diaChi='" + p.getDiaChi() + "', lopHoc='" + p.getLopHoc()
				+ "', anhThe='" + p.getAnhThe() + "' where id=" + p.getId() + "";
		return template.update(sql);
	}

	public int delete(int id) {
		String sql = "delete from Emp99 where id=" + id + "";
		return template.update(sql);
	}

	public Emp getEmpById(int id) {
		String sql = "select * from Emp99 where id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Emp>(Emp.class));
	}

	public List<Emp> getEmployees() {
		return template.query("select * from Emp99", new RowMapper<Emp>() {
			public Emp mapRow(ResultSet rs, int row) throws SQLException {
				Emp e = new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setTuoi(rs.getInt(3));
				e.setEmail(rs.getString(4));
				e.setGioiTinh(rs.getString(5));
				e.setDiaChi(rs.getString(6));
				e.setLopHoc(rs.getString(7));
				e.setAnhThe(rs.getString(8));
				return e;
			}
		});
	}

	public List<Emp> getEmployeesByPage(String name, int pageid, int total) {
		return template.query("Select * from emp99 where name like '%" + name + "%' limit " + pageid + "," + total + "", new RowMapper<Emp>() {
			
			public Emp mapRow(ResultSet rs, int row) throws SQLException {
				Emp e = new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setTuoi(rs.getInt(3));
				e.setEmail(rs.getString(4));
				e.setGioiTinh(rs.getString(5));
				e.setDiaChi(rs.getString(6));
				e.setLopHoc(rs.getString(7));
				e.setAnhThe(rs.getString(8));
				return e;
			}
		});

	}

	public int countSinhVien() {
		int result = template.queryForObject("SELECT COUNT(*) FROM EMP99", Integer.class);
		return result;

	}
	
	public List<Emp> findTeamByName(String pSearchTerm) {

		return template.query("SELECT * FROM emp99 WHERE name LIKE '%" + pSearchTerm + "%'", new RowMapper<Emp>() {
			public Emp mapRow(ResultSet rs, int row) throws SQLException {
				Emp e = new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setTuoi(rs.getInt(3));
				e.setEmail(rs.getString(4));
				e.setGioiTinh(rs.getString(5));
				e.setDiaChi(rs.getString(6));
				e.setLopHoc(rs.getString(7));
				e.setAnhThe(rs.getString(8));
				return e;
			}
		});
	}

	
}