package sinhvien.beans;

public class SinhVien {

	private String tenSv, email, diaChi, lop, image;
	private int id, namSinh;

	public SinhVien() {
		super();
	}

	public SinhVien(String tenSv, String email, String diaChi, String lop, String image, int id, int namSinh) {
		super();
		this.tenSv = tenSv;
		this.email = email;

		this.diaChi = diaChi;
		this.lop = lop;
		this.image = image;
		this.id = id;

		this.namSinh = namSinh;
	}

	public String getTenSv() {
		return tenSv;
	}

	public void setTenSv(String tenSv) {
		this.tenSv = tenSv;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

}
