package quanlysinhvien.main;

import java.util.ArrayList;
import java.util.List;
import quanlysinhvien.entity.giangvien.*;
import quanlysinhvien.entity.hedaotao.*;
import quanlysinhvien.entity.loaihinhdaotao.*;
import quanlysinhvien.entity.monhoc.*;
import quanlysinhvien.entity.sinhvien.SinhVien;

public class QuanLySinhVien {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GiangVien coSinh = new GiangVien("Cô Sinh", "123@mail.com");
		GiangVien thayJava = new GiangVien("Thầy Java", "thayjava@mail.com");
		GiangVien thayPHP = new GiangVien("Thầy PHP", "thayphp@mail.com");
		GiangVien thayFrontend = new GiangVien("Thầy Frontend", "thayfrontend@mail.com");
		GiangVien coDuAn = new GiangVien("Cô Dự Án", "coduan@mail.com");
		GiangVien coCoBan = new GiangVien("Cô Cơ Bản", "cocoban@mail.com");
		
		DaoTaoJava java = new DaoTaoJava();
		DaoTaoPHP php = new DaoTaoPHP();
		DaoTaoDaiHan daiHan = new DaoTaoDaiHan();
		

		List<GiangVien> dsTroGiangJava = new ArrayList<GiangVien>();
		dsTroGiangJava.add(thayPHP);
		dsTroGiangJava.add(coSinh);
		
		List<MonHoc> dsMonHocJava = new ArrayList<MonHoc>();
		dsMonHocJava.add(new LapTrinhJavaCoBan(thayJava));
		dsMonHocJava.add(new LapTrinhJavaWeb(thayJava,dsTroGiangJava));
		
		List<GiangVien> dsTroGiangPHP = new ArrayList<GiangVien>();
		dsTroGiangPHP.add(thayJava);
		
		List<MonHoc> dsMonHocPHP = new ArrayList<MonHoc>();
		dsMonHocPHP.add(new LapTrinhFrontend(thayFrontend,dsTroGiangPHP));
		dsMonHocPHP.add(new LapTrinhPHP(thayPHP,dsTroGiangPHP));
		
		List<MonHoc> dsMonHocDaiHan = new ArrayList<MonHoc>();
		dsMonHocDaiHan.add(new TinHocVanPhong(coCoBan));
		dsMonHocDaiHan.add(new LapTrinhCoBan(coCoBan));
		dsMonHocDaiHan.add(new LapTrinhFrontend(thayFrontend));
		dsMonHocDaiHan.add(new LapTrinhPHP(thayPHP,dsTroGiangPHP));
		dsMonHocDaiHan.add(new LapTrinhJavaCoBan(thayJava,dsTroGiangJava));
		dsMonHocDaiHan.add(new LapTrinhJavaWeb(thayJava,dsTroGiangJava));
		dsMonHocDaiHan.add(new QuyTrinhDuAn(coDuAn));

		php.setDsMonHoc(dsMonHocPHP);
		java.setDsMonHoc(dsMonHocJava);
		daiHan.setDsMonHoc(dsMonHocDaiHan);

		SinhVien sinhVien1 = new SinhVien("Trí", 1997, "a", "0123", "@", new DaoTaoOnline(), java);
		SinhVien sinhVien2 = new SinhVien("Trí 2", 1999, "b", "1234", "@gmail.com", new DaoTaoOnline(), php);
		SinhVien sinhVien3 = new SinhVien("Trí 3", 1990, "c", "12345", "@gmail.com", new DaoTaoOffline(), daiHan);

		System.out.println("		----Thông tin sinh viên-----");
		System.out.println("Thông tin cơ bản sinh viên:");
		System.out.println("	Họ tên:" + sinhVien1.getHoTen());
		System.out.println("	Năm sinh: " + sinhVien1.getNamSinh());
		System.out.println("	Địa chỉ: " + sinhVien1.getDiaChi());
		System.out.println("	Điện thoại: " + sinhVien1.getDienThoai());
		System.out.println("	Email: " + sinhVien1.getEmail());
		System.out.println("Loại hình đào tạo: ");
		System.out.println("	" + sinhVien1.getLoaiDaoTao().getThongTinLoaiDaoTao());
		System.out.println("	Thời gian:" + sinhVien1.getLoaiDaoTao().getGioHoc());
		System.out.println("	Địa điểm:" + sinhVien1.getLoaiDaoTao().getDiaDiem());
		System.out.println("Hệ đào tạo: " + sinhVien1.getHeDaoTao().getThongTinHeDaoTao());
		System.out.println("	" + sinhVien1.getHeDaoTao().getThongTinHeDaoTao());
		System.out.println("	Thời gian học:" + sinhVien1.getHeDaoTao().getThongTinThoiGianHoc());
		System.out.println("Môn học: ");
		for (MonHoc monHoc : sinhVien1.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("	" + monHoc.getThongTinMonHoc());
			System.out.println("		Giảng viên: " + monHoc.getThongTinGiangVien());
			if (monHoc.getDanhSachTroGiang() != null) {
				for (GiangVien troGiang : monHoc.getDanhSachTroGiang()) {
					System.out.println("		Trợ giảng: " + troGiang.getHoTen() + " || Email: " + troGiang.getEmail());
				}
			}
		}

