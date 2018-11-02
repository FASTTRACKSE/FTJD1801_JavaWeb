package fasttrackse.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fasttrackse.entity.giangvien.GiangVien;
import fasttrackse.entity.monhoc.MonHoc;
import fasttrackse.entity.sinhvien.SinhVien;

public class RunApp2 {
	public static void main(String arg[]) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ThongTinSinhVien.xml");
		
		List<SinhVien> listStudent = new ArrayList<SinhVien>();
		SinhVien sv1 = context.getBean("sinhvien1", SinhVien.class);
		SinhVien sv2 = context.getBean("sinhvien2", SinhVien.class);
		SinhVien sv3 = context.getBean("sinhvien3", SinhVien.class);

		listStudent.add(sv1);
		listStudent.add(sv2);
		listStudent.add(sv3);
		for (SinhVien sinhVien : listStudent) {
			System.out.println("		----Thông tin sinh viên-----");
			System.out.println("Thông tin cơ bản sinh viên:");
			System.out.println("	Họ tên:" + sinhVien.getHoTen());
			System.out.println("	Năm sinh: " + sinhVien.getNamSinh());
			System.out.println("	Địa chỉ: " + sinhVien.getDiaChi());
			System.out.println("	Điện thoại: " + sinhVien.getDienThoai());
			System.out.println("	Email: " + sinhVien.getEmail());
			System.out.println("Loại hình đào tạo: ");
			System.out.println("	" + sinhVien.getLoaiDaoTao().getLoaiHinhDaoTao());
			System.out.println("	Thời gian:" + sinhVien.getLoaiDaoTao().getThoiGian());
			System.out.println("	Địa điểm:" + sinhVien.getLoaiDaoTao().getDiaChi());
			System.out.println("Hệ đào tạo: ");
			System.out.println("	" + sinhVien.getHeDaoTao().getHeDaoTao());
			System.out.println("	Thời gian học:" + sinhVien.getHeDaoTao().getThongTinThoiGianHoc());
			System.out.println("Môn học: ");
			for (MonHoc monHoc : sinhVien.getHeDaoTao().getDanhSachMonHoc()) {
				System.out.println("	" + monHoc.getTenMonHoc());
				if (monHoc.getDanhSachGiangVien() != null) {
					for (GiangVien giangVien : monHoc.getDanhSachGiangVien()) {
						System.out.println(
								"		Giảng viên: " + giangVien.getHoTen() + " || Email: " + giangVien.getEmail());
					}
				}
				
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
