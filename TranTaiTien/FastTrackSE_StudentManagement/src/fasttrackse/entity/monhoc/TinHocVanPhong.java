package fasttrackse.entity.monhoc;

import java.util.List;

import fasttrackse.entity.giangvien.GiangVien;

public class TinHocVanPhong implements MonHoc {
	List<GiangVien> giangvien;
	List<GiangVien> trogiang;

	@Override
	public String getTenMonHoc() {
		// TODO Auto-generated method stub
		return "Tin học văn phòng";
	}

	@Override
	public List<GiangVien> getDanhSachGiangVien() {
		// TODO Auto-generated method stub
		return giangvien;
	}

	public List<GiangVien> getGiangvien() {
		return giangvien;
	}

	public void setGiangvien(List<GiangVien> giangvien) {
		this.giangvien = giangvien;
	}

	public List<GiangVien> getTrogiang() {
		return trogiang;
	}

	public void setTrogiang(List<GiangVien> trogiang) {
		this.trogiang = trogiang;
	}

	@Override
	public List<GiangVien> getDanhSachTroGiang() {
		// TODO Auto-generated method stub
		return trogiang;
	}

}
