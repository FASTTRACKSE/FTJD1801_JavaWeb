package model;

import java.io.Serializable;

public class SinhVien2 implements Serializable  {
	
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
	public SinhVien2() {
		super();
	}
	public SinhVien2(String hoTen, int namSinh, int iD) {
		super();
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.iD = iD;
	}

	


	
	

	
	
	
}
