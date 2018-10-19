package fasttrackse.disample.entity.monhoc;

import java.util.List;

import fasttrackse.disample.entity.giangvien.GiangVien;

public class MonTiengAnh implements MonHoc {
	String thongTinMonHoc = "Môn Anh, Cô Mỹ";
	GiangVien giangVien;
	List<GiangVien> dsGiangVien;

	public List<GiangVien> getDsGiangVien() {
		return dsGiangVien;
	}

	public void setDsGiangVien(List<GiangVien> dsGiangVien) {
		this.dsGiangVien = dsGiangVien;
	}
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

	@Override
	public List<GiangVien> getDanhSachGiangVien() {
		// TODO Auto-generated method stub
		return dsGiangVien;
	}
	
}
