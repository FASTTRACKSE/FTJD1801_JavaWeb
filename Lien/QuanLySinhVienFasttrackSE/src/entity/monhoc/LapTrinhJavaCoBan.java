package entity.monhoc;

import java.util.List;

import entity.giangvien.GiangVien;

public class LapTrinhJavaCoBan implements MonHoc {
	List<GiangVien> giangvien;

	public List<GiangVien> getGiangvien() {
		return giangvien;
	}

	public void setGiangvien(List<GiangVien> giangvien) {
		this.giangvien = giangvien;
	}

	@Override
	public String getTenMonHoc() {
		// TODO Auto-generated method stub
		return "Lập trình java cơ bản";
	}

	@Override
	public List<GiangVien> getDanhSachGiangVien() {
		// TODO Auto-generated method stub
		return giangvien;
	}
}