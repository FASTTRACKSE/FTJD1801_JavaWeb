package hocsinh.entity.monhoc;

import hocsinh.entity.giangvien.GiangVien;

public class MonToan implements MonHoc {
	String thongTinMonHoc = "Môn Toán";
	GiangVien giangVien;
	public MonToan() {
		
	}
	public MonToan(GiangVien giangVien) {
		this.giangVien = giangVien;
	}
	public String getThongTinMonHoc() {
		return thongTinMonHoc;
	}

	public void setThongTinMonHoc(String thongTinMonHoc) {
		this.thongTinMonHoc = thongTinMonHoc;
	}

	public GiangVien getGiangVien() {
		return giangVien;
	}

	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}

	@Override
	public String getThongTinGiangVien() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
