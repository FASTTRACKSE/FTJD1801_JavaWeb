package quanlysinhvien.entity.hedaotao;

import java.util.List;
import quanlysinhvien.entity.monhoc.*;

public class DaoTaoJava implements HeDaoTao {

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
		return "Đào tạo cấp tốc Java";
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
