package managerment.entity.daotao;

import managerment.entity.giangvien.ThayToan;
import managerment.entity.monhoc.MonHoc;

public class DaoTaoOnline implements LoaiHinhDaoTao, MonHoc {

	@Override
	public String getThoiGian() {
		// TODO Auto-generated method stub
		return "24/24";
	}

	@Override
	public String getDiaChi() {
		// TODO Auto-generated method stub
		return "trang web LMS.FASTTRACK.EDU.VN";
	}

	public DaoTaoOnline(ThayToan thayToan) {
		// TODO Auto-generated constructor stub
	}

	

	public DaoTaoOnline() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTenMonHoc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGiangVienPhuTrach() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTenLoaiDaoTao() {
		// TODO Auto-generated method stub
		return "Đào tạo online";
	}
	
}
