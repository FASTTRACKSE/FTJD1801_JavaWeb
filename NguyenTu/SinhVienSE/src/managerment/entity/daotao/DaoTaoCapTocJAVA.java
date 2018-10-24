package managerment.entity.daotao;

import java.util.List;

import managerment.entity.monhoc.MonHoc;

public class DaoTaoCapTocJAVA implements HeDaoTao {
	List<MonHoc> dsMonHoc;
	@Override
	public String getThongTinThoiGianHoc() {
		// TODO Auto-generated method stub
		return "6 tháng, tối từ 18h30 – 21h30";
	}

	@Override
	public String getThongTinMonHoc() {
		// TODO Auto-generated method stub
		return  "- Lập trình Java Cơ bản\r\n" + 
				"-	Lập trình Java Web";
	}

	

	public void setDsMonHoc(List<MonHoc> dsJava) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public List<MonHoc> getDanhSachMonHoc() {
		// TODO Auto-generated method stub
		return dsMonHoc;
	}

	@Override
	public String getThongTinHeDaoTao() {
		// TODO Auto-generated method stub
		return "Đào tạo cấp tốc Java";
	}
}
