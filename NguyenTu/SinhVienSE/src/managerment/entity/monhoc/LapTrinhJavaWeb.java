package managerment.entity.monhoc;

import java.util.ArrayList;
import java.util.List;

import managerment.entity.giangvien.*;

public class LapTrinhJavaWeb implements MonHoc {

	List<GiangVien> giangVien = new ArrayList<GiangVien>();
	List<GiangVien> troGiang = new ArrayList<GiangVien>();
	
	@Override
	public String getTenMonHoc() {
		// TODO Auto-generated method stub
		return "Lập trình Java Web";
	}

	@Override
	public List<GiangVien> getDanhSachGiangVien() {
		// TODO Auto-generated method stub
		return giangVien;
	}

	@Override
	public List<GiangVien> getDanhSachTroGiang() {
		// TODO Auto-generated method stub
		return troGiang;
	}

	public List<GiangVien> getGiangVien() {
		return giangVien;
	}

	public void setGiangVien(List<GiangVien> giangVien) {
		this.giangVien = giangVien;
	}

	public List<GiangVien> getTroGiang() {
		return troGiang;
	}

	public void setTroGiang(List<GiangVien> troGiang) {
		this.troGiang = troGiang;
	}
	

	
}
