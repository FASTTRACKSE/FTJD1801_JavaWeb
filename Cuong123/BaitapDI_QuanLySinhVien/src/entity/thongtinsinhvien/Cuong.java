package entity.thongtinsinhvien;

public class Cuong implements ThongTinSinhVien{
	String thongTinSinhVien = "Cuong1, 1995, K54/24 Truong Chinh, 0976821865, cuong@gmail.com";

	public Cuong() {
		super();
		
	}
	
	public Cuong(String thongTinSinhVien) {
		super();
		this.thongTinSinhVien = thongTinSinhVien;
	}

	public String getThongTinSinhVien() {
		return thongTinSinhVien;
	}

	public void setThongTinSinhVien(String thongTinSinhVien) {
		this.thongTinSinhVien = thongTinSinhVien;
	}
	

}
