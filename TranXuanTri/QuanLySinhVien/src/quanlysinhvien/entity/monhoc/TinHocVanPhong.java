package quanlysinhvien.entity.monhoc;

import java.util.List;

import quanlysinhvien.entity.giangvien.GiangVien;

public class TinHocVanPhong implements MonHoc {
	GiangVien giangVien;
	List<GiangVien> dsTroGiang;

	public TinHocVanPhong() {

	}

	public TinHocVanPhong(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}

	public TinHocVanPhong(GiangVien giangVien, List<GiangVien> dsTroGiang) {
		super();
		this.giangVien = giangVien;
		this.dsTroGiang = dsTroGiang;
	}

	public List<GiangVien> getDsTroGiang() {
		return dsTroGiang;
	}

	public void setDsTroGiang(List<GiangVien> dsTroGiang) {
		this.dsTroGiang = dsTroGiang;
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
		return giangVien.getHoTen() + " || Email: " + giangVien.getEmail();
	}

	@Override
	public List<GiangVien> getDanhSachTroGiang() {
		// TODO Auto-generated method stub
		return dsTroGiang;
	}

	@Override
	public String getThongTinMonHoc() {
		// TODO Auto-generated method stub
		return "Tin Học Văn Phòng";
	}
}
