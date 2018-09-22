package fasttrackse.demoproject1.entity;

import java.io.Serializable;

public class SinhVien implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int ID;
	private String hoTen;
	private int namSinh;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
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
	
	public SinhVien() {
		super();
	}
	public SinhVien(int ID, String hoTen, int namSinh) {
		super();
		this.ID = ID;
		this.hoTen = hoTen;
		this.namSinh = namSinh;
	}	
}
