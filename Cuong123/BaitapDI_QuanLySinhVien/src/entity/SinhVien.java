package entity;

import entity.hedaotao.HeDaoTao;
import entity.loaihinhdaotao.LoaiHinhDaoTao;
import entity.thongtinsinhvien.ThongTinSinhVien;

public class SinhVien {
	ThongTinSinhVien thongTinSinhVien;
	LoaiHinhDaoTao loaiHinhDaoTao;
	HeDaoTao heDaoTao;
	
	
	public ThongTinSinhVien getThongTinSinhVien() {
		return thongTinSinhVien;
	}
	public void setThongTinSinhVien(ThongTinSinhVien thongTinSinhVien) {
		this.thongTinSinhVien = thongTinSinhVien;
	}
	public LoaiHinhDaoTao getLoaiHinhDaoTao() {
		return loaiHinhDaoTao;
	}
	public void setLoaiHinhDaoTao(LoaiHinhDaoTao loaiHinhDaoTao) {
		this.loaiHinhDaoTao = loaiHinhDaoTao;
	}
	public HeDaoTao getHeDaoTao() {
		return heDaoTao;
	}
	public void setHeDaoTao(HeDaoTao heDaoTao) {
		this.heDaoTao = heDaoTao;
	}
	
	public SinhVien() {
		super();
	
	}
	public SinhVien(ThongTinSinhVien thongTinSinhVien, LoaiHinhDaoTao loaiHinhDaoTao,
			HeDaoTao heDaoTao) {
		super();
		this.thongTinSinhVien = thongTinSinhVien;
		this.loaiHinhDaoTao = loaiHinhDaoTao;
		this.heDaoTao = heDaoTao;
	}
	
	
	
	
}
