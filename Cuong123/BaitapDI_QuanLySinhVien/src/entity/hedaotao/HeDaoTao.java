package entity.hedaotao;

import java.util.List;

import entity.monhoc.MonHoc;
import entity.thoigiandaotao.ThoiGianDaoTao;

public interface HeDaoTao {
	public String getTieuChiHeDaoTao();
	public ThoiGianDaoTao getThoiGianDaoTao();
	public MonHoc getMonHoc();
	public List<MonHoc> getDanhSachMonHoc();
	
	
}
