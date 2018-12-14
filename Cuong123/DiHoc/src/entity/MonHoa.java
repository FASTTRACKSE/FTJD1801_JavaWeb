package entity;

public class MonHoa implements MonHoc{
	String thongTinMonHoc = "Mon Hoa";
	ThongTinGiangVien thongTinGiangVien ;

	public String getThongTinMonHoc() {
		return thongTinMonHoc;
	}

	public void setThongTinMonHoc(String thongTinMonHoc) {
		this.thongTinMonHoc = thongTinMonHoc;
	}

	public ThongTinGiangVien getThongTinGiangVien() {
		return thongTinGiangVien;
	}

	public void setThongTinGiangVien(ThongTinGiangVien thongTinGiangVien) {
		this.thongTinGiangVien = thongTinGiangVien;
	}
	
	

}
