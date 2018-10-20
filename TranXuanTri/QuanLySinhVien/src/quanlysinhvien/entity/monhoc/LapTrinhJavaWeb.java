package quanlysinhvien.entity.monhoc;

import quanlysinhvien.entity.giangvien.GiangVien;

public class LapTrinhJavaWeb implements MonHoc {
	GiangVien giangVien;

	public LapTrinhJavaWeb(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}

	@Override
	public String getThongTinMonHoc() {
		// TODO Auto-generated method stub
		return "Lập Trình Java web";
	}

	public GiangVien getGiangVien() {
		return giangVien;
	}

	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}

	@Override
	public String getThongTinGiangVien() {
		// TODO Auto-generated method stub
		return giangVien.getThongTinGiangVien();
	}
}
