package managerment.entity.daotao;

import java.util.List;

import managerment.entity.monhoc.MonHoc;

public interface HeDaoTao {

		public String getThongTinThoiGianHoc();
		
		public String getThongTinHeDaoTao();
		public List<MonHoc> getDanhSachMonHoc();
}
