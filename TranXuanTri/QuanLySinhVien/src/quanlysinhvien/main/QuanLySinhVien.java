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
		DaoTaoJava java = new DaoTaoJava();
		DaoTaoPHP php = new DaoTaoPHP();
		DaoTaoDaiHan daiHan = new DaoTaoDaiHan();
		List<MonHoc> dsMonHocJava = new ArrayList<MonHoc>();
		List<MonHoc> dsMonHocPHP = new ArrayList<MonHoc>();
		List<MonHoc> dsMonHocDaiHan = new ArrayList<MonHoc>();
		dsMonHocJava.add(new LapTrinhJavaCoBan(new CoSinh()));
		dsMonHocJava.add(new LapTrinhJavaWeb(new ThayJava()));
		dsMonHocPHP.add(new LapTrinhFrontend(new ThayPHP()));
		dsMonHocPHP.add(new LapTrinhPHP(new ThayPHP()));
		php.setDsMonHoc(dsMonHocPHP);
		java.setDsMonHoc(dsMonHocJava);
		SinhVien sinhVien1 = new SinhVien("Trí", 1997, "a", "0123", "@", new DaoTaoOnline(), java);
		SinhVien sinhVien2 = new SinhVien("Trí 2",1999,"b","1234","@gmail.com",new DaoTaoOnline(),php);
		System.out.println("----Thông tin sinh viên-----");
		System.out.println("Họ tên:" + sinhVien1.getHoTen() + ", Năm sinh: " + sinhVien1.getNamSinh());
		System.out.println("Loại hình đào tạo: " + sinhVien1.getLoaiDaoTao().getThongTinLoaiDaoTao());
		System.out.println("Hệ đào tạo: " + sinhVien1.getHeDaoTao().getThongTinHeDaoTao());
		System.out.println("Thời gian học: " + sinhVien1.getHeDaoTao().getThongTinThoiGianHoc());
		System.out.println("Môn học: ");
		for (MonHoc monHoc : sinhVien1.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println(" " + monHoc.getThongTinMonHoc()+" | Giảng viên: " + monHoc.getThongTinGiangVien());
		}
		System.out.println();
		System.out.println("----Thông tin sinh viên-----");
		System.out.println("Họ tên:" + sinhVien2.getHoTen() + ", Năm sinh: " + sinhVien2.getNamSinh());
		System.out.println("Loại hình đào tạo: " + sinhVien2.getLoaiDaoTao().getThongTinLoaiDaoTao());
		System.out.println("Hệ đào tạo: " + sinhVien2.getHeDaoTao().getThongTinHeDaoTao());
		System.out.println("Thời gian học: " + sinhVien2.getHeDaoTao().getThongTinThoiGianHoc());
		System.out.println("Môn học: ");
		for (MonHoc monHoc : sinhVien2.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println(" " + monHoc.getThongTinMonHoc()+" | Giảng viên: " + monHoc.getThongTinGiangVien());
		}
	}
}
