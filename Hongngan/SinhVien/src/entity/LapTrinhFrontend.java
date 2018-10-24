package entity;

public class LapTrinhFrontend implements MonHoc{
	String thongTinMonHoc = "Lập Trình Frontend";
	GiangVien giangVien;
	public LapTrinhFrontend(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}
	public String getThongTinMonHoc() {
		return thongTinMonHoc;
	}
	public void setThongTinMonHoc(String thongTinMonHoc) {
		this.thongTinMonHoc = thongTinMonHoc;
	}
	public GiangVien getGiangVien() {
		return giangVien;
	}
	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}
	@Override
	public String getThongTinGiangVien() {
		// TODO Auto-generated method stub
		return giangVien.getThongTinGiangVien();
	}

	

}
