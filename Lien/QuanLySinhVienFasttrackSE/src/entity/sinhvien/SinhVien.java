package entity.sinhvien;

import entity.hedaotao.HeDaoTao;
import entity.loaidaotao.LoaiHinhDaoTao;

public class SinhVien {
	String hoTen;
	int namSinh;
	String diaChi;
	String dienThoai;
	String email;
	LoaiHinhDaoTao loaiDaoTao;
	HeDaoTao heDaoTao;

	public SinhVien() {
		super();
	}

	public SinhVien(String hoTen, int namSinh, String diaChi, String dienThoai, String email, LoaiHinhDaoTao loaiDaoTao,
			HeDaoTao heDaoTao) {
		super();
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.email = email;
		this.loaiDaoTao = loaiDaoTao;
		this.heDaoTao = heDaoTao;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LoaiHinhDaoTao getLoaiDaoTao() {
		return loaiDaoTao;
	}

	public void setLoaiDaoTao(LoaiHinhDaoTao loaiDaoTao) {
		this.loaiDaoTao = loaiDaoTao;
	}

	public HeDaoTao getHeDaoTao() {
		return heDaoTao;
	}

	public void setHeDaoTao(HeDaoTao heDaoTao) {
		this.heDaoTao = heDaoTao;
	}

}
