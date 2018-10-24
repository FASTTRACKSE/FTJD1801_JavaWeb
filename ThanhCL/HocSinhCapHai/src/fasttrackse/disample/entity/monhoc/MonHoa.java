package fasttrackse.disample.entity.monhoc;

import java.util.List;

import fasttrackse.disample.entity.giangvien.GiangVien;

public class MonHoa implements MonHoc {
	String thongTinMonHoc = "Môn Hoá";
	GiangVien giangVien;
	List<GiangVien> dsGiangVien;

	public List<GiangVien> getDsGiangVien() {
		return dsGiangVien;
	}

	public void setDsGiangVien(List<GiangVien> dsGiangVien) {
		this.dsGiangVien = dsGiangVien;
	}

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

	@Override
	public List<GiangVien> getDanhSachGiangVien() {
		return dsGiangVien;
	}
	
}
