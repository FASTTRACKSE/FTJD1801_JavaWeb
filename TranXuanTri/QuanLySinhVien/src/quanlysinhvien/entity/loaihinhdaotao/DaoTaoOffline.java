package quanlysinhvien.entity.loaihinhdaotao;

public class DaoTaoOffline implements LoaiHinhDaoTao {
	String loaiDaoTao = "Đào tạo Offline";
	String thoiGian = "Sáng từ 8h00, chiều từ 13h30, tối từ 18h30";
	String diaChi = "Toà nhà FPT, KCN An Đồn";

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
