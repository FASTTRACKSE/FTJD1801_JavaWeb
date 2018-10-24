package entity.monhoc;

import entity.giangvien.GiangVien;

public class TinHocVanPhong implements MonHoc {
	String thongTinMonHoc = "Tin học văn phòng";
	GiangVien giangVien;

	

	public TinHocVanPhong() {
	// TODO Auto-generated constructor stub
}
	

	public TinHocVanPhong(GiangVien giangVien) {
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
