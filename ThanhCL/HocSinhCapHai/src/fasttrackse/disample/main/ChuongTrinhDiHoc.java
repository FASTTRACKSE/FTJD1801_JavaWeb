package fasttrackse.disample.main;

import java.util.ArrayList;
import java.util.List;

import fasttrackse.disample.entity.*;
import fasttrackse.disample.entity.giangvien.*;
import fasttrackse.disample.entity.monhoc.*;
import fasttrackse.disample.entity.phuongtien.*;

public class ChuongTrinhDiHoc {

	public static void main(String[] args) {
//		HocSinh hocSinh = new HocSinh();
//		
//		System.out.println("Thứ 2, 3, 4: ");
//		System.out.println(" - Học: " + hocSinh.hocToan());
//		System.out.println("      : " + hocSinh.hocLy());
//		System.out.println("      : " + hocSinh.hocHoa());
//		System.out.println(" - Đi: " + hocSinh.diXeMay());
//
//		System.out.println("Thứ 6, 7: ");
//		System.out.println(" - Học: " + hocSinh.hocHoa());
//		System.out.println(" - Đi: " + hocSinh.diXeCon());
		
		HocSinh2 hocSinh2 = new HocSinh2();
		HocSinh2 hocSinh3 = new HocSinh2();
		
		//inject phương tiện ô tô con cho hocSinh2
		hocSinh2.setPhuongTien(new XeCon());
		hocSinh3.setPhuongTien(new XeDap());
		
		// inject MonTiengAnh cho đối tượng hocSinh2
		MonHoa monHoaLop9A = new MonHoa();
		MonHoa monHoaLop9B = new MonHoa();
		
		CoSinh coSinh = new CoSinh();
		CoDia coDia = new CoDia();
		ThayHinh thayHinh = new ThayHinh();
		ThayDien thayDien = new ThayDien();
		
		List<GiangVien> dsGiangVienHoa9A = new ArrayList<GiangVien>();
		dsGiangVienHoa9A.add(coSinh);
		dsGiangVienHoa9A.add(coDia);
		dsGiangVienHoa9A.add(thayDien);
		
		List<GiangVien> dsGiangVienHoa9B = new ArrayList<GiangVien>();
		dsGiangVienHoa9B.add(coSinh);
		dsGiangVienHoa9B.add(thayDien);

		List<GiangVien> dsGiangVienLy9A = new ArrayList<GiangVien>();
		dsGiangVienLy9A.add(thayDien);
		dsGiangVienLy9A.add(thayHinh);
		
		monHoaLop9A.setDsGiangVien(dsGiangVienHoa9A);
		monHoaLop9B.setDsGiangVien(dsGiangVienHoa9B);

		hocSinh2.setMonHoc(monHoaLop9A);
		hocSinh3.setMonHoc(monHoaLop9B);
		

		System.out.println("\n\nHọc sinh 2 - thế hệ 4.0:");
		System.out.println(" - Học: " + hocSinh2.getMonHoc().getThongTinMonHoc());
		System.out.println(" - Các thầy cô: ");
		for (GiangVien x : hocSinh2.getMonHoc().getDanhSachGiangVien()) {
			System.out.println("    + " + x.thongTinGiangVien());
		}
		System.out.println(" - Đi: " + hocSinh2.getPhuongTien().getThongTinPhuongTien());
		
		System.out.println("\n\nHọc sinh 3 - thế hệ 4.0:");
		System.out.println(" - Học: " + hocSinh3.getMonHoc().getThongTinMonHoc());
		System.out.println(" - Các thầy cô: ");
		
		for (GiangVien x : hocSinh3.getMonHoc().getDanhSachGiangVien()) {
			System.out.println("    + " + x.thongTinGiangVien());
		}
		
		System.out.println(" - Đi: " + hocSinh3.getPhuongTien().getThongTinPhuongTien());
		
	}

}
