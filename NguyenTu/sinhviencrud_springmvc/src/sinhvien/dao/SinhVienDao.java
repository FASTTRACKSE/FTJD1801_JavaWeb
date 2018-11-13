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
	
	public int save(SinhVien p){  
	    String sql="insert into sinhvien(maSv,hoTen,namSinh,email,gioiTinh,diaChi,lop,image)  values("+p.getMaSv()+",'"+p.getTenSv()+"',"+p.getNamSinh()+",'"+p.getEmail()+"','"+p.getGioiTinh()+"','"+p.getDiaChi()+"','"+p.getLop()+"','"+p.getImage()+"')";  
	    return template.update(sql);  
	}  
	public int update(SinhVien p){  
	    String sql="update sinhvien set maSv='"+p.getMaSv()+"', hoTen="+p.getTenSv()+",  namSinh='"+p.getNamSinh()+"',email="+p.getEmail()+",gioiTinh="+p.getGioiTinh()+",diaChi="+p.getDiaChi()+",lop="+p.getLop()+",image="+p.getImage()+", where id="+p.getId()+"";  
	    return template.update(sql);  
	}  
	public int delete(int id){  
	    String sql="delete from sinhvien where id="+id+"";  
	    return template.update(sql);  
	}  
	
	public SinhVien getSinhVienById(int id){  
	    String sql="select * from sinhvien where id=?";  
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<SinhVien>(SinhVien.class));  
	}  

	
	public List<SinhVien> getEmployees(){  
	    return template.query("select * from sinhvien",new RowMapper<SinhVien>(){  
	        public SinhVien mapRow(ResultSet rs, int row) throws SQLException {  
	            SinhVien e=new SinhVien();  
	            e.setId(rs.getInt(1));  
	            e.setMaSv(rs.getInt(2));  
	            e.setTenSv(rs.getString(3));  
	            e.setNamSinh(rs.getInt(4));
	            e.setEmail(rs.getString(5));
	            e.setGioiTinh(rs.getString(6));
	            e.setDiaChi(rs.getString(7));
	            e.setLop(rs.getString(8));
	            e.setImage(rs.getString(9));
	            return e;  
	        }  
	    });  
	}  
}
