package hocsinh.entity.monhoc;

import hocsinh.entity.giangvien.GiangVien;

public class MonHoa implements MonHoc {
	String thongTinMonHoc = "Môn Hóa";
	GiangVien giangVien;

	public MonHoa() {

	}

	public MonHoa(GiangVien giangVien) {
		this.giangVien = giangVien;
	}

	public String getThongTinMonHoc() {
		return thongTinMonHoc;
	}

	public void setThongTinMonHoc(String thongTinMonHoc) {
		this.thongTinMonHoc = thongTinMonHoc;
	}

	public GiangVien getGiangVien() {
		return giangVien;
	}

	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}

	@Override
	public String getThongTinGiangVien() {
		// TODO Auto-generated method stub
		return giangVien.getThongTinGiangVien();
	}

}
