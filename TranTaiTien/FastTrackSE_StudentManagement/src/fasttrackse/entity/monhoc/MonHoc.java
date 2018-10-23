package fasttrackse.entity.monhoc;

import java.util.List;

import fasttrackse.entity.giangvien.GiangVien;

public interface MonHoc {
	public String getTenMonHoc();
	public List<GiangVien> getDanhSachGiangVien();
}
