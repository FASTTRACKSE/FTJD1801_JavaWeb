package entity.thongtinsinhvien;

public class Cuong3 implements ThongTinSinhVien{
	String thongTinSinhVien = "Cuong3, 1995, K54/24 Truong Chinh, 0976821865, cuong@gmail.com";

	public Cuong3() {
		super();
		
	}
	
	public Cuong3(String thongTinSinhVien) {
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
