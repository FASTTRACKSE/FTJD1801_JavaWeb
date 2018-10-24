package managerment.entity.monhoc;

import managerment.entity.giangvien.CoWeb;

public class QuyTrinhDuAn implements MonHoc{

	@Override
	public String getTenMonHoc() {
		// TODO Auto-generated method stub
		return "Quy trình sự án";
	}

	@Override
	public String getGiangVienPhuTrach() {
		// TODO Auto-generated method stub
		return "Cô Hòa";
	}
	
	public QuyTrinhDuAn(CoWeb coWeb) {
		// TODO Auto-generated constructor stub
	}


}
