package fasttrackse.disample.entity;

import fasttrackse.disample.entity.monhoc.MonHoa;
import fasttrackse.disample.entity.monhoc.MonLy;
import fasttrackse.disample.entity.monhoc.MonToan;
import fasttrackse.disample.entity.phuongtien.XeBus;
import fasttrackse.disample.entity.phuongtien.XeCon;
import fasttrackse.disample.entity.phuongtien.XeDap;
import fasttrackse.disample.entity.phuongtien.XeMay;

public class HocSinh {
	MonToan monToan = new MonToan();
	MonLy monLy = new MonLy();
	MonHoa monHoa = new MonHoa();
	
	XeDap xeDap = new XeDap();
	XeMay xeMay = new XeMay();
	XeBus xeBus = new XeBus();
	XeCon xeCon = new XeCon();
		
	public String hocToan() {
		return monToan.getThongTinMonHoc();
	}
	
	public String hocLy() {
		return monLy.getThongTinMonHoc();
	}
	
	public String hocHoa() {
		return monHoa.getThongTinMonHoc();
	}

	public String diXeDap() {
		return xeDap.getThongTinPhuongTien();
	}
	
	public String diXeMay() {
		return xeMay.getThongTinPhuongTien();
	}
	
	public String diXeBus() {
		return xeBus.getThongTinPhuongTien();
	}

	public String diXeCon() {
		return xeCon.getThongTinPhuongTien();
	}
}
