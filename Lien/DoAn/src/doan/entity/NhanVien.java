package doan.entity;
// Generated Jun 2, 2019 10:14:31 PM by Hibernate Tools 5.1.10.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Nhanvien generated by hbm2java
 */
@Entity
@Table(name = "nhanvien", catalog = "doan1")
public class NhanVien implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer maNhanVien;
	private String tenNhanVien;
	private String chucVu;
	private String soDienThoai;
	private String gioiTinh;
	private String users;
	private String matKhau;

	public NhanVien() {
	}

	public NhanVien(String tenNhanVien, String users, String matKhau) {
		this.tenNhanVien = tenNhanVien;
		this.users = users;
		this.matKhau = matKhau;
	}

	public NhanVien(String tenNhanVien, String chucVu, String soDienThoai, String gioiTinh, String users,
			String matKhau) {
		this.tenNhanVien = tenNhanVien;
		this.chucVu = chucVu;
		this.soDienThoai = soDienThoai;
		this.gioiTinh = gioiTinh;
		this.users = users;
		this.matKhau = matKhau;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "MaNhanVien", unique = true, nullable = false)
	public Integer getMaNhanVien() {
		return this.maNhanVien;
	}

	public void setMaNhanVien(Integer maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	@Column(name = "TenNhanVien", nullable = false, length = 100)
	public String getTenNhanVien() {
		return this.tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	@Column(name = "ChucVu", length = 30)
	public String getChucVu() {
		return this.chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	@Column(name = "SoDienThoai", length = 30)
	public String getSoDienThoai() {
		return this.soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	@Column(name = "GioiTinh", length = 5)
	public String getGioiTinh() {
		return this.gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	@Column(name = "Users", unique = true, nullable = false, length = 30)
	public String getUsers() {
		return this.users;
	}

	public void setUsers(String users) {
		this.users = users;
	}

	@Column(name = "MatKhau", nullable = false, length = 20)
	public String getMatKhau() {
		return this.matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

}
