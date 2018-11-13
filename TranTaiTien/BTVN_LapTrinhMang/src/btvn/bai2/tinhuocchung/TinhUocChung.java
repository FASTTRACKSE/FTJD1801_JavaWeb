package btvn.bai2.tinhuocchung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TinhUocChung {
	static int a, b;

	public int UCMAX(int a, int b) {
		if (b == 0)
			return a;
		return UCMAX(b, a % b);
	}

	public int BCMIN(int a, int b) {
		return (a * b) / UCMAX(a, b);
	}

	public static void main(String[] args) throws IOException {

		TinhUocChung tuc = new TinhUocChung();

		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader bfr = new BufferedReader(input);
		System.out.print("Nhập vào a: ");
		String s = bfr.readLine();
		a = Integer.parseInt(s);
		System.out.print("Nhập vào b: ");
		String s2 = bfr.readLine();
		b = Integer.parseInt(s2);

		while (true) {
			System.out.println("----------------BÀI TẬP TÍNH ƯỚC CHUNG----------------");
			System.out.println("1. Ước chung lớn nhất");
			System.out.println("2. Bội chung nhỏ nhất");
			System.out.println("*. Kết thúc");
			System.out.println("Mời chọn: ");
			String s3 = bfr.readLine();
			int mChon = Integer.parseInt(s3);
			switch (mChon) {
			case 1:
				System.out.println("Ước chung lớn nhất của " + a + " và " + b + " là: " + tuc.UCMAX(a, b));
				break;

			case 2:
				System.out.println("Bội chung nhỏ nhất của " + a + " và " + b + " là: " + tuc.BCMIN(a, b));
				break;
			case 3:
				System.out.println("Tạm biệt!!!");
			}
			if (mChon < 1 || mChon > 2) {
				break;
			}

			System.out.println("\n");
		}
	}
}
