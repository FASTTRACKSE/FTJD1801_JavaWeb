package entity.hedaotao;

import java.util.List;

import entity.monhoc.MonHoc;

public class DaoTaoPHP implements HeDaoTao {
	List<MonHoc> monhoc;

	@Override
	public String getThongTinThoiGianHoc() {
		// TODO Auto-generated method stub
		return "6 tháng, tối từ 18h30 – 21h30";
	}

	public List<MonHoc> getMonhoc() {
		return monhoc;
	}

	public void setMonhoc(List<MonHoc> monhoc) {
		this.monhoc = monhoc;
	}

	@Override
	public String getHeDaoTao() {
		// TODO Auto-generated method stub
		return "Đào tạo cấp tốc PHP";
	}

	@Override
	public List<MonHoc> getDanhSachMonHoc() {
		// TODO Auto-generated method stub
		return monhoc;
	}
}
