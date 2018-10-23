package sinhvien.entity;

public class MonVan implements MonHoc{
	String tenMonHoc = "Môn Văn";
	String giaoVien = "Cô Hạnh, 1977";
	
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
