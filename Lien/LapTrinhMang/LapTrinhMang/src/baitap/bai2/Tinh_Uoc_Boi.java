package baitap.bai2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tinh_Uoc_Boi {
	static int a, b;

	public int UocChungLonNhat(int a, int b) {
		if (b == 0)
			return a;
		return UocChungLonNhat(b, a % b);
	}

	public int BoiChungNhoNhat(int a, int b) {
		return (a * b) / UocChungLonNhat(a, b);
	}

	public static void main(String[] args) throws IOException {

		Tinh_Uoc_Boi ucbc = new Tinh_Uoc_Boi();

		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader bufferR = new BufferedReader(input);
		System.out.print("Nhập vào a: ");
		String s = bufferR.readLine();
		a = Integer.parseInt(s);
		System.out.print("Nhập vào b: ");
		s = bufferR.readLine();
		b = Integer.parseInt(s);

		System.out.println("Ước chung lớn nhất của " + a + " và " + b + " là: " + ucbc.UocChungLonNhat(a, b));

		System.out.println("Bội chung nhỏ nhất của " + a + " và " + b + " là: " + ucbc.BoiChungNhoNhat(a, b));
	}
}
