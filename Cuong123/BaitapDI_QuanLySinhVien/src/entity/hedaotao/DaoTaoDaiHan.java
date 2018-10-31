package entity.hedaotao;

import java.util.List;

import entity.monhoc.MonHoc;
import entity.thoigiandaotao.ThoiGianDaoTao;

public class DaoTaoDaiHan implements HeDaoTao{
	
		String tieuChiHeDaoTao =" Dao tao dai han";
		ThoiGianDaoTao thoiGianDaoTao;
		MonHoc MonHoc;
		List<MonHoc> danhSachMonHoc;
		
		public List<MonHoc> getDanhSachMonHoc() {
			return danhSachMonHoc;
		}

		public void setDanhSachMonHoc(List<MonHoc> danhSachMonHoc) {
			this.danhSachMonHoc = danhSachMonHoc;
		}
		

		public String getTieuChiHeDaoTao() {
			return tieuChiHeDaoTao;
		}

		public void setTieuChiHeDaoTao(String tieuChiHeDaoTao) {
			this.tieuChiHeDaoTao = tieuChiHeDaoTao;
		}

		public ThoiGianDaoTao getThoiGianDaoTao() {
			return thoiGianDaoTao;
		}
		public void setThoiGianDaoTao(ThoiGianDaoTao thoiGianDaoTao) {
			this.thoiGianDaoTao = thoiGianDaoTao;
		}

		public MonHoc getMonHoc() {
			return MonHoc;
		}

		public void setMonHoc(MonHoc monHoc) {
			this.MonHoc = monHoc;
		}

		

		

		
	

}
