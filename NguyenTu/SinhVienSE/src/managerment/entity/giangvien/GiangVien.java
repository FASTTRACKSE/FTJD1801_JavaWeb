package managerment.entity.giangvien;

public class GiangVien {

	public String hoTen;
	public String email;
	public GiangVien() {
		super();
	}
	public GiangVien(String hoTen, String email) {
		super();
		this.hoTen = hoTen;
		this.email = email;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
