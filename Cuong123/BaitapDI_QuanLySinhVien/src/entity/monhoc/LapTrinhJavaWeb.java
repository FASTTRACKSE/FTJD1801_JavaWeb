package entity.monhoc;

import entity.giangvien.GiangVien;

public class LapTrinhJavaWeb implements MonHoc {
	String thongTinMonHoc = "Lập trình Java Web";
	GiangVien giangVien;

	public LapTrinhJavaWeb() {

	}

	public LapTrinhJavaWeb(GiangVien giangVien) {
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
