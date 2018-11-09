package btvn.bai1.xulychuoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunXyLyChuoi {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		String chuoi;
		int mChon;

		XuLyChuoi xuLyChuoi = new XuLyChuoi();
		
		System.out.println("Xin mời nhập chuỗi: ");
		InputStreamReader input= new InputStreamReader(System.in);
        BufferedReader bfr = new BufferedReader(input);
        String s= bfr.readLine();
		chuoi = s;

		while (true) {
			System.out.println("----------------BÀI TẬP XỬ LÝ CHUỖI----------------");
			System.out.println("1. In ra chuỗi đảo ngược");
			System.out.println("2. In ra chuỗi hoa");
			System.out.println("3. In ra chuỗi hoa thường");
			System.out.println("4. In ra chuỗi thường ");
			System.out.println("5. In ra số từ");
			System.out.println("6. In ra số ký tự");
			System.out.println("7. In ra nguyên âm");
			System.out.println("8. Kết thúc");
			System.out.println("Mời chọn: ");
			String s2= bfr.readLine();
			mChon = Integer.parseInt(s2);
			switch (mChon) {
			case 1:
				System.out.println("Chuỗi đảo ngược: " + xuLyChuoi.DaoNguocChuoi(chuoi));
				break;

			case 2:
				System.out.println("Chuỗi hoa: " + xuLyChuoi.TaoChuoiHoa(chuoi));
				break;
			case 3:
				System.out.println("Chuỗi hoa thường: " + xuLyChuoi.TaoChuoiHoaThuong(chuoi));
				break;
			case 4:
				System.out.println("Chuỗi thường: " + xuLyChuoi.TaoChuoiThuong(chuoi));
				break;
			case 5:
				System.out.println("Số từ: " + xuLyChuoi.DemSoTu(chuoi));
				break;
			case 6:
				System.out.println("Số ký tự: " + xuLyChuoi.DemSoKyTu(chuoi));
				break;
			case 7:
				System.out.println("Nguyên âm: " + xuLyChuoi.LayNguyenAm(chuoi));
				break;
			case 8:
				System.out.println("Tạm biệt!!!");
				break;
			}

			if (mChon < 1 || mChon > 7) {
				break;
			}

			System.out.println("\n");
		}
	}

}
