package doan.entity;
// Generated Jun 2, 2019 10:14:31 PM by Hibernate Tools 5.1.10.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Chitietdonhang generated by hbm2java
 */
@Entity
@Table(name = "chitietdonhang", catalog = "doan1")
public class ChiTietDonHang implements java.io.Serializable {

	private ChiTietDonHangId id;
	private Integer soLuong;
	private Integer donGia;
	private String ghiChu;

	public ChiTietDonHang() {
	}

	public ChiTietDonHang(ChiTietDonHangId id) {
		this.id = id;
	}

	public ChiTietDonHang(ChiTietDonHangId id, Integer soLuong, Integer donGia, String ghiChu) {
		this.id = id;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.ghiChu = ghiChu;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "maHang", column = @Column(name = "MaHang", nullable = false)),
			@AttributeOverride(name = "maDonHang", column = @Column(name = "MaDonHang", nullable = false)) })
	public ChiTietDonHangId getId() {
		return this.id;
	}

	public void setId(ChiTietDonHangId id) {
		this.id = id;
	}

	@Column(name = "SoLuong")
	public Integer getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	@Column(name = "DonGia")
	public Integer getDonGia() {
		return this.donGia;
	}

	public void setDonGia(Integer donGia) {
		this.donGia = donGia;
	}

	@Column(name = "GhiChu", length = 65535)
	public String getGhiChu() {
		return this.ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

}
