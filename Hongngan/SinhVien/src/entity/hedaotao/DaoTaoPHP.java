package entity.hedaotao;

import java.util.List;

import entity.MonHoc.MonHoc;

public class DaoTaoPHP implements HeDaoTao {
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
		return  "Đào tạo cấp tốc PHP";
	}

	@Override
	public String getThongTinThoiGianHoc() {
		// TODO Auto-generated method stub
		return "6 tháng, tối từ 18h30 – 21h30";
	}

	@Override
	public List<MonHoc> getDanhSachMonHoc() {
		// TODO Auto-generated method stub
		return dsMonHoc;
	}

}
