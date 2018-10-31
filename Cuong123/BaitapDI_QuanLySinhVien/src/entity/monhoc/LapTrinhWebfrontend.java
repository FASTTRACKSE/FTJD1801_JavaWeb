package entity.monhoc;

import java.util.List;

import entity.giangvien.GiangVien;

public class LapTrinhWebfrontend implements MonHoc {
	String thongTinMonHoc = "Lập trình Web frontend";
	GiangVien giangVien;
List<GiangVien> dsTroGiang ;
	

	public List<GiangVien> getDsTroGiang() {
		return dsTroGiang;
	}


	public void setDsTroGiang(List<GiangVien> dsTroGiang) {
		this.dsTroGiang = dsTroGiang;
	}
	
	public LapTrinhWebfrontend() {
		
	}

	public LapTrinhWebfrontend(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
		
	}
	
	public LapTrinhWebfrontend(GiangVien giangVien, List<GiangVien> dsTroGiang) {
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
