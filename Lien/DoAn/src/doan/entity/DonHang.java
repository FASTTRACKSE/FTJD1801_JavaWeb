package doan.entity;
// Generated Jun 10, 2019 6:54:00 AM by Hibernate Tools 5.1.10.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * Donhang generated by hbm2java
 */
@Entity
@Table(name = "donhang", catalog = "doan1")
public class DonHang implements java.io.Serializable {

	private Integer maDonHang;
	private int maKhachHang;
	@DateTimeFormat(iso=ISO.DATE)
	private Date ngayDatHang;
	@DateTimeFormat(iso=ISO.DATE)
	private Date ngayGiaoHang;
	private String diaChi;
	private int tongThanhTien;
	private Integer maNhanVien;
	private String trangThai;
	private Integer giamGia;
	private String soDienThoai;

	public DonHang() {
	}

	public DonHang(int maKhachHang, Date ngayDatHang, String diaChi, int tongThanhTien, String soDienThoai) {
		this.maKhachHang = maKhachHang;
		this.ngayDatHang = ngayDatHang;
		this.diaChi = diaChi;
		this.tongThanhTien = tongThanhTien;
		this.soDienThoai = soDienThoai;
	}

	public DonHang(int maKhachHang, Date ngayDatHang, Date ngayGiaoHang, String diaChi, int tongThanhTien,
			Integer maNhanVien, String trangThai, Integer giamGia, String soDienThoai) {
		this.maKhachHang = maKhachHang;
		this.ngayDatHang = ngayDatHang;
		this.ngayGiaoHang = ngayGiaoHang;
		this.diaChi = diaChi;
		this.tongThanhTien = tongThanhTien;
		this.maNhanVien = maNhanVien;
		this.trangThai = trangThai;
		this.giamGia = giamGia;
		this.soDienThoai = soDienThoai;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "MaDonHang", unique = true, nullable = false)
	public Integer getMaDonHang() {
		return this.maDonHang;
	}

	public void setMaDonHang(Integer maDonHang) {
		this.maDonHang = maDonHang;
	}

	@Column(name = "MaKhachHang", nullable = false)
	public int getMaKhachHang() {
		return this.maKhachHang;
	}

	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "NgayDatHang", nullable = false, length = 19)
	public Date getNgayDatHang() {
		return this.ngayDatHang;
	}

	public void setNgayDatHang(Date ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "NgayGiaoHang", length = 19)
	public Date getNgayGiaoHang() {
		return this.ngayGiaoHang;
	}

	public void setNgayGiaoHang(Date ngayGiaoHang) {
		this.ngayGiaoHang = ngayGiaoHang;
	}

	@Column(name = "DiaChi", nullable = false, length = 100)
	public String getDiaChi() {
		return this.diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	@Column(name = "TongThanhTien", nullable = false)
	public int getTongThanhTien() {
		return this.tongThanhTien;
	}

	public void setTongThanhTien(int tongThanhTien) {
		this.tongThanhTien = tongThanhTien;
	}

	@Column(name = "MaNhanVien")
	public Integer getMaNhanVien() {
		return this.maNhanVien;
	}

	public void setMaNhanVien(Integer maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	@Column(name = "TrangThai", length = 20)
	public String getTrangThai() {
		return this.trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	@Column(name = "GiamGia")
	public Integer getGiamGia() {
		return this.giamGia;
	}

	public void setGiamGia(Integer giamGia) {
		this.giamGia = giamGia;
	}

	@Column(name = "SoDienThoai", nullable = false, length = 10)
	public String getSoDienThoai() {
		return this.soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

}
