package btvn.bai1.xulychuoi;

public class XuLyChuoi {
	public String DaoNguocChuoi(String chuoi) {
		String chuoiDaoNguoc = new StringBuffer(chuoi).reverse().toString();

		return chuoiDaoNguoc;
	}

	public int DemSoKyTu(String chuoi) {
		int doDaiChuoi = chuoi.length();
		return doDaiChuoi;
	}

	public String TaoChuoiHoaThuong(String chuoi) {
		String chuoiHoaThuong = "";
		String kytu = "";
		
		chuoi = chuoi.toLowerCase();

		kytu = String.valueOf(chuoi.charAt(0));
		kytu = kytu.toUpperCase();
		chuoiHoaThuong += kytu;

		for (int i = 1; i < chuoi.length(); i++) {
			int j = i - 1;
			kytu = String.valueOf(chuoi.charAt(i));
			if (chuoi.charAt(j) == ' ') {
				kytu = kytu.toUpperCase();
			}
			chuoiHoaThuong += kytu;
		}
		return chuoiHoaThuong;
	}

	public String TaoChuoiHoa(String chuoi) {
		String chuoiHoa;
		chuoiHoa = chuoi.toUpperCase();
		return chuoiHoa;
	}

	public String TaoChuoiThuong(String chuoi) {
		String chuoiThuong;
		chuoiThuong = chuoi.toLowerCase();
		return chuoiThuong;
	}

	public int DemSoTu(String chuoi) {
		int dem = 1;
		chuoi = chuoi.trim();
		for (int i = 0; i < chuoi.length(); i++) {
			if (chuoi.charAt(i) == ' ') {
				dem++;
			}
		}
		return dem;
	}

	public String LayNguyenAm(String chuoi) {
		String chuoiNguyenAm = "";
		for (int i = 0; i < chuoi.length(); i++) {
			if (chuoi.charAt(i) == ' ' || chuoi.charAt(i) == 'a' || chuoi.charAt(i) == 'o' || chuoi.charAt(i) == 'e'
					|| chuoi.charAt(i) == 'u' || chuoi.charAt(i) == 'i' || chuoi.charAt(i) == 'y') {
				chuoiNguyenAm += chuoi.charAt(i);
			}
		}
		return chuoiNguyenAm;
	}
}
