package entity.thongtinsinhvien;

public class Cuong2 implements ThongTinSinhVien{
	String thongTinSinhVien = "Cuong2, 1995, K54/24 Truong Chinh, 0976821865, cuong@gmail.com";

	public Cuong2() {
		super();
		
	}
	
	public Cuong2(String thongTinSinhVien) {
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
