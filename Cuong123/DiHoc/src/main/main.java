package main;

import entity.CoSinh;
import entity.HocSinh;
import entity.MonHoa;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HocSinh hocSinh = new HocSinh();
		MonHoa monHoa = new MonHoa();
		monHoa.setThongTinGiangVien(new CoSinh());
		
		//hocSinh.setMonHoc(new MonHoa());
		hocSinh.setMonHoc(monHoa);
		System.out.println(hocSinh.getMonHoc().getThongTinMonHoc());
		System.out.println(hocSinh.getMonHoc().getThongTinGiangVien().getThongTinGiangVien());
	}

}
