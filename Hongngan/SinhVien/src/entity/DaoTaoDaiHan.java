package entity;

import java.util.List;

public class DaoTaoDaiHan implements HeDaoTao {
	List<MonHoc> dsMonHoc;

	public List<MonHoc> getDsMonHoc() {
		return dsMonHoc;
	}

	public void setDsMonHoc(List<MonHoc> dsMonHoc) {
		this.dsMonHoc = dsMonHoc;
	}
	@Override
	public String getThongTinHeDaoTao() {
		// TODO Auto-generated method stub
		return  "Đào tạo Dài Hạn";
	}

	@Override
	public String getThongTinThoiGianHoc() {
		// TODO Auto-generated method stub
		return "16 tháng, sáng 8h30, chiều 13h30";
	}

	@Override
	public List<MonHoc> getDanhSachMonHoc() {
		// TODO Auto-generated method stub
		return dsMonHoc;
	}

}
