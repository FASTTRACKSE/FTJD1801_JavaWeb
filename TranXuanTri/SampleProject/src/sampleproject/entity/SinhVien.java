package sampleproject.entity;

import java.io.Serializable;

public class SinhVien implements Serializable {
	private static final long serialVersionUID = 1L;

	private String hoTen;
	private int namSinh;
	private int ID;
	private String fileName;
	public SinhVien() {
		super();
	}

	public SinhVien(int id, String hoTen, int namSinh,String fileName) {
		super();
		this.ID = id;
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.fileName = fileName;
	}

	public int getId() {
		return ID;
	}

	public void setId(int id) {
		this.ID = id;
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
