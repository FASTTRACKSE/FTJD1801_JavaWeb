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
 * Phieuxuat generated by hbm2java
 */
@Entity
@Table(name = "phieuxuat", catalog = "doan1")
public class PhieuXuat implements java.io.Serializable {

	private Integer idPhieuXuat;
	private Date ngayXuat;
	private Integer maHoaDon;
	private String noiDung;

	public PhieuXuat() {
	}

	public PhieuXuat(Date ngayXuat, Integer maHoaDon, String noiDung) {
		this.ngayXuat = ngayXuat;
		this.maHoaDon = maHoaDon;
		this.noiDung = noiDung;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID_Phieu_Xuat", unique = true, nullable = false)
	public Integer getIdPhieuXuat() {
		return this.idPhieuXuat;
	}

	public void setIdPhieuXuat(Integer idPhieuXuat) {
		this.idPhieuXuat = idPhieuXuat;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "NgayXuat", length = 10)
	public Date getNgayXuat() {
		return this.ngayXuat;
	}

	public void setNgayXuat(Date ngayXuat) {
		this.ngayXuat = ngayXuat;
	}

	@Column(name = "Ma_Hoa_Don")
	public Integer getMaHoaDon() {
		return this.maHoaDon;
	}

	public void setMaHoaDon(Integer maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	@Column(name = "NoiDung", length = 100)
	public String getNoiDung() {
		return this.noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

}
