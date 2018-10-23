package fasttrackse.entity.monhoc;

import java.util.List;

import fasttrackse.entity.giangvien.GiangVien;

public class LapTrinhWebPHP_MySQL implements MonHoc{
	List<GiangVien> giangvien;

	public List<GiangVien> getGiangvien() {
		return giangvien;
	}

	public void setGiangvien(List<GiangVien> giangvien) {
		this.giangvien = giangvien;
	}

	@Override
	public String getTenMonHoc() {
		// TODO Auto-generated method stub
		return "Lập trình web PHP & MySQL";
	}

	@Override
	public List<GiangVien> getDanhSachGiangVien() {
		// TODO Auto-generated method stub
		return giangvien;
	}

	
}
