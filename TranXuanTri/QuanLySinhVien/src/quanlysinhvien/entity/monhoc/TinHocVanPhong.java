package quanlysinhvien.entity.monhoc;

import quanlysinhvien.entity.giangvien.GiangVien;

public class TinHocVanPhong implements MonHoc {
	GiangVien giangVien;

	public TinHocVanPhong(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}

	@Override
	public String getThongTinMonHoc() {
		// TODO Auto-generated method stub
		return "Tin học văn phòng";
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
