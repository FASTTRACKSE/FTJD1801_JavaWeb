package sinhvien.main;

import sinhvien.entity.*;

public class ChuongTrinhHoc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HocSinh hocSinh = new HocSinh();
		System.out.println("Thứ 2, 3, 4");
		hocSinh.setMonHoc(new MonToan());
		System.out.println(
				" - Học: " + hocSinh.getMonHoc().getTenMonHoc() + " - Giáo viên: " + hocSinh.getMonHoc().getGiaoVien());
		hocSinh.setMonHoc(new MonAnh());
		System.out.println(
				"      : " + hocSinh.getMonHoc().getTenMonHoc() + " - Giáo viên: " + hocSinh.getMonHoc().getGiaoVien());
		hocSinh.setPhuongtien(new XeDap());
		System.out.println(" - Đi : " + hocSinh.getPhuongtien().getThongTinPhuongTien());
		hocSinh.setBuaTrua(new AnOPhongHoc());
		System.out.println(" - Thức ăn : " + hocSinh.getBuaTrua().getTenMonAn());
		System.out.println(" - Nơi ăn : " + hocSinh.getBuaTrua().getNoiAn());
		hocSinh.setDongPhuc(new TruyenThong());
		System.out.println(" - Thời trang : " + hocSinh.getDongPhuc().getDongPhuc());
	}
}
