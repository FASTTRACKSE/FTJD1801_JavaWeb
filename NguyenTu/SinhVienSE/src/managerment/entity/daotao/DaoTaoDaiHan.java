package managerment.entity.daotao;

import java.util.List;

import managerment.entity.monhoc.MonHoc;

public class DaoTaoDaiHan implements HeDaoTao {

	List<MonHoc> monhoc;

	@Override
	public String getThongTinThoiGianHoc() {
		// TODO Auto-generated method stub
		return "16 tháng, sáng 8h30, chiều 13h30";
	}

	@Override
	public String getThongTinHeDaoTao() {
		// TODO Auto-generated method stub
		return "Đào tạo dài hạn";
	}

	public List<MonHoc> getMonhoc() {
		return monhoc;
	}

	public void setMonhoc(List<MonHoc> monhoc) {
		this.monhoc = monhoc;
	}

	@Override
	public List<MonHoc> getDanhSachMonHoc() {
		// TODO Auto-generated method stub
		return monhoc;
	}
}
