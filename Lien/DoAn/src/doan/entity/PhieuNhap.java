package doan.entity;
// Generated Jun 2, 2019 10:14:31 PM by Hibernate Tools 5.1.10.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Phieunhap generated by hbm2java
 */
@Entity
@Table(name = "phieunhap", catalog = "doan1")
public class PhieuNhap implements java.io.Serializable {

	private Integer idPhieuNhap;
	private Date ngayNhap;
	private Integer idNhaCungCap;
	private String noiDung;

	public PhieuNhap() {
	}

	public PhieuNhap(Date ngayNhap, Integer idNhaCungCap, String noiDung) {
		this.ngayNhap = ngayNhap;
		this.idNhaCungCap = idNhaCungCap;
		this.noiDung = noiDung;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID_Phieu_Nhap", unique = true, nullable = false)
	public Integer getIdPhieuNhap() {
		return this.idPhieuNhap;
	}

	public void setIdPhieuNhap(Integer idPhieuNhap) {
		this.idPhieuNhap = idPhieuNhap;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "NgayNhap", length = 10)
	public Date getNgayNhap() {
		return this.ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	@Column(name = "ID_Nha_Cung_Cap")
	public Integer getIdNhaCungCap() {
		return this.idNhaCungCap;
	}

	public void setIdNhaCungCap(Integer idNhaCungCap) {
		this.idNhaCungCap = idNhaCungCap;
	}

	@Column(name = "NoiDung", length = 100)
	public String getNoiDung() {
		return this.noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

}
