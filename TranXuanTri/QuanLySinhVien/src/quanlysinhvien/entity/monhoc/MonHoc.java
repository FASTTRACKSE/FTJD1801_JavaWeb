package quanlysinhvien.entity.monhoc;

import java.util.List;

import quanlysinhvien.entity.giangvien.GiangVien;

public interface MonHoc {
	public String getThongTinMonHoc();

	public String getThongTinGiangVien();
	
	public List<GiangVien> getDanhSachTroGiang();
}
