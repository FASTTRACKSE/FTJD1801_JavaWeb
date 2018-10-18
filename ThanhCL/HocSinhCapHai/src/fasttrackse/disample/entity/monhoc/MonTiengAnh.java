package fasttrackse.disample.entity.monhoc;

import fasttrackse.disample.entity.giangvien.GiangVien;

public class MonTiengAnh implements MonHoc {
	String thongTinMonHoc = "Môn Anh, Cô Mỹ";
	GiangVien giangVien;
	
	public String getThongTinMonHoc() {
		return thongTinMonHoc;
	}

	public GiangVien getGiangVien() {
		return giangVien;
	}

	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}

	public void setThongTinMonHoc(String thongTinMonHoc) {
		this.thongTinMonHoc = thongTinMonHoc;
	}

	@Override
	public String getThongTinGiangVien() {
		return giangVien.thongTinGiangVien();
	}
	
}
