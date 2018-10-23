package fasttrackse.entity.chuongtrinhdaotao;

import java.util.List;

import fasttrackse.entity.monhoc.MonHoc;

public class DaoTaoCapTocJava implements HeDaoTao {
	List<MonHoc> monhoc;

	@Override
	public String getThongTinThoiGianHoc() {
		// TODO Auto-generated method stub
		return "6 tháng, tối từ 18h30 – 21h30";
	}

	@Override
	public String getHeDaoTao() {
		// TODO Auto-generated method stub
		return "Đào tạo cấp tốc Java";
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
		return null;
	}

}
