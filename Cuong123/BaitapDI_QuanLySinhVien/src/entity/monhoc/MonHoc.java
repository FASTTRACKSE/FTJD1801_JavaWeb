package entity.monhoc;

import java.util.List;

import entity.giangvien.GiangVien;

public interface MonHoc {
	public String getThongTinMonHoc();
	public GiangVien getGiangVien();
	public List<GiangVien> getDsTroGiang() ;
	
}
