package object;

public class SinhVien {
	private String hoTen;
	private int namSinh;
	private int iD;
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public int getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public SinhVien() {
		super();
	}
	public SinhVien(String hoTen, int namSinh, int iD) {
		super();
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.iD = iD;
	}

	


	
	

	
	
	
}
