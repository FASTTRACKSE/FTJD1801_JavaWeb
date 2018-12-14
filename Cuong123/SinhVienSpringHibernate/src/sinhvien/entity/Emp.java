package sinhvien.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMP99")
public class Emp {
	@Id 
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @Column(name = "id") 
		private int id;  
	
	@Column(name = "name")
		private String name;
	
	@Column(name = "tuoi")
		private int tuoi;
	
	@Column(name = "email")
		private String email;
	
	@Column(name = "gioiTinh")
		private String gioiTinh;
	
	@Column(name = "diaChi")
		private String diaChi;
	
	@Column(name = "lopHoc")
		private String lopHoc;
	
	@Column(name = "anhThe")
		private String anhThe;
		
		public Emp() {
			super();
		}

		public Emp(int id, String name, int tuoi, String email, String gioiTinh, String diaChi, String lopHoc,
				String anhThe) {
			super();
			this.id = id;
			this.name = name;
			this.tuoi = tuoi;
			this.email = email;
			this.gioiTinh = gioiTinh;
			this.diaChi = diaChi;
			this.lopHoc = lopHoc;
			this.anhThe = anhThe;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getTuoi() {
			return tuoi;
		}

		public void setTuoi(int tuoi) {
			this.tuoi = tuoi;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getGioiTinh() {
			return gioiTinh;
		}

		public void setGioiTinh(String gioiTinh) {
			this.gioiTinh = gioiTinh;
		}

		public String getDiaChi() {
			return diaChi;
		}

		public void setDiaChi(String diaChi) {
			this.diaChi = diaChi;
		}

		public String getLopHoc() {
			return lopHoc;
		}

		public void setLopHoc(String lopHoc) {
			this.lopHoc = lopHoc;
		}

		public String getAnhThe() {
			return anhThe;
		}

		public void setAnhThe(String anhThe) {
			this.anhThe = anhThe;
		}
		
		
		
	
}
