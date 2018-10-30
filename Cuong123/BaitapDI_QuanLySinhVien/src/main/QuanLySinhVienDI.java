package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.SinhVien;
import entity.giangvien.GiangVien;
import entity.monhoc.MonHoc;

public class QuanLySinhVienDI{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
		
		SinhVien sinhvien1 = context.getBean("sinhVien1", SinhVien.class);
		SinhVien sinhvien2 = context.getBean("sinhVien2", SinhVien.class);
		SinhVien sinhvien3 = context.getBean("sinhVien3", SinhVien.class);
		
		System.out.println("Thonng tin sv : " +sinhvien1.getThongTinSinhVien().getThongTinSinhVien());
		System.out.println("Loai Hinh Dao tao : " +sinhvien1.getLoaiHinhDaoTao().getLoaiHinhDaoTao());
		System.out.println("He Dao tao : "+ sinhvien1.getHeDaoTao().getTieuChiHeDaoTao() +"|"+sinhvien1.getHeDaoTao().getThoiGianDaoTao().getThoiGianDaoTao());
		
		System.out.println("Mon hoc : ");
		for(MonHoc x : sinhvien1.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println( "- " +x.getThongTinMonHoc() + " - Giảng viên : " + x.getGiangVien().getGiangVien());
			for(GiangVien gv : x.getDsTroGiang()) {
			System.out.println("   - Tro giang : " + gv.getGiangVien());
			}
			
		}
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("Thonng tin sv : " +sinhvien2.getThongTinSinhVien().getThongTinSinhVien());
		System.out.println("Loai Hinh Dao tao : " +sinhvien2.getLoaiHinhDaoTao().getLoaiHinhDaoTao());
		System.out.println("He Dao tao : " +sinhvien2.getHeDaoTao().getTieuChiHeDaoTao() +"|"+sinhvien2.getHeDaoTao().getThoiGianDaoTao().getThoiGianDaoTao());
		
		System.out.println("Mon hoc : ");
		for(MonHoc x : sinhvien2.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println( "- " +x.getThongTinMonHoc() + " - Giảng viên : " + x.getGiangVien().getGiangVien());
			for(GiangVien gv : x.getDsTroGiang()) {
				System.out.println("   - Tro giang : " + gv.getGiangVien());
				}
		}
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("Thong tin sv:" +sinhvien3.getThongTinSinhVien().getThongTinSinhVien());
		System.out.println("Loai Hinh Dao tao : " +sinhvien3.getLoaiHinhDaoTao().getLoaiHinhDaoTao());
		System.out.println("He Dao tao : " +sinhvien3.getHeDaoTao().getTieuChiHeDaoTao() +"|"+sinhvien3.getHeDaoTao().getThoiGianDaoTao().getThoiGianDaoTao());
		
		System.out.println("Mon hoc : ");
		for(MonHoc x : sinhvien3.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println( "- " +x.getThongTinMonHoc() + " - Giảng viên : " + x.getGiangVien().getGiangVien());
			for(GiangVien gv : x.getDsTroGiang()) {
				System.out.println("   - Tro giang : " + gv.getGiangVien());
				}
		}
	
		context.close();
		
	
		
}
}
