package hocsinh.entity;

import hocsinh.entity.antrua.AnTrua;
import hocsinh.entity.monhoc.MonHoc;
import hocsinh.entity.phuongtien.PhuongTien;

public class HocSinh {
	MonHoc monHoc;
	PhuongTien phuongTien;
	AnTrua anTrua;
	
	public MonHoc getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}

	public PhuongTien getPhuongTien() {
		return phuongTien;
	}

	public void setPhuongTien(PhuongTien phuongTien) {
		this.phuongTien = phuongTien;
	}

	public AnTrua getAnTrua() {
		return anTrua;
	}

	public void setAnTrua(AnTrua anTrua) {
		this.anTrua = anTrua;
	}
	


}
