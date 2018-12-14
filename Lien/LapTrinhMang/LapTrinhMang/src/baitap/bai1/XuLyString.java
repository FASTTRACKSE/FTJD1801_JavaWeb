package baitap.bai1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class XuLyString {
	public String DaoNguoc(String string) {
		String stringDaoNguoc = new StringBuffer(string).reverse().toString();
		return stringDaoNguoc;
	}
	
	public String ChuoiHoa(String string) {
		String str;
		str = string.toUpperCase();
		return str;
	}
	
	public String ChuoiHoaThuong(String string) {
		String str = "";
		String charC = "";		
		string = string.toLowerCase();
		charC = String.valueOf(string.charAt(0));
		charC = charC.toUpperCase();
		str += charC;
		for (int i = 1; i < string.length(); i++) {
			int j = i - 1;
			charC = String.valueOf(string.charAt(i));
			if (string.charAt(j) == ' ') {
				charC = charC.toUpperCase();
			}
			str += charC;
		}
		return str;
	}
	
	public int DemSoTu(String string) {
		int dem = 0;
		string = string.trim();
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == ' ') {
				dem++;
			}
		}
		return dem+1;
	}
	
	public String NguyenAm(String string) {
		String str = "";
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == ' ' || string.charAt(i) == 'a' || string.charAt(i) == 'o' || string.charAt(i) == 'e'
					|| string.charAt(i) == 'u' || string.charAt(i) == 'i' || string.charAt(i) == 'y') {
				str += string.charAt(i);
			}
		}
		return str;
	}
	public static void main (String arg[]) throws IOException{
		XuLyString xls = new XuLyString();
		System.out.println("Nhập chuỗi: ");
		InputStreamReader input= new InputStreamReader(System.in);
        BufferedReader bufferR = new BufferedReader(input);
        String s= bufferR.readLine();
		String str = s;
		System.out.println("Chuỗi đảo ngược là: " + xls.DaoNguoc(str));
		System.out.println("Số từ là: " + xls.DemSoTu(str));
		System.out.println("Chuỗi hoa: " + xls.ChuoiHoa(str));
		System.out.println("Chuỗi hoa thường: "+ xls.ChuoiHoaThuong(str));
		System.out.println("Phần nguyên âm: " + xls.NguyenAm(str));
	}
}
