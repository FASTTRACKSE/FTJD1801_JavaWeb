package entity.monhoc;

import entity.giangvien.GiangVien;

public class LapTrinhWebPHP_MySQL implements MonHoc {
	String thongTinMonHoc = "Lập trình Web PHP & MySQL";
	GiangVien giangVien;

	public LapTrinhWebPHP_MySQL() {

	}

	public LapTrinhWebPHP_MySQL(GiangVien giangVien) {
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
