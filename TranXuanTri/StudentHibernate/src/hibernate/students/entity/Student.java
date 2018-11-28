package hibernate.students.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Size(min = 3, max = 50)
	@Column
	private String name;

	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "dateOfBirth", nullable = false)
	private LocalDate dateOfBirth;

	@Size(min = 3, max = 50)
	@Column
	private String email;

	@Size(min = 3, max = 50)
	@Column
	private String gender;

	@Size(min = 3, max = 50)
	@Column
	private String address;

	@Size(min = 3, max = 50)
	@Column
	private String stuClass;

	@Size(min = 3, max = 50)
	@Column
	private String avatar;

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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStuClass() {
		return stuClass;
	}

	public void setStuClass(String stuClass) {
		this.stuClass = stuClass;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Student))
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
