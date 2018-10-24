package entity;

public class QuyTrinhDuAn implements MonHoc{
	String thongTinMonHoc = "Quy Trình Dự Án";
	GiangVien giangVien;
	public QuyTrinhDuAn(GiangVien giangVien) {
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
