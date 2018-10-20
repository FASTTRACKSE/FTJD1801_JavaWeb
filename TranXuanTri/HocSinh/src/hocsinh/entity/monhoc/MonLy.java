package hocsinh.entity.monhoc;

import hocsinh.entity.giangvien.GiangVien;

public class MonLy implements MonHoc {
	String thongTinMonHoc = "Môn Lý";
	GiangVien giangVien;
	public MonLy() {
		
	}
	public MonLy(GiangVien giangVien) {
		this.giangVien = giangVien;
	}
	public String getThongTinMonHoc() {
		return thongTinMonHoc;
	}
	
	@Override
	public String getThongTinGiangVien() {
		// TODO Auto-generated method stub
		return giangVien.getThongTinGiangVien();
	}

	public GiangVien getGiangVien() {
		return giangVien;
	}

	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}
}
