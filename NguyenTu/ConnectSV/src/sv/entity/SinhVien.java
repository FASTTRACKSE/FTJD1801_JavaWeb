package sv.entity;
import java.io.Serializable;

public class SinhVien implements Serializable{

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		int iD;
		private String hoTen,date,image;
		


		


		public SinhVien(int iD, String hoTen, String date, String image) {
			super();
			this.iD = iD;
			this.hoTen = hoTen;
			this.date = date;
			this.image = image;
		}

		

		public int getiD() {
			return iD;
		}

		public void setiD(int iD) {
			this.iD = iD;
		}

		public String getHoTen() {
			return hoTen;
		}

		public void setHoTen(String hoTen) {
			this.hoTen = hoTen;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		
		
}
