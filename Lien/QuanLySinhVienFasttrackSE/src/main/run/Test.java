package main.run;

import java.util.ArrayList;
import java.util.List;

import entity.giangvien.CoFrontEnd;
import entity.giangvien.GiangVien;
import entity.giangvien.ThayJava;
import entity.giangvien.ThayPHP;
import entity.giangvien.ThayTin;
import entity.giangvien.ThayWeb;
import entity.hedaotao.DaoTaoDaiHan;
import entity.hedaotao.DaoTaoJava;
import entity.hedaotao.DaoTaoPHP;
import entity.loaidaotao.DaoTaoOffline;
import entity.loaidaotao.DaoTaoOnline;
import entity.monhoc.LapTrinhCoBan;
import entity.monhoc.LapTrinhJavaCoBan;
import entity.monhoc.LapTrinhJavaWeb;
import entity.monhoc.LapTrinhWebBackend;
import entity.monhoc.LapTrinhWebFrontend;
import entity.monhoc.MonHoc;
import entity.monhoc.QuyTrinhDuAn;
import entity.monhoc.TinHocVanPhong;
import entity.sinhvien.SinhVien;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DaoTaoDaiHan daihan = new DaoTaoDaiHan();
		DaoTaoJava java = new DaoTaoJava();
		DaoTaoPHP php = new DaoTaoPHP();

		LapTrinhCoBan lapTrinhCoBan = new LapTrinhCoBan();
		LapTrinhJavaCoBan lapTrinhJavaCoBan = new LapTrinhJavaCoBan();
		LapTrinhJavaWeb lapTrinhJavaWeb = new LapTrinhJavaWeb();
		LapTrinhWebFrontend lapTrinhFrontend = new LapTrinhWebFrontend();
		LapTrinhWebBackend lapTrinhBackend = new LapTrinhWebBackend();
		QuyTrinhDuAn quyTrinhDuAn = new QuyTrinhDuAn();
		TinHocVanPhong tinHocVanPhong = new TinHocVanPhong();

		List<MonHoc> listJava = new ArrayList<MonHoc>();
		List<MonHoc> listPHP = new ArrayList<MonHoc>();
		List<MonHoc> listALL = new ArrayList<MonHoc>();

		List<GiangVien> gvCoBan = new ArrayList<GiangVien>();
		List<GiangVien> gvJavaCoBan = new ArrayList<GiangVien>();
		List<GiangVien> gvJavaWeb = new ArrayList<GiangVien>();
		List<GiangVien> gvWebFrontend = new ArrayList<GiangVien>();
		List<GiangVien> gvWebBackend = new ArrayList<GiangVien>();
		List<GiangVien> gvQuyTrinhDuAn = new ArrayList<GiangVien>();
		List<GiangVien> gvTinHocVanPhong = new ArrayList<GiangVien>();

		gvCoBan.add(new ThayTin());

		gvJavaCoBan.add(new ThayJava());

		gvJavaWeb.add(new ThayJava());
		gvJavaWeb.add(new ThayWeb());

		gvWebFrontend.add(new CoFrontEnd());
		gvWebFrontend.add(new ThayPHP());
		gvWebFrontend.add(new ThayWeb());

		gvWebBackend.add(new ThayPHP());
		gvWebBackend.add(new ThayWeb());

		gvQuyTrinhDuAn.add(new ThayTin());

		gvTinHocVanPhong.add(new ThayTin());

		lapTrinhCoBan.setGiangvien(gvCoBan);
		lapTrinhJavaCoBan.setGiangvien(gvJavaCoBan);
		lapTrinhJavaWeb.setGiangvien(gvJavaWeb);
		lapTrinhFrontend.setGiangvien(gvWebFrontend);
		lapTrinhBackend.setGiangvien(gvWebBackend);
		quyTrinhDuAn.setGiangvien(gvQuyTrinhDuAn);
		tinHocVanPhong.setGiangvien(gvTinHocVanPhong);

		listJava.add(lapTrinhJavaCoBan);
		listJava.add(lapTrinhJavaWeb);

		listPHP.add(lapTrinhFrontend);
		listPHP.add(lapTrinhBackend);

		listALL.add(lapTrinhCoBan);
		listALL.add(lapTrinhBackend);
		listALL.add(lapTrinhFrontend);
		listALL.add(lapTrinhJavaWeb);
		listALL.add(tinHocVanPhong);
		listALL.add(quyTrinhDuAn);
		listALL.add(lapTrinhJavaCoBan);

		daihan.setMonhoc(listALL);
		java.setMonhoc(listJava);
		php.setMonhoc(listPHP);

		SinhVien sv1 = new SinhVien("Trần Tài Tiên", 1998, "Quảng Nam", "0334186925", "tien@gmail.com",
				new DaoTaoOffline(), java);
		SinhVien sv2 = new SinhVien("Trương Thị Mỹ Liên", 1998, "Quảng Nam", "0796982626", "lien@gmail.com",
				new DaoTaoOffline(), php);
		SinhVien sv3 = new SinhVien("CaoLeeThanh", 1928, "Đà Nẵng", "1241324214", "caoleethanh@hostmail.com",
				new DaoTaoOnline(), daihan);

		System.out.println(" Sinh viên thứ nhất: ");
		System.out.println("	> Họ và tên: " + sv2.getHoTen() + "	- Năm sinh: " + sv2.getNamSinh());
		System.out.println("	> Địa chỉ: " + sv2.getDiaChi());
		System.out.println("	> Số điện thoại: " + sv2.getDienThoai() + "	- Email: " + sv2.getEmail());

		System.out.println(" // Loại hình đào tạo: " + sv2.getLoaiDaoTao().getLoaiHinhDaoTao());
		System.out.println("	> Thông tin thời gian & địa chỉ: " + sv2.getLoaiDaoTao().getThongTinDaoTao());

		System.out.println(" // Hệ đào tạo: " + sv2.getHeDaoTao().getHeDaoTao());
		System.out.println("	> Thông tin thời gian học: " + sv2.getHeDaoTao().getThongTinThoiGianHoc());
		System.out.println("	> Thông tin môn học: ");
		for (MonHoc monhoc : sv2.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("		> Tên môn học: " + monhoc.getTenMonHoc());
			for (GiangVien giangvien : monhoc.getDanhSachGiangVien()) {
				System.out.println(
						"		> Giảng viên: " + giangvien.getHoTen() + "  		>  Email: " + giangvien.getEmail());
			}
		}
		System.out.println(
				"\n\n//-------------------------------------------------------------------------------------------//");
		System.out.println("\n\n Sinh viên thứ hai: ");
		System.out.println("	> Họ và tên: " + sv3.getHoTen() + "	- Năm sinh: " + sv3.getNamSinh());
		System.out.println("	> Địa chỉ: " + sv3.getDiaChi());
		System.out.println("	> Số điện thoại: " + sv3.getDienThoai() + "	- Email: " + sv3.getEmail());

		System.out.println(" // Loại hình đào tạo: " + sv3.getLoaiDaoTao().getLoaiHinhDaoTao());
		System.out.println("	> Thông tin thời gian & địa chỉ: " + sv3.getLoaiDaoTao().getThongTinDaoTao());

		System.out.println(" // Hệ đào tạo: " + sv3.getHeDaoTao().getHeDaoTao());
		System.out.println("	> Thông tin thời gian học: " + sv3.getHeDaoTao().getThongTinThoiGianHoc());
		System.out.println("	> Thông tin môn học: ");
		for (MonHoc monhoc : sv3.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("		> Tên môn học: " + monhoc.getTenMonHoc());
			for (GiangVien giangvien : monhoc.getDanhSachGiangVien()) {
				System.out.println(
						"		> Giảng viên: " + giangvien.getHoTen() + "  		>  Email: " + giangvien.getEmail());
			}
		}

		System.out.println(
				"\n\n//-------------------------------------------------------------------------------------------//");
		System.out.println("\n\n Sinh viên thứ ba: ");
		System.out.println("	> Họ và tên: " + sv1.getHoTen() + "	- Năm sinh: " + sv1.getNamSinh());
		System.out.println("	> Địa chỉ: " + sv1.getDiaChi());
		System.out.println("	> Số điện thoại: " + sv1.getDienThoai() + "	- Email: " + sv1.getEmail());

		System.out.println(" // Loại hình đào tạo: " + sv1.getLoaiDaoTao().getLoaiHinhDaoTao());
		System.out.println("	> Thông tin thời gian & địa chỉ: " + sv1.getLoaiDaoTao().getThongTinDaoTao());

		System.out.println(" // Hệ đào tạo: " + sv1.getHeDaoTao().getHeDaoTao());
		System.out.println("	> Thông tin thời gian học: " + sv1.getHeDaoTao().getThongTinThoiGianHoc());
		System.out.println("	> Thông tin môn học: ");
		for (MonHoc monhoc : sv1.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("		> Tên môn học: " + monhoc.getTenMonHoc());
			for (GiangVien giangvien : monhoc.getDanhSachGiangVien()) {
				System.out.println(
						"		> Giảng viên: " + giangvien.getHoTen() + "  		>  Email: " + giangvien.getEmail());
			}
		}

	}

}
