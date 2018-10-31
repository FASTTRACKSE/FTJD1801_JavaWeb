package entity.monhoc;

import java.util.List;

import entity.giangvien.GiangVien;

public class QuyTrinhDuAn implements MonHoc{
	List<GiangVien> giangvien;
	List<GiangVien> trogiang;

	@Override
	public String getTenMonHoc() {
		// TODO Auto-generated method stub
		return "Quy trình dự án";
	}

	public List<GiangVien> getGiangvien() {
		return giangvien;
	}

	public List<GiangVien> getTrogiang() {
		return trogiang;
	}

	public void setTrogiang(List<GiangVien> trogiang) {
		this.trogiang = trogiang;
	}

	public void setGiangvien(List<GiangVien> giangvien) {
		this.giangvien = giangvien;
	}

	@Override
	public List<GiangVien> getDanhSachGiangVien() {
		// TODO Auto-generated method stub
		return giangvien;
	}

	@Override
	public List<GiangVien> getDanhSachTroGiang() {
		// TODO Auto-generated method stub
		return trogiang;
	}
}
