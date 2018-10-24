package entity.monhoc;

import entity.giangvien.GiangVien;

public class LapTrinhJavaCoBan implements MonHoc {
	String thongTinMonHoc = "Lập trình Java Cơ bản";
	GiangVien giangVien;

	public LapTrinhJavaCoBan() {

	}

	public LapTrinhJavaCoBan(GiangVien giangVien) {
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
