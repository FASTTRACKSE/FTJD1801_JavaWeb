package sampleproject.entity;

import java.io.Serializable;

public class SinhVien implements Serializable {
	private static final long serialVersionUID = 1L;

	private String hoTen;
	private int namSinh;
	private int ID;
	private String avatar;

	public SinhVien() {
		super();
	}

	public SinhVien(int id, String hoTen, int namSinh, String avatar) {
		super();
		this.ID = id;
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.avatar = avatar;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
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
}
