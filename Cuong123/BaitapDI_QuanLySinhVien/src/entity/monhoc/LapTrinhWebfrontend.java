package entity.monhoc;

import entity.giangvien.GiangVien;

public class LapTrinhWebfrontend implements MonHoc {
	String thongTinMonHoc = "Lập trình Web frontend";
	GiangVien giangVien;
	
	
	public LapTrinhWebfrontend() {
		
	}

	public LapTrinhWebfrontend(GiangVien giangVien) {
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
