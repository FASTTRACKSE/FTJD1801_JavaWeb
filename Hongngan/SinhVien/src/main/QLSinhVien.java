package main;

import java.util.ArrayList;
import java.util.List;

import entity.CoTin;
import entity.CoTrinh;
import entity.DaoTaoDaiHan;
import entity.DaoTaoJava;
import entity.DaoTaoOffline;
import entity.DaoTaoOnline;
import entity.DaoTaoPHP;
import entity.LapTrinhCoBan;
import entity.LapTrinhFrontend;
import entity.LapTrinhJavaCoBan;
import entity.LapTrinhJavaWeb;
import entity.LapTrinhPHP;
import entity.MonHoc;
import entity.SinhVien;
import entity.ThayJava;
import entity.ThayWeb;
import entity.TinHocVanPhong;

public class QLSinhVien {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		List<MonHoc> dsDaiHan = new ArrayList<MonHoc>();
		dsDaiHan.add(new TinHocVanPhong(new CoTin()));
		dsDaiHan.add(new LapTrinhCoBan(new CoTrinh()));
		dsDaiHan.add(new LapTrinhJavaCoBan(new ThayJava()));
		dsDaiHan.add(new LapTrinhJavaWeb(new ThayWeb()));
		
		List<MonHoc> dsJava = new ArrayList<MonHoc>();
		dsJava.add(new LapTrinhJavaCoBan(new ThayJava()));
		dsJava.add(new LapTrinhJavaWeb(new ThayJava()));
		
		List<MonHoc> dsPHP = new ArrayList<MonHoc>();
		dsPHP.add(new LapTrinhFrontend(new CoTin()));
		dsPHP.add(new LapTrinhPHP(new CoTrinh()));
		
		DaoTaoDaiHan daiHan = new DaoTaoDaiHan();
		DaoTaoPHP php = new DaoTaoPHP();
		DaoTaoJava java = new DaoTaoJava();
		
		php.setDsMonHoc(dsPHP);
		java.setDsMonHoc(dsJava);
		daiHan.setDsMonHoc(dsDaiHan);
		
		SinhVien sv1 = new SinhVien("Ngân", 1991, "Đà Nẵng", "09056789", "ngan@gmail.com", new DaoTaoOnline(), java);
		SinhVien sv2 = new SinhVien("Yên", 1992, "Đà Nẵng", "09021234", "yen@gmail.com", new DaoTaoOnline(), php);
		SinhVien sv3 = new SinhVien("Tuấn", 1993, "Huế", "09034567", "tuan@gmail.com", new DaoTaoOffline(), daiHan);
		
		System.out.println(" Thông tin sinh viên: ");
		System.out.println("	- Họ và tên: " + sv1.getHoTen());
		System.out.println("	- Năm sinh: " + sv1.getNamSinh());
		System.out.println("	- Địa chỉ: " + sv1.getDiaChi());
		System.out.println("	- Số điện thoại: " + sv1.getDienThoai());
		System.out.println("	- Email: " + sv1.getEmail());
		System.out.println(" Loại hình đào tạo: " + sv1.getLoaiDaoTao().getThongTinLoaiDaoTao());
		System.out.println(" Hệ đào tạo: " + sv1.getHeDaoTao().getThongTinHeDaoTao());
		System.out.println("	-Thời gian học: " + sv1.getHeDaoTao().getThongTinThoiGianHoc());
		System.out.println(" Môn học: ");
		for (MonHoc monHoc : sv1.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("	- " + monHoc.getThongTinMonHoc() + " | Giảng viên: " + monHoc.getThongTinGiangVien());
		}
		
		System.out.println(" --------------------------------------------------------------------------------------------- ");
		System.out.println(" Thông tin sinh viên: ");
		System.out.println("	- Họ và tên: " + sv2.getHoTen());
		System.out.println("	- Năm sinh: " + sv2.getNamSinh());
		System.out.println("	- Địa chỉ: " + sv2.getDiaChi());
		System.out.println("	- Số điện thoại: " + sv2.getDienThoai());
		System.out.println("	- Email: " + sv2.getEmail());
		System.out.println(" Loại hình đào tạo: " + sv2.getLoaiDaoTao().getThongTinLoaiDaoTao());
		System.out.println(" Hệ đào tạo: " + sv2.getHeDaoTao().getThongTinHeDaoTao());
		System.out.println("	-Thời gian học: " + sv2.getHeDaoTao().getThongTinThoiGianHoc());
		System.out.println(" Môn học: ");
		for (MonHoc monHoc : sv2.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("	- " + monHoc.getThongTinMonHoc() + " | Giảng viên: " + monHoc.getThongTinGiangVien());
		}
		
		System.out.println(" --------------------------------------------------------------------------------------------- ");
		System.out.println(" Thông tin sinh viên: ");
		System.out.println("	- Họ và tên: " + sv3.getHoTen());
		System.out.println("	- Năm sinh: " + sv3.getNamSinh());
		System.out.println("	- Địa chỉ: " + sv3.getDiaChi());
		System.out.println("	- Số điện thoại: " + sv3.getDienThoai());
		System.out.println("	- Email: " + sv3.getEmail());
		System.out.println(" Loại hình đào tạo: " + sv3.getLoaiDaoTao().getThongTinLoaiDaoTao());
		System.out.println(" Hệ đào tạo: " + sv3.getHeDaoTao().getThongTinHeDaoTao());
		System.out.println("	-Thời gian học: " + sv3.getHeDaoTao().getThongTinThoiGianHoc());
		System.out.println(" Môn học: ");
		for (MonHoc monHoc : sv3.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("	- " + monHoc.getThongTinMonHoc() + " | Giảng viên: " + monHoc.getThongTinGiangVien());
		}

	}
	

}
