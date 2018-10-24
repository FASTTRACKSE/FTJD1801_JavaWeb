package quanlysinhvien.entity.monhoc;

import quanlysinhvien.entity.giangvien.GiangVien;

public class QuyTrinhDuAn implements MonHoc {
	GiangVien giangVien;

	public QuyTrinhDuAn(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}

	@Override
	public String getThongTinMonHoc() {
		// TODO Auto-generated method stub
		return "Quy Trình Dự Án";
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
