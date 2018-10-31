package main;

import java.util.ArrayList;
import java.util.List;
import entity.GiangVien;
import entity.SinhVien;
import entity.MonHoc.LapTrinhCoBan;
import entity.MonHoc.LapTrinhFrontend;
import entity.MonHoc.LapTrinhJavaCoBan;
import entity.MonHoc.LapTrinhJavaWeb;
import entity.MonHoc.LapTrinhPHP;
import entity.MonHoc.MonHoc;
import entity.MonHoc.QuyTrinhDuAn;
import entity.MonHoc.TinHocVanPhong;
import entity.hedaotao.DaoTaoDaiHan;
import entity.hedaotao.DaoTaoJava;
import entity.hedaotao.DaoTaoPHP;
import entity.loaidaotao.DaoTaoOffline;
import entity.loaidaotao.DaoTaoOnline;

public class QLSinhVien {

	public static void main(String[] args) {
		
		DaoTaoDaiHan daiHan = new DaoTaoDaiHan();
		DaoTaoPHP php = new DaoTaoPHP();
		DaoTaoJava java = new DaoTaoJava();
		
		List<MonHoc> dsDaiHan = new ArrayList<MonHoc>();
		List<MonHoc> dsPHP = new ArrayList<MonHoc>();
		List<MonHoc> dsJava = new ArrayList<MonHoc>();
		
		
		List<GiangVien> gvLapTrinhCoBan = new ArrayList<GiangVien>();
		List<GiangVien> gvLapTrinhJavaCoBan = new ArrayList<GiangVien>();
		List<GiangVien> gvLapTrinhJavaWeb = new ArrayList<GiangVien>();
		List<GiangVien> gvLapTrinhWebFrontend = new ArrayList<GiangVien>();
		List<GiangVien> gvLapTrinhWebPHPMySQL = new ArrayList<GiangVien>();
		List<GiangVien> gvQuyTrinhDuAn = new ArrayList<GiangVien>();
		List<GiangVien> gvTinHocVanPhong = new ArrayList<GiangVien>();
		
		List<GiangVien> tgLapTrinhCoBan = new ArrayList<GiangVien>();
		List<GiangVien> tgLapTrinhJavaCoBan = new ArrayList<GiangVien>();
		List<GiangVien> tgLapTrinhJavaWeb = new ArrayList<GiangVien>();
		List<GiangVien> tgLapTrinhWebFrontend = new ArrayList<GiangVien>();
		List<GiangVien> tgLapTrinhWebPHPMySQL = new ArrayList<GiangVien>();
		List<GiangVien> tgQuyTrinhDuAn = new ArrayList<GiangVien>();
		List<GiangVien> tgTinHocVanPhong = new ArrayList<GiangVien>();
		
		GiangVien gv1= new GiangVien ("Cô Tin","tin@gmail.com");
		GiangVien gv2= new GiangVien ("Cô Trình","trinh@gmail.com");
		GiangVien gv3= new GiangVien ("Cô Java","java@gmail.com");
		GiangVien gv4= new GiangVien ("Thầy Web","web@gmail.com");
		GiangVien gv5= new GiangVien ("Thầy Php","php@gmail.com");
		GiangVien gv6= new GiangVien ("Cô Sinh","sinh@gmail.com");
		GiangVien gv7= new GiangVien ("Cô Minh","tin@gmail.com");
		
		LapTrinhCoBan lapTrinhCoBan = new LapTrinhCoBan();
		LapTrinhJavaCoBan lapTrinhJavaCoBan = new LapTrinhJavaCoBan();
		LapTrinhJavaWeb lapTrinhJavaWeb = new LapTrinhJavaWeb();
		LapTrinhFrontend lapTrinhFrontend = new LapTrinhFrontend();
		LapTrinhPHP lapTrinhPHP = new LapTrinhPHP();
		QuyTrinhDuAn quyTrinhDuAn = new QuyTrinhDuAn();
		TinHocVanPhong tinHocVanPhong = new TinHocVanPhong();
		
		

		gvLapTrinhCoBan.add(gv1);
		tgLapTrinhCoBan.add(gv4);
		
		gvLapTrinhJavaCoBan.add(gv3);
		tgLapTrinhJavaCoBan.add(gv4);
		
		gvLapTrinhJavaWeb.add(gv5);
		tgLapTrinhJavaWeb.add(gv2);
		
		tgLapTrinhWebFrontend.add(gv6);
		gvLapTrinhWebFrontend.add(gv3);
		
		tgLapTrinhWebPHPMySQL.add(gv7);
		gvLapTrinhWebPHPMySQL.add(gv3);
		
		tgTinHocVanPhong.add(gv2);
		gvTinHocVanPhong.add(gv3);
		
		gvLapTrinhWebPHPMySQL.add(gv7);
		tgLapTrinhWebPHPMySQL.add(gv5);
		 
		lapTrinhCoBan.setGiangvien(gvLapTrinhCoBan);
		lapTrinhJavaWeb.setGiangvien(gvLapTrinhJavaWeb);
		lapTrinhJavaCoBan.setGiangvien(gvLapTrinhJavaCoBan);
		lapTrinhFrontend.setGiangvien(gvLapTrinhWebFrontend);
		lapTrinhPHP.setGiangvien(gvLapTrinhWebPHPMySQL);
		quyTrinhDuAn.setGiangvien(gvQuyTrinhDuAn);
		tinHocVanPhong.setGiangvien(gvTinHocVanPhong);
		
		lapTrinhCoBan.setTrogiang(tgLapTrinhCoBan);
		lapTrinhJavaWeb.setTrogiang(tgLapTrinhJavaWeb);
		lapTrinhJavaCoBan.setTrogiang(tgLapTrinhJavaCoBan);
		lapTrinhFrontend.setTrogiang(tgLapTrinhWebFrontend);
		lapTrinhPHP.setTrogiang(tgLapTrinhWebPHPMySQL);
		quyTrinhDuAn.setTrogiang(tgQuyTrinhDuAn);
		tinHocVanPhong.setTrogiang(tgTinHocVanPhong);
		
	
		dsDaiHan.add( tinHocVanPhong);
		dsDaiHan.add(lapTrinhCoBan);
		dsDaiHan.add(lapTrinhJavaCoBan);
		dsDaiHan.add(lapTrinhJavaWeb);
	
		dsJava.add(lapTrinhCoBan);
		dsJava.add(lapTrinhJavaWeb);

		dsPHP.add(lapTrinhPHP);
		dsPHP.add(lapTrinhFrontend);
		
		
		
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
		for (MonHoc monhoc : sv1.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("		* Tên môn học: " + monhoc.getThongTinMonHoc());
			for (GiangVien giangvien : monhoc.getDanhSachGiangVien()) {
				System.out.println(
						"			> Giảng viên: " + giangvien.getHoTen() + "	-  Email: " + giangvien.getEmail());
			}
			if (monhoc.getDanhSachTroGiang() != null) {
				for (GiangVien trogiang : monhoc.getDanhSachTroGiang()) {
					System.out.println(
							"			>> Trợ Giảng: " + trogiang.getHoTen() + "	-  Email: " + trogiang.getEmail());
				} 
			}

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
		for (MonHoc monhoc : sv2.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("		* Tên môn học: " + monhoc.getThongTinMonHoc());
			for (GiangVien giangvien : monhoc.getDanhSachGiangVien()) {
				System.out.println(
						"			> Giảng viên: " + giangvien.getHoTen() + "	- Email: " + giangvien.getEmail());
			}
			if (monhoc.getDanhSachTroGiang() != null) {
				for (GiangVien trogiang : monhoc.getDanhSachTroGiang()) {
					System.out.println(
							"			>> Trợ Giảng: " + trogiang.getHoTen() + "	-  Email: " + trogiang.getEmail());
				} 
			}

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
		for (MonHoc monhoc : sv3.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("		* Tên môn học: " + monhoc.getThongTinMonHoc());
			for (GiangVien giangvien : monhoc.getDanhSachGiangVien()) {
				System.out.println(
						"			> Giảng viên: " + giangvien.getHoTen() + "	-  Email: " + giangvien.getEmail());
			}
			if (monhoc.getDanhSachTroGiang() != null) {
				for (GiangVien trogiang : monhoc.getDanhSachTroGiang()) {
					System.out.println(
							"			>> Trợ Giảng: " + trogiang.getHoTen() + "	-  Email: " + trogiang.getEmail());
				} 
			}

		}
	}

}
