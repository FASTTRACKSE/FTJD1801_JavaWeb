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

		DaoTaoCapTocJAVA java= new DaoTaoCapTocJAVA();
		DaoTaoCapTocPHP php= new DaoTaoCapTocPHP();
		DaoTaoDaiHan daiHan= new DaoTaoDaiHan();
		
		
		List<MonHoc> dsJava = new ArrayList<MonHoc>();
		List<MonHoc> dsPhp = new ArrayList<MonHoc>();
		List<MonHoc> dsDaiHan = new ArrayList<MonHoc>();
		
		
		dsJava.add(new LapTrinhJavaCoBan(new CoDia()));
		dsJava.add(new LapTrinhJavaWeb(new ThayToan()));
		
		
		dsPhp.add(new LapTrinhWebPHP(new CoWeb()));
		dsPhp.add(new LapTrinhWebFrontend(new CoDia()));
		
		
		dsDaiHan.add(new DaoTaoOnline(new ThayToan()));
		dsDaiHan.add(new QuyTrinhDuAn(new CoWeb()));
		
		
		java.setDsMonHoc(dsJava);
		php.setDsMonHoc(dsPhp);
		daiHan.setDsDaiHan(dsDaiHan); 
		
		
		SinhVien tu = new SinhVien("Nguyễn Văn Tú", 1998, "Chi Lăng", "0905649897", "Tuhandsome98@gmail.com", new DaoTaoOffline(), daiHan);
		SinhVien lien = new SinhVien("Trương Thị Mỹ Liên", 2003, "Mai Am", "0905649897", "Lienchodien2k3@gmail.com", new DaoTaoOnline(), java);
		SinhVien tien = new SinhVien("Trần Tài Tiên", 2008, "Mốt Am", "090000pit", "TienXL2k8@gmail.com", new DaoTaoOffline(), php);
		
		System.out.println("----Thông tin sinh viên-----");
		System.out.println("Họ tên:" + tu.getHoTen() + ", Năm sinh: " + tu.getNamSinh());
		System.out.println("Loại hình đào taọ:" +  tu.getLoaiDaoTao().getTenLoaiDaoTao() );
		System.out.println("Hệ đào tạo: " + tu.getHeDaoTao().getThongTinHeDaoTao());
		System.out.println("Thời gian học: " + tu.getHeDaoTao().getThongTinThoiGianHoc());
		System.out.println("Môn học: ");
		for (MonHoc monHoc : tu.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println(" " + monHoc.getTenMonHoc() + " | Giảng viên: " + monHoc.getGiangVienPhuTrach());
		}
		
	}
}