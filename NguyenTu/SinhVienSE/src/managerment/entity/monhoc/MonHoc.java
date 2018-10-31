package managerment.entity.monhoc;

import java.util.List;

import managerment.entity.giangvien.*;

public interface MonHoc {

	public String getTenMonHoc();
	public List<GiangVien> getDanhSachGiangVien();
	public List<GiangVien> getDanhSachTroGiang();
	
}
