package entity.hedaotao;

import java.util.List;

import entity.monhoc.MonHoc;
import entity.thoigiandaotao.ThoiGianDaoTao;

public class DaoTaoCapTocJava implements HeDaoTao {
	String tieuChiHeDaoTao =" Dao tao cap toc Java";
	ThoiGianDaoTao thoiGianDaoTao;
	MonHoc MonHoc;
	List<MonHoc> danhSachMonHoc;
	
	public List<MonHoc> getDanhSachMonHoc() {
		return danhSachMonHoc;
	}

	public void setDanhSachMonHoc(List<MonHoc> danhSachMonHoc) {
		this.danhSachMonHoc = danhSachMonHoc;
	}

	public MonHoc getMonHoc() {
		return MonHoc;
	}

	public void setMonHoc(MonHoc monHoc) {
		this.MonHoc = monHoc;
	}

	
	public ThoiGianDaoTao getThoiGianDaoTao() {
		return thoiGianDaoTao;
	}

	public void setThoiGianDaoTao(ThoiGianDaoTao thoiGianDaoTao) {
		this.thoiGianDaoTao = thoiGianDaoTao;
	}

	public String getTieuChiHeDaoTao() {
		return tieuChiHeDaoTao;
	}

	public void setTieuChiHeDaoTao(String tieuChiHeDaoTao) {
		this.tieuChiHeDaoTao = tieuChiHeDaoTao;
	}


}
