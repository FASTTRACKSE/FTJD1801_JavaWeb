package quanlysinhvien.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import quanlysinhvien.entity.giangvien.GiangVien;
import quanlysinhvien.entity.monhoc.MonHoc;
import quanlysinhvien.entity.sinhvien.SinhVien;

public class QuanLySinhVienVer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		List<SinhVien> dsSinhVien = new ArrayList<SinhVien>();
		SinhVien sv1 = (SinhVien) context.getBean("sinhvien1", SinhVien.class);
		SinhVien sv2 = (SinhVien) context.getBean("sinhvien2", SinhVien.class);
		SinhVien sv3 = (SinhVien) context.getBean("sinhvien3", SinhVien.class);

		dsSinhVien.add(sv1);
		dsSinhVien.add(sv2);
		dsSinhVien.add(sv3);
		for (SinhVien sinhVien : dsSinhVien) {
			System.out.println("		----Thông tin sinh viên-----");
			System.out.println("Thông tin cơ bản sinh viên:");
			System.out.println("	Họ tên:" + sinhVien.getHoTen());
			System.out.println("	Năm sinh: " + sinhVien.getNamSinh());
			System.out.println("	Địa chỉ: " + sinhVien.getDiaChi());
			System.out.println("	Điện thoại: " + sinhVien.getDienThoai());
			System.out.println("	Email: " + sinhVien.getEmail());
			System.out.println("Loại hình đào tạo: ");
			System.out.println("	" + sinhVien.getLoaiDaoTao().getThongTinLoaiDaoTao());
			System.out.println("	Thời gian:" + sinhVien.getLoaiDaoTao().getGioHoc());
			System.out.println("	Địa điểm:" + sinhVien.getLoaiDaoTao().getDiaDiem());
			System.out.println("Hệ đào tạo: " + sinhVien.getHeDaoTao().getThongTinHeDaoTao());
			System.out.println("	" + sinhVien.getHeDaoTao().getThongTinHeDaoTao());
			System.out.println("	Thời gian học:" + sinhVien.getHeDaoTao().getThongTinThoiGianHoc());
			System.out.println("Môn học: ");
			for (MonHoc monHoc : sinhVien.getHeDaoTao().getDanhSachMonHoc()) {
				System.out.println("	" + monHoc.getThongTinMonHoc());
				System.out.println("		Giảng viên: " + monHoc.getThongTinGiangVien());
				if (monHoc.getDanhSachTroGiang() != null) {
					for (GiangVien troGiang : monHoc.getDanhSachTroGiang()) {
						System.out.println(
								"		Trợ giảng: " + troGiang.getHoTen() + " || Email: " + troGiang.getEmail());
					}
				}
			}
			System.out.println("");
		}
		context.close();

	}

}
