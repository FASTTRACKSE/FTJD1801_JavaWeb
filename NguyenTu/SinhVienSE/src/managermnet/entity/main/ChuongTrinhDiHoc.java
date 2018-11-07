package managermnet.entity.main;

import java.util.ArrayList;
import java.util.List;

import managerment.entity.daotao.*;
import managerment.entity.giangvien.*;
import managerment.entity.monhoc.*;
import managerment.entity.sinhvien.*;

public class ChuongTrinhDiHoc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DaoTaoCapTocJAVA java = new DaoTaoCapTocJAVA();
		DaoTaoCapTocPHP php = new DaoTaoCapTocPHP();
		DaoTaoDaiHan daiHan = new DaoTaoDaiHan();

		List<MonHoc> dsJava = new ArrayList<MonHoc>();
		List<MonHoc> dsPhp = new ArrayList<MonHoc>();
		List<MonHoc> dsDaiHan = new ArrayList<MonHoc>();

		LapTrinhCoBan ltcb = new LapTrinhCoBan();
		LapTrinhJavaCoBan ltjvcb = new LapTrinhJavaCoBan();
		LapTrinhJavaWeb ltjvw = new LapTrinhJavaWeb();
		LapTrinhWebFrontend ltwft = new LapTrinhWebFrontend();
		LapTrinhWebPHP ltwphp = new LapTrinhWebPHP();
		QuyTrinhDuAn qtda = new QuyTrinhDuAn();
		TinHocVanPhong thvp= new TinHocVanPhong();
		
		List<GiangVien> gvltCoBan = new ArrayList<GiangVien>();
		List<GiangVien> gvltJavaCoBan = new ArrayList<GiangVien>();
		List<GiangVien> gvltJavaWeb = new ArrayList<GiangVien>();
		List<GiangVien> gvltWebFrontend = new ArrayList<GiangVien>();
		List<GiangVien> gvltWebPHP = new ArrayList<GiangVien>();
		List<GiangVien> gvQuyTrinhDuAn = new ArrayList<GiangVien>();
		List<GiangVien> gvTinHocVanPhong= new ArrayList<GiangVien>();
		
		
		
		List<GiangVien> tgltCoBan = new ArrayList<GiangVien>();
		List<GiangVien> tgltJavaCoBan = new ArrayList<GiangVien>();
		List<GiangVien> tgltJavaWeb = new ArrayList<GiangVien>();
		List<GiangVien> tgltWebFrontend = new ArrayList<GiangVien>();
		List<GiangVien> tgltWebPHP = new ArrayList<GiangVien>();
		List<GiangVien> tgQuyTrinhDuAn = new ArrayList<GiangVien>();
		List<GiangVien> tgTinHocVanPhong= new ArrayList<GiangVien>();
		
		
		GiangVien coJava = new GiangVien("Trần Thị Tiên","tienxinhgai@gmail.com");
		GiangVien thayWeb = new GiangVien("Trần Tài Tiên","tienxlai@gmail.com");
		GiangVien coPHP = new GiangVien("Trần Văn A","Adua@gmail.com");
		GiangVien thayTHVP = new GiangVien("Nguyễn Văn Tú","TuHandsome@gmail.com");
		
		
		GiangVien cotgJava = new GiangVien("Trần Thị A","tienxinhgai@gmail.com");
		GiangVien thaytgWeb = new GiangVien("Trần Tài B","tienxlai@gmail.com");
		GiangVien cotgPHP = new GiangVien("Trần Văn A","Adua@gmail.com");
		GiangVien thaytgTHVP = new GiangVien("Nguyễn Văn V","TuHandsome@gmail.com");
		
		
		gvltCoBan.add(coJava);
		gvltJavaCoBan.add(thayWeb);
		gvltWebPHP.add(thayWeb);
		gvltWebFrontend.add(coPHP);
		
		
		tgltCoBan.add(cotgJava); 
		tgltJavaCoBan.add(thaytgWeb);
		tgltWebPHP.add(thaytgWeb);
		tgltWebFrontend.add(thaytgTHVP);
		
		
		ltcb.setGiangVien(gvltCoBan);
		ltjvcb.setGiangVien(gvltJavaCoBan);
		ltwphp.setGiangVien(gvltWebPHP);
		ltwft.setGiangVien(gvltWebFrontend);
		
		
		ltcb.setTroGiang(tgltCoBan);
		ltjvcb.setTroGiang(tgltJavaCoBan);
		ltwphp.setTroGiang(tgltWebPHP);
		ltwft.setTroGiang(tgltJavaCoBan);
		
		
		dsJava.add(ltjvcb);
		dsJava.add(ltcb);
		
		dsPhp.add(ltwphp);
		dsPhp.add(ltwft);
		

		SinhVien tu = new SinhVien("Nguyễn Văn Tú", 1998, "Chi Lăng", "0905649897", "Tuhandsome98@gmail.com",
				new DaoTaoOffline(), daiHan);
		SinhVien lien = new SinhVien("Trương Thị Mỹ Liên", 2003, "Mai Am", "0905649897", "Lienchodien2k3@gmail.com",
				new DaoTaoOnline(), java);
		SinhVien tien = new SinhVien("Trần Tài Tiên", 2008, "Mốt Am", "090000pit", "TienXL2k8@gmail.com",
				new DaoTaoOffline(), php);

		System.out.println(" * Thông tin cơ bản: ");
		System.out.println("	- Họ và tên: " + tien.getHoTen());
		System.out.println("	- Năm sinh: " + tien.getNamSinh());
		System.out.println("	- Địa chỉ: " + tien.getDiaChi());
		System.out.println("	- Số điện thoại: " + tien.getDienThoai());
		System.out.println("	- Email: " + tien.getEmail());

		System.out.println(" * Loại hình đào tạo: " + tien.getLoaiDaoTao().getTenLoaiDaoTao());
		System.out.println("	- Thời gian: " + tien.getLoaiDaoTao().getThoiGian());
		System.out.println("	- Địa chỉ: " + tien.getLoaiDaoTao().getDiaChi());

		System.out.println(" * Hệ đào tạo: " + tien.getHeDaoTao().getThongTinHeDaoTao());
		System.out.println("	- Thông tin thời gian học: " + tien.getHeDaoTao().getThongTinThoiGianHoc());
		System.out.println("	- Thông tin môn học: ");
		for (MonHoc monhoc : tien.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("		+ Tên môn học: " + monhoc.getTenMonHoc());
			for (GiangVien giangvien : monhoc.getDanhSachGiangVien()) {
				System.out
						.println("		\t+ Giảng viên: " + giangvien.getHoTen() + "  |  Email: " + giangvien.getEmail());
			}
			if(monhoc.getDanhSachTroGiang() != null) {
				for (GiangVien trogiang : monhoc.getDanhSachTroGiang()) {
					System.out
							.println("		\t\t+ Trợ Giảng: " + trogiang.getHoTen() + "  |  Email: " + trogiang.getEmail());
				}
			}
		}

	}
}