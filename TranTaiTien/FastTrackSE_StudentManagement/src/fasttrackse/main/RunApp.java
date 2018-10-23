package fasttrackse.main;

import java.util.ArrayList;
import java.util.List;

import fasttrackse.entity.chuongtrinhdaotao.DaoTaoCapTocJava;
import fasttrackse.entity.chuongtrinhdaotao.DaoTaoCapTocPHP;
import fasttrackse.entity.chuongtrinhdaotao.DaoTaoDaiHan;
import fasttrackse.entity.chuongtrinhdaotao.DaoTaoOffline;
import fasttrackse.entity.chuongtrinhdaotao.DaoTaoOnline;
import fasttrackse.entity.giangvien.CoAnh;
import fasttrackse.entity.giangvien.CoSinh;
import fasttrackse.entity.giangvien.CoVan;
import fasttrackse.entity.giangvien.GiangVien;
import fasttrackse.entity.giangvien.ThayThanh;
import fasttrackse.entity.giangvien.ThayToan;
import fasttrackse.entity.monhoc.LapTrinhCoBan;
import fasttrackse.entity.monhoc.LapTrinhJavaCoBan;
import fasttrackse.entity.monhoc.LapTrinhJavaWeb;
import fasttrackse.entity.monhoc.LapTrinhWebFrontend;
import fasttrackse.entity.monhoc.LapTrinhWebPHP_MySQL;
import fasttrackse.entity.monhoc.MonHoc;
import fasttrackse.entity.monhoc.QuyTrinhDuAn;
import fasttrackse.entity.monhoc.TinHocVanPhong;
import fasttrackse.entity.sinhvien.SinhVien;

