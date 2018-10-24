package managerment.entity.daotao;

public class DaoTaoOffline implements LoaiHinhDaoTao {

	@Override
	public String getThoiGian() {
		// TODO Auto-generated method stub
		return "sáng từ 8h00, chiều từ 13h30, tối từ 18h30";
	}

	@Override
	public String getDiaChi() {
		// TODO Auto-generated method stub
		return "Toà nhà FPT, KCN An Đồn";
	}

	@Override
	public String getTenLoaiDaoTao() {
		// TODO Auto-generated method stub
		return "Đào tạo offline";
	}

}
