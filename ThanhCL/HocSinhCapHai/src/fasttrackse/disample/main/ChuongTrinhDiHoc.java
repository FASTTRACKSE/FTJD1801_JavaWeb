package fasttrackse.disample.main;

import fasttrackse.disample.entity.HocSinh;
import fasttrackse.disample.entity.HocSinh2;
import fasttrackse.disample.entity.giangvien.CoDia;
import fasttrackse.disample.entity.giangvien.CoSinh;
import fasttrackse.disample.entity.giangvien.ThayHinh;
import fasttrackse.disample.entity.monhoc.MonHoa;
import fasttrackse.disample.entity.phuongtien.XeCon;

public class ChuongTrinhDiHoc {

	public static void main(String[] args) {
		HocSinh hocSinh = new HocSinh();
		
		System.out.println("Thứ 2, 3, 4: ");
		System.out.println(" - Học: " + hocSinh.hocToan());
		System.out.println("      : " + hocSinh.hocLy());
		System.out.println("      : " + hocSinh.hocHoa());
		System.out.println(" - Đi: " + hocSinh.diXeMay());

		System.out.println("Thứ 6, 7: ");
		System.out.println(" - Học: " + hocSinh.hocHoa());
		System.out.println(" - Đi: " + hocSinh.diXeCon());
		
		HocSinh2 hocSinh2 = new HocSinh2();
		
		//inject phương tiện ô tô con cho hocSinh2
		hocSinh2.setPhuongTien(new XeCon());
		
		// inject MonTiengAnh cho đối tượng hocSinh2
		MonHoa monHoaLop9A = new MonHoa();
		MonHoa monHoaLop9B = new MonHoa();
		monHoaLop9A.setGiangVien(new CoSinh());
		monHoaLop9B.setGiangVien(new CoDia());
		
		MonHoa monHoaLop9A2 = new MonHoa(new ThayHinh());
		MonHoa monHoaLop9B2 = new MonHoa(new CoDia());

		hocSinh2.setMonHoc(monHoaLop9A2);

		System.out.println("Học sinh 2 - thế hệ 4.0:");
		System.out.println(" - Học: " + hocSinh2.getMonHoc().getThongTinMonHoc() + " - " + hocSinh2.getMonHoc().getThongTinGiangVien());
		System.out.println(" - Đi: " + hocSinh2.getPhuongTien().getThongTinPhuongTien());
		
		
	}

}
