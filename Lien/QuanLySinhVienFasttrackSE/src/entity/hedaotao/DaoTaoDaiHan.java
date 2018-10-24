package entity.hedaotao;

import java.util.List;

import entity.monhoc.MonHoc;

public class DaoTaoDaiHan implements HeDaoTao {
	List<MonHoc> monhoc;

	@Override
	public String getThongTinThoiGianHoc() {
		// TODO Auto-generated method stub
		return "16 tháng, sáng 8h30, chiều 13h30";
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
		return "Đào tạo dài hạn";
	}

	@Override
	public List<MonHoc> getDanhSachMonHoc() {
		// TODO Auto-generated method stub
		return monhoc;
	}
}
