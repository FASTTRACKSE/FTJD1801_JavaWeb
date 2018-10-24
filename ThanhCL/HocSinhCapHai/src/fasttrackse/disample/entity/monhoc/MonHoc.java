package fasttrackse.disample.entity.monhoc;

import java.util.List;

import fasttrackse.disample.entity.giangvien.GiangVien;

public interface MonHoc {
	public String getThongTinMonHoc();
	public String getThongTinGiangVien();
	public List<GiangVien> getDanhSachGiangVien();
}