public class RunApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DaoTaoCapTocPHP php = new DaoTaoCapTocPHP();
		DaoTaoCapTocJava java = new DaoTaoCapTocJava();
		DaoTaoDaiHan allExams = new DaoTaoDaiHan();

		// -------------------------------------------------//

		LapTrinhCoBan lapTrinhCoBan = new LapTrinhCoBan();
		LapTrinhJavaCoBan lapTrinhJavaCoBan = new LapTrinhJavaCoBan();
		LapTrinhJavaWeb lapTrinhJavaWeb = new LapTrinhJavaWeb();
		LapTrinhWebFrontend lapTrinhFrontend = new LapTrinhWebFrontend();
		LapTrinhWebPHP_MySQL lapTrinhPHP = new LapTrinhWebPHP_MySQL();
		QuyTrinhDuAn quyTrinhDuAn = new QuyTrinhDuAn();
		TinHocVanPhong tinHocVanPhong = new TinHocVanPhong();

		// -------------------------------------------------//

		List<MonHoc> dsJava = new ArrayList<MonHoc>();
		List<MonHoc> dsPHP = new ArrayList<MonHoc>();
		List<MonHoc> dsAllExams = new ArrayList<MonHoc>();

		// -------------------------------------------------//

		List<GiangVien> gvLapTrinhCoBan = new ArrayList<GiangVien>();
		List<GiangVien> gvLapTrinhJavaCoBan = new ArrayList<GiangVien>();
		List<GiangVien> gvLapTrinhJavaWeb = new ArrayList<GiangVien>();
		List<GiangVien> gvLapTrinhWebFrontend = new ArrayList<GiangVien>();
		List<GiangVien> gvLapTrinhWebPHP_MySQL = new ArrayList<GiangVien>();
		List<GiangVien> gvQuyTrinhDuAn = new ArrayList<GiangVien>();
		List<GiangVien> gvTinHocVanPhong = new ArrayList<GiangVien>();

		// -------------------------------------------------//

		gvLapTrinhCoBan.add(new CoAnh());
		gvLapTrinhCoBan.add(new CoVan());

		gvLapTrinhJavaCoBan.add(new ThayToan());
		gvLapTrinhJavaCoBan.add(new CoVan());

		gvLapTrinhJavaWeb.add(new ThayThanh());

		gvLapTrinhWebFrontend.add(new CoSinh());
		gvLapTrinhWebFrontend.add(new CoVan());
		gvLapTrinhWebFrontend.add(new ThayToan());

		gvLapTrinhWebPHP_MySQL.add(new ThayThanh());

		gvQuyTrinhDuAn.add(new CoVan());

		gvTinHocVanPhong.add(new CoSinh());

		// -------------------------------------------------//

		lapTrinhCoBan.setGiangvien(gvLapTrinhCoBan);
		lapTrinhJavaWeb.setGiangvien(gvLapTrinhJavaWeb);
		lapTrinhJavaCoBan.setGiangvien(gvLapTrinhJavaCoBan);
		lapTrinhFrontend.setGiangvien(gvLapTrinhWebFrontend);
		lapTrinhPHP.setGiangvien(gvLapTrinhWebPHP_MySQL);
		quyTrinhDuAn.setGiangvien(gvQuyTrinhDuAn);
		tinHocVanPhong.setGiangvien(gvTinHocVanPhong);

		// -------------------------------------------------//

		dsJava.add(lapTrinhJavaCoBan);
		dsJava.add(lapTrinhJavaWeb);

		dsPHP.add(lapTrinhFrontend);
		dsPHP.add(lapTrinhPHP);

		dsAllExams.add(lapTrinhCoBan);
		dsAllExams.add(lapTrinhJavaCoBan);
		dsAllExams.add(lapTrinhJavaWeb);
		dsAllExams.add(lapTrinhFrontend);
		dsAllExams.add(lapTrinhPHP);
		dsAllExams.add(quyTrinhDuAn);
		dsAllExams.add(tinHocVanPhong);

		// -------------------------------------------------//

		java.setMonhoc(dsJava);
		php.setMonhoc(dsPHP);
		allExams.setMonhoc(dsAllExams);

		// -------------------------------------------------//

		SinhVien tien = new SinhVien("Trần Tài Tiên", 1998, "Quảng Nam", "0334186925", "trantaitien98@gmail.com",
				new DaoTaoOffline(), java);
		SinhVien lien = new SinhVien("Trương Thị Mỹ Liên", 1998, "Quảng Nam", "0796982626",
				"truonglien.071298@gmail.com", new DaoTaoOffline(), allExams);
		SinhVien tu = new SinhVien("Nguyễn Văn Tú", 1998, "Quảng Nam", "0123216988", "tuxl@gmail.com",
				new DaoTaoOnline(), php);

		System.out.println(" * Thông tin cơ bản: ");
		System.out.println("	- Họ và tên: " + tien.getHoTen());
		System.out.println("	- Năm sinh: " + tien.getNamSinh());
		System.out.println("	- Địa chỉ: " + tien.getDiaChi());
		System.out.println("	- Số điện thoại: " + tien.getDienThoai());
		System.out.println("	- Email: " + tien.getEmail());

		System.out.println(" * Loại hình đào tạo: " + tien.getLoaiDaoTao().getLoaiHinhDaoTao());
		System.out.println("	- Thời gian: " + tien.getLoaiDaoTao().getThoiGian());
		System.out.println("	- Địa chỉ: " + tien.getLoaiDaoTao().getDiaChi());

		System.out.println(" * Hệ đào tạo: " + tien.getHeDaoTao().getHeDaoTao());
		System.out.println("	- Thông tin thời gian học: " + tien.getHeDaoTao().getThongTinThoiGianHoc());
		System.out.println("	- Thông tin môn học: ");
		for (MonHoc monhoc : tien.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("		+ Tên môn học: " + monhoc.getTenMonHoc());
			for (GiangVien giangvien : monhoc.getDanhSachGiangVien()) {
				System.out
						.println("		+ Giảng viên: " + giangvien.getHoTen() + "  |  Email: " + giangvien.getEmail());
			}
		}
		
		
		System.out.println(" * Thông tin cơ bản: ");
		System.out.println("	- Họ và tên: " + lien.getHoTen());
		System.out.println("	- Năm sinh: " + lien.getNamSinh());
		System.out.println("	- Địa chỉ: " + lien.getDiaChi());
		System.out.println("	- Số điện thoại: " + lien.getDienThoai());
		System.out.println("	- Email: " + lien.getEmail());

		System.out.println(" * Loại hình đào tạo: " + lien.getLoaiDaoTao().getLoaiHinhDaoTao());
		System.out.println("	- Thời gian: " + lien.getLoaiDaoTao().getThoiGian());
		System.out.println("	- Địa chỉ: " + lien.getLoaiDaoTao().getDiaChi());

		System.out.println(" * Hệ đào tạo: " + lien.getHeDaoTao().getHeDaoTao());
		System.out.println("	- Thông tin thời gian học: " + lien.getHeDaoTao().getThongTinThoiGianHoc());
		System.out.println("	- Thông tin môn học: ");
		for (MonHoc monhoc : lien.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("		+ Tên môn học: " + monhoc.getTenMonHoc());
			for (GiangVien giangvien : monhoc.getDanhSachGiangVien()) {
				System.out
						.println("		+ Giảng viên: " + giangvien.getHoTen() + "  |  Email: " + giangvien.getEmail());
			}
		}

		System.out.println(" * Thông tin cơ bản: ");
		System.out.println("	- Họ và tên: " + tu.getHoTen());
		System.out.println("	- Năm sinh: " + tu.getNamSinh());
		System.out.println("	- Địa chỉ: " + tu.getDiaChi());
		System.out.println("	- Số điện thoại: " + tu.getDienThoai());
		System.out.println("	- Email: " + tu.getEmail());

		System.out.println(" * Loại hình đào tạo: " + tu.getLoaiDaoTao().getLoaiHinhDaoTao());
		System.out.println("	- Thời gian: " + tu.getLoaiDaoTao().getThoiGian());
		System.out.println("	- Địa chỉ: " + tu.getLoaiDaoTao().getDiaChi());

		System.out.println(" * Hệ đào tạo: " + tu.getHeDaoTao().getHeDaoTao());
		System.out.println("	- Thông tin thời gian học: " + tu.getHeDaoTao().getThongTinThoiGianHoc());
		System.out.println("	- Thông tin môn học: ");
		for (MonHoc monhoc : tu.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("		+ Tên môn học: " + monhoc.getTenMonHoc());
			for (GiangVien giangvien : monhoc.getDanhSachGiangVien()) {
				System.out
						.println("		+ Giảng viên: " + giangvien.getHoTen() + "  |  Email: " + giangvien.getEmail());
			}
		}

		
	}

}
