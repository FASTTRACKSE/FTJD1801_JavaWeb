package managerment.entity.daotao;

import java.util.List;

import managerment.entity.monhoc.MonHoc;

public class DaoTaoDaiHan implements HeDaoTao {

	List<MonHoc> dsMonHoc;
	@Override
	public String getThongTinThoiGianHoc() {
		// TODO Auto-generated method stub
		return "16 tháng, sáng 8h30, chiều 13h30";
	}

	@Override
	public String getThongTinMonHoc() {
		// TODO Auto-generated method stub
		return 	"-	Tin học văn phòng\r\n" + 
				"-	Lập trình cơ bản\r\n" + 
				"-	Lập trình Web frontend\r\n" + 
				"-	Lập trình Web PHP & MySQL\r\n" + 
				"-	Lập trình Java Cơ bản\r\n" + 
				"-	Lập trình Java Web\r\n" + 
				"-	Quy trình dự án";

}

	public void setDsDaiHan(List<MonHoc> dsDaiHan) {
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
		return "Đào tạo dài hạn";
	}
}
