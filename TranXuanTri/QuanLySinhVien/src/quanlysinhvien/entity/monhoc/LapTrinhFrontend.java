package quanlysinhvien.entity.monhoc;

import quanlysinhvien.entity.giangvien.GiangVien;

public class LapTrinhFrontend implements MonHoc {
	GiangVien giangVien;

	public LapTrinhFrontend(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}

	@Override
	public String getThongTinMonHoc() {
		// TODO Auto-generated method stub
		return "Lập trình frontend";
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
