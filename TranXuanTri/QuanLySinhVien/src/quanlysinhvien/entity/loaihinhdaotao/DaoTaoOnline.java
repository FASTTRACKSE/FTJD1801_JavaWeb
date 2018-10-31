package quanlysinhvien.entity.loaihinhdaotao;

public class DaoTaoOnline implements LoaiHinhDaoTao {
	String loaiDaoTao = "Đào tạo online";
	String thoiGian = "24/24";
	String diaChi = "trang web LMS.FASTTRACK.EDU.VN";

	@Override
	public String getThongTinLoaiDaoTao() {
		// TODO Auto-generated method stub
		return loaiDaoTao;
	}

	@Override
	public String getGioHoc() {
		// TODO Auto-generated method stub
		return thoiGian;
	}

	@Override
	public String getDiaDiem() {
		// TODO Auto-generated method stub
		return diaChi;
	}
}
