package quanlysinhvien.entity;

public class SinhVien {
	private int id;
	private String hoTen;
	private int namSinh;
	private String email;
	private String gioiTinh;
	private String diaChi;
	private String lopHoc;
	private String anhThe;
	public SinhVien() {
		super();
	}

	public SinhVien(int id, String hoTen, int namSinh, String email, String gioiTinh, String diaChi, String lopHoc) {
		super();
		this.id = id;
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.email = email;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.lopHoc = lopHoc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getLopHoc() {
		return lopHoc;
	}

	public void setLopHoc(String lopHoc) {
		this.lopHoc = lopHoc;
	}

	public String getAnhThe() {
		return anhThe;
	}

	public void setAnhThe(String anhThe) {
		this.anhThe = anhThe;
	}
	
}
