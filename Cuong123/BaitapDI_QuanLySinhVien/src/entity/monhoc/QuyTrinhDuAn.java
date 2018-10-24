package entity.monhoc;

import entity.giangvien.GiangVien;

public class QuyTrinhDuAn implements MonHoc {
	String thongTinMonHoc = "Quy trình dự án";
	GiangVien giangVien;

	public QuyTrinhDuAn() {
		// TODO Auto-generated constructor stub
	}

	public QuyTrinhDuAn(GiangVien giangVien) {
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
