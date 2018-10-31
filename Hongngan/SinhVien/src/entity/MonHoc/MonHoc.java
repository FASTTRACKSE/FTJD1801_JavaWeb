package entity.MonHoc;

import java.util.List;

import entity.GiangVien;

public interface MonHoc {
	public String getThongTinMonHoc();
	public List<GiangVien> getDanhSachGiangVien();
	public List<GiangVien> getDanhSachTroGiang();
	
}
