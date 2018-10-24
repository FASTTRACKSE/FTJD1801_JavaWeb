package managerment.entity.daotao;

import java.util.List;

import managerment.entity.monhoc.MonHoc;

public class DaoTaoCapTocPHP implements HeDaoTao {
	List<MonHoc> dsMonHoc;
	@Override
	public String getThongTinThoiGianHoc() {
		// TODO Auto-generated method stub
		return "6 tháng, tối từ 18h30 – 21h30";
	}

	@Override
	public String getThongTinMonHoc() {
		// TODO Auto-generated method stub
		return 	"- Lập trình Web frontend\r\n" + 
				"- Lập trình Web PHP & MySQL";
	}

	public void setDsMonHoc(List<MonHoc> dsPhp) {
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
		return "Đào tạo cấp tốc Php";
	}
}
