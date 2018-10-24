package entity.monhoc;

import entity.giangvien.GiangVien;

public class LapTrinhCoBan implements MonHoc {
	String thongTinMonHoc = "Lập trình cơ bản";
	GiangVien giangVien;
	

	public LapTrinhCoBan() {
		// TODO Auto-generated constructor stub
	}
	

	public LapTrinhCoBan(GiangVien giangVien) {
		super();
		
		this.giangVien = giangVien;
	}


	public GiangVien getGiangVien() {
		return giangVien;
	}

	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}

	public String getThongTinMonHoc() {
		return thongTinMonHoc;
	}

	public void setThongTinMonHoc(String thongTinMonHoc) {
		this.thongTinMonHoc = thongTinMonHoc;
	}



	

	
	
}
