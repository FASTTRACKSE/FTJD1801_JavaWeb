package springmvc.student.entity;

public class Student {
	private int maSV;
	private String tenSV;
	private int namSinh;
	private String Avatar;

	public Student() {
		super();
	}

	public Student(int maSV, String tenSV, int namSinh, String avatar) {
		super();
		this.maSV = maSV;
		this.tenSV = tenSV;
		this.namSinh = namSinh;
		Avatar = avatar;
	}

	public int getMaSV() {
		return maSV;
	}

	public void setMaSV(int maSV) {
		this.maSV = maSV;
	}

	public String getTenSV() {
		return tenSV;
	}

	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public String getAvatar() {
		return Avatar;
	}

	public void setAvatar(String avatar) {
		Avatar = avatar;
	}

}
