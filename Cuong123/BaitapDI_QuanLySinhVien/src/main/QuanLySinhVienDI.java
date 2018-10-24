package main;

import java.util.ArrayList;
import java.util.List;

import entity.SinhVien;
import entity.giangvien.CoDia;
import entity.giangvien.CoSinh;
import entity.hedaotao.DaoTaoCapTocJava;
import entity.hedaotao.DaoTaoCapTocPHP;
import entity.hedaotao.DaoTaoDaiHan;
import entity.loaihinhdaotao.DaoTaoOffline;
import entity.loaihinhdaotao.DaoTaoOnline;
import entity.monhoc.LapTrinhCoBan;
import entity.monhoc.LapTrinhJavaCoBan;
import entity.monhoc.LapTrinhJavaWeb;
import entity.monhoc.LapTrinhWebPHP_MySQL;
import entity.monhoc.LapTrinhWebfrontend;
import entity.monhoc.MonHoc;
import entity.monhoc.QuyTrinhDuAn;
import entity.monhoc.TinHocVanPhong;
import entity.thoigiandaotao.ThoiGianDaoTaoDaiHan;
import entity.thoigiandaotao.ThoiGianDaoTaoJava;
import entity.thoigiandaotao.ThoiGianDaoTaoPHP;
import entity.thongtinsinhvien.Cuong;
import entity.thongtinsinhvien.Cuong2;
import entity.thongtinsinhvien.Cuong3;

public class QuanLySinhVienDI{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cuong cuong = new Cuong();
		DaoTaoCapTocJava daoTaoCapTocJava = new DaoTaoCapTocJava();
		
		List<MonHoc> dsMonHocJava = new ArrayList<MonHoc>();
		dsMonHocJava.add(new LapTrinhJavaCoBan(new CoDia()));
		dsMonHocJava.add(new LapTrinhJavaWeb(new CoSinh()));
		
		daoTaoCapTocJava.setDanhSachMonHoc(dsMonHocJava);
		daoTaoCapTocJava.setThoiGianDaoTao(new ThoiGianDaoTaoJava());

		SinhVien sinhvien1 = new SinhVien(cuong, new DaoTaoOffline(),daoTaoCapTocJava);
		
		Cuong2 cuong2 = new Cuong2();
		DaoTaoCapTocPHP daoTaoCapTocPHP = new DaoTaoCapTocPHP();
		
		List<MonHoc> dsMonHocPHP = new ArrayList<MonHoc>();
		dsMonHocPHP.add(new LapTrinhWebfrontend(new CoDia()));
		dsMonHocPHP.add(new LapTrinhWebPHP_MySQL(new CoSinh()));
		
		daoTaoCapTocPHP.setDanhSachMonHoc(dsMonHocPHP);
		daoTaoCapTocPHP.setThoiGianDaoTao(new ThoiGianDaoTaoPHP());
		SinhVien sinhvien2 = new SinhVien(cuong2, new DaoTaoOnline(), daoTaoCapTocPHP);
		
		Cuong3 cuong3 = new Cuong3();
		DaoTaoDaiHan daoTaoDaiHan = new DaoTaoDaiHan();
		
		List<MonHoc> dsMonHocDaiHan = new ArrayList<MonHoc>();
		dsMonHocDaiHan.add(new LapTrinhCoBan(new CoDia()));
		dsMonHocDaiHan.add(new LapTrinhJavaCoBan(new CoSinh()));
		dsMonHocDaiHan.add(new LapTrinhJavaWeb(new CoDia()));
		dsMonHocDaiHan.add(new LapTrinhWebfrontend(new CoSinh()));
		dsMonHocDaiHan.add(new LapTrinhWebPHP_MySQL(new CoDia()));
		dsMonHocDaiHan.add(new QuyTrinhDuAn(new CoSinh()));
		dsMonHocDaiHan.add(new TinHocVanPhong(new CoDia()));
		
		daoTaoDaiHan.setDanhSachMonHoc(dsMonHocDaiHan);
		daoTaoDaiHan.setThoiGianDaoTao(new ThoiGianDaoTaoDaiHan());
		
		SinhVien sinhvien3 = new SinhVien(cuong3, new DaoTaoOnline(), daoTaoDaiHan);
		

		System.out.println("Thonng tin sv:" +sinhvien1.getThongTinSinhVien().getThongTinSinhVien());
		System.out.println("Loai Hinh Dao tao:" +sinhvien1.getLoaiHinhDaoTao().getLoaiHinhDaoTao());
		System.out.println("He Dao tao:"+ sinhvien1.getHeDaoTao().getTieuChiHeDaoTao() +"|"+sinhvien1.getHeDaoTao().getThoiGianDaoTao().getThoiGianDaoTao());
		
		System.out.println("Mon hoc:");
		for(MonHoc x : sinhvien1.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println( "- " +x.getThongTinMonHoc() + " - Giảng viên : " + x.getGiangVien().getGiangVien());
		}
		
		System.out.println("------------------------------------------------------------------------------------");
		
		
		System.out.println("Thonng tin sv:" +sinhvien2.getThongTinSinhVien().getThongTinSinhVien());
		System.out.println("Loai Hinh Dao tao:" +sinhvien2.getLoaiHinhDaoTao().getLoaiHinhDaoTao());
		System.out.println("He Dao tao:" +sinhvien2.getHeDaoTao().getTieuChiHeDaoTao() +"|"+sinhvien2.getHeDaoTao().getThoiGianDaoTao().getThoiGianDaoTao());
		
		System.out.println("Mon hoc:");
		for(MonHoc x : sinhvien2.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println( "- " +x.getThongTinMonHoc() + " - Giảng viên : " + x.getGiangVien().getGiangVien());
		}
	
		System.out.println("------------------------------------------------------------------------------------");

		

		System.out.println("Thonng tin sv:" +sinhvien3.getThongTinSinhVien().getThongTinSinhVien());
		System.out.println("Loai Hinh Dao tao:" +sinhvien3.getLoaiHinhDaoTao().getLoaiHinhDaoTao());
		System.out.println("He Dao tao:" +sinhvien3.getHeDaoTao().getTieuChiHeDaoTao() +"|"+sinhvien3.getHeDaoTao().getThoiGianDaoTao().getThoiGianDaoTao());
		
		System.out.println("Mon hoc:");
		for(MonHoc x : dsMonHocDaiHan) {
			System.out.println( "- " +x.getThongTinMonHoc() + " - Giảng viên : " + x.getGiangVien().getGiangVien());
		}
		
		
		
		
	}

}
