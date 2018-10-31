package entity.monhoc;

import java.util.List;

import entity.giangvien.GiangVien;

public class LapTrinhWebPHP_MySQL implements MonHoc {
	String thongTinMonHoc = "Lập trình Web PHP & MySQL";
	GiangVien giangVien;
List<GiangVien> dsTroGiang ;
	

	public List<GiangVien> getDsTroGiang() {
		return dsTroGiang;
	}


	public void setDsTroGiang(List<GiangVien> dsTroGiang) {
		this.dsTroGiang = dsTroGiang;
	}
	public LapTrinhWebPHP_MySQL() {

	}
	
	public LapTrinhWebPHP_MySQL(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
		
	}

	public LapTrinhWebPHP_MySQL(GiangVien giangVien, List<GiangVien> dsTroGiang) {
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
