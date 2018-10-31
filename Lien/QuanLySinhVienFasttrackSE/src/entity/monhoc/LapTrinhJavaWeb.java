package entity.monhoc;

import java.util.List;

import entity.giangvien.GiangVien;

public class LapTrinhJavaWeb implements MonHoc {
	List<GiangVien> giangvien;
	List<GiangVien> trogiang;
	public List<GiangVien> getGiangvien() {
		return giangvien;
	}

	public void setGiangvien(List<GiangVien> giangvien) {
		this.giangvien = giangvien;
	}

	@Override
	public String getTenMonHoc() {
		// TODO Auto-generated method stub
		return "Lập trình java web";
	}

	public List<GiangVien> getTrogiang() {
		return trogiang;
	}

	public void setTrogiang(List<GiangVien> trogiang) {
		this.trogiang = trogiang;
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
