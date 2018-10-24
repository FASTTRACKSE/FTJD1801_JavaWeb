package sinhvien.entity;

import java.io.Serializable;

public class SinhVien implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String hoTen;
	private int namSinh;
	private int iD;
	private String avatar;
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
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public SinhVien() {
		super();
	}
	

	public SinhVien(String hoTen, int namSinh, int iD, String avatar) {
		super();
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.iD = iD;
		this.avatar = avatar;
	}


	
	

	
	
	
}
