package entity.monhoc;

import java.util.List;

import entity.giangvien.GiangVien;

public class QuyTrinhDuAn implements MonHoc {
	String thongTinMonHoc = "Quy trình dự án";
	GiangVien giangVien;
List<GiangVien> dsTroGiang ;
	

	public List<GiangVien> getDsTroGiang() {
		return dsTroGiang;
	}


	public void setDsTroGiang(List<GiangVien> dsTroGiang) {
		this.dsTroGiang = dsTroGiang;
	}
	public QuyTrinhDuAn() {
		// TODO Auto-generated constructor stub
	}
	
	public QuyTrinhDuAn(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
		
	}

	public QuyTrinhDuAn(GiangVien giangVien, List<GiangVien> dsTroGiang) {
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

}
