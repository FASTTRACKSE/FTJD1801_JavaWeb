package entity.monhoc;

import java.util.List;

import entity.giangvien.GiangVien;

public class LapTrinhJavaCoBan implements MonHoc {
	String thongTinMonHoc = "Lập trình Java Cơ bản";
	GiangVien giangVien;
	List<GiangVien> dsTroGiang;

	public LapTrinhJavaCoBan() {

	}

	public LapTrinhJavaCoBan(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;

	}

	public LapTrinhJavaCoBan(GiangVien giangVien, List<GiangVien> dsTroGiang) {
		super();
		this.giangVien = giangVien;
		this.dsTroGiang = dsTroGiang;
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

	public List<GiangVien> getDsTroGiang() {
		return dsTroGiang;
	}

	public void setDsTroGiang(List<GiangVien> dsTroGiang) {
		this.dsTroGiang = dsTroGiang;
	}

}
