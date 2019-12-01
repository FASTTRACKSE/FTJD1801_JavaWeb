package model.bean;

public class DayOff {
	private int id;
	private int idStudent;
	private String dayOff;

	public DayOff() {
		super();
	}

	public DayOff(int id, int idStudent, String dayOff) {
		super();
		this.id = id;
		this.idStudent = idStudent;
		this.dayOff = dayOff;
	}

	public DayOff(int idStudent, String dayOff) {
		super();
		this.idStudent = idStudent;
		this.dayOff = dayOff;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public String getDayOff() {
		return dayOff;
	}

	public void setDayOff(String dayOff) {
		this.dayOff = dayOff;
	}

	@Override
	public String toString() {
		return "DayOff [id=" + id + ", idStudent=" + idStudent + ", dayOff=" + dayOff + "]";
	}

}