		System.out.println();
		System.out.println("		----Thông tin sinh viên-----");
		System.out.println("Thông tin cơ bản sinh viên:");
		System.out.println("	Họ tên:" + sinhVien2.getHoTen());
		System.out.println("	Năm sinh: " + sinhVien2.getNamSinh());
		System.out.println("	Địa chỉ: " + sinhVien2.getDiaChi());
		System.out.println("	Điện thoại: " + sinhVien2.getDienThoai());
		System.out.println("	Email: " + sinhVien2.getEmail());
		System.out.println("Loại hình đào tạo: ");
		System.out.println("	" + sinhVien2.getLoaiDaoTao().getThongTinLoaiDaoTao());
		System.out.println("	Thời gian:" + sinhVien2.getLoaiDaoTao().getGioHoc());
		System.out.println("	Địa điểm:" + sinhVien2.getLoaiDaoTao().getDiaDiem());
		System.out.println("Hệ đào tạo: " + sinhVien2.getHeDaoTao().getThongTinHeDaoTao());
		System.out.println("	" + sinhVien2.getHeDaoTao().getThongTinHeDaoTao());
		System.out.println("	Thời gian học:" + sinhVien2.getHeDaoTao().getThongTinThoiGianHoc());
		System.out.println("Môn học: ");
		for (MonHoc monHoc : sinhVien2.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("	" + monHoc.getThongTinMonHoc());
			System.out.println("		Giảng viên: " + monHoc.getThongTinGiangVien());
			if (monHoc.getDanhSachTroGiang() != null) {
				for (GiangVien troGiang : monHoc.getDanhSachTroGiang()) {
					System.out.println("		Trợ giảng: " + troGiang.getHoTen() + " || Email: " + troGiang.getEmail());
				}
			}
		}

		System.out.println();
		System.out.println("		----Thông tin sinh viên-----");
		System.out.println("Thông tin cơ bản sinh viên:");
		System.out.println("	Họ tên:" + sinhVien3.getHoTen());
		System.out.println("	Năm sinh: " + sinhVien3.getNamSinh());
		System.out.println("	Địa chỉ: " + sinhVien3.getDiaChi());
		System.out.println("	Điện thoại: " + sinhVien3.getDienThoai());
		System.out.println("	Email: " + sinhVien3.getEmail());
		System.out.println("Loại hình đào tạo: ");
		System.out.println("	" + sinhVien3.getLoaiDaoTao().getThongTinLoaiDaoTao());
		System.out.println("	Thời gian:" + sinhVien3.getLoaiDaoTao().getGioHoc());
		System.out.println("	Địa điểm:" + sinhVien3.getLoaiDaoTao().getDiaDiem());
		System.out.println("Hệ đào tạo: " + sinhVien3.getHeDaoTao().getThongTinHeDaoTao());
		System.out.println("	" + sinhVien3.getHeDaoTao().getThongTinHeDaoTao());
		System.out.println("	Thời gian học:" + sinhVien3.getHeDaoTao().getThongTinThoiGianHoc());
		System.out.println("Môn học: ");
		for (MonHoc monHoc : sinhVien3.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("	" + monHoc.getThongTinMonHoc());
			System.out.println("		Giảng viên: " + monHoc.getThongTinGiangVien());
			if (monHoc.getDanhSachTroGiang() != null) {
				for (GiangVien troGiang : monHoc.getDanhSachTroGiang()) {
					System.out.println("		Trợ giảng: " + troGiang.getHoTen() + " || Email: " + troGiang.getEmail());
				}
			}
		}
	}
}
