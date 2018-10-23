package hocsinh.main;

import hocsinh.entity.*;
import hocsinh.entity.antrua.*;
import hocsinh.entity.giangvien.*;
import hocsinh.entity.monhoc.*;
import hocsinh.entity.phuongtien.*;



public class ChuongTrinhDiHoc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HocSinh hocSinh = new HocSinh();
		MonHoa monHoaLop9A = new MonHoa(new CoSinh());
		hocSinh.setMonHoc(monHoaLop9A);
		hocSinh.setPhuongTien(new XeMay());
		hocSinh.setAnTrua(new TaiQuanAn());
		System.out.println("Thứ 2 học " + hocSinh.getMonHoc().getThongTinMonHoc() + ", " + hocSinh.getMonHoc().getThongTinGiangVien() );
		System.out.println("Đi: " + hocSinh.getPhuongTien().getThongTinPhuongTien());
		System.out.println("Ăn trưa:" + hocSinh.getAnTrua().getThongTinAnTrua());
		MonHoa monHoaLop9B = new MonHoa(new ThayHinh());
		hocSinh.setMonHoc(monHoaLop9B);
		hocSinh.setPhuongTien(new XeDap());
		hocSinh.setAnTrua(new TaiTruong());
		System.out.println("Thứ 3 học " + hocSinh.getMonHoc().getThongTinMonHoc() + ", " + hocSinh.getMonHoc().getThongTinGiangVien());
		System.out.println("Đi: " + hocSinh.getPhuongTien().getThongTinPhuongTien());
		System.out.println("Ăn trưa:" + hocSinh.getAnTrua().getThongTinAnTrua());

		
	}

}
