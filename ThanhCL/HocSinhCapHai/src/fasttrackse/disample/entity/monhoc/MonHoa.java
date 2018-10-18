package fasttrackse.disample.entity.monhoc;

import fasttrackse.disample.entity.giangvien.CoSinh;
import fasttrackse.disample.entity.giangvien.GiangVien;

public class MonHoa implements MonHoc {
	String thongTinMonHoc = "Môn Hoá";
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
		return giangVien.thongTinGiangVien();
	}
	
}
