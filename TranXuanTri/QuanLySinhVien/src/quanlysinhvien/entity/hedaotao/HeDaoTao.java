package quanlysinhvien.entity.hedaotao;


import java.util.List;

import quanlysinhvien.entity.monhoc.MonHoc;

public interface HeDaoTao {
	public String getThongTinHeDaoTao();
	public String getThongTinThoiGianHoc();
	public List<MonHoc> getDanhSachMonHoc();
}
