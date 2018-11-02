package entity.MonHoc;

import java.util.List;

import entity.GiangVien;

public class QuyTrinhDuAn implements MonHoc{
	List<GiangVien> giangvien;
	List<GiangVien> trogiang;

	public List<GiangVien> getGiangvien() {
		return giangvien;
	}

	public void setGiangvien(List<GiangVien> giangvien) {
		this.giangvien = giangvien;
	}

	public List<GiangVien> getTrogiang() {
		return trogiang;
	}

	public void setTrogiang(List<GiangVien> trogiang) {
		this.trogiang = trogiang;
	}

	@Override
	public String getThongTinMonHoc() {
		// TODO Auto-generated method stub
		return "Quy Trình Dự Án";
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
