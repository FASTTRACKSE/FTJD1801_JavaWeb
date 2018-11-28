package sinhvien.entity;

public class MonToan implements MonHoc {
	String tenMonHoc = "Môn Toán";
	String giaoVien = "Thầy Nhân, 1980";

	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

	public String getGiaoVien() {
		return giaoVien;
	}

	public void setGiaoVien(String giaoVien) {
		this.giaoVien = giaoVien;
	}
}
