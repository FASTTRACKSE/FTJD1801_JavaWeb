package model.bean;

public class Class1 {
	private int id;
	private String className;
	public Class1() {
		super();
	}
	public Class1(int id, String className) {
		super();
		this.id = id;
		this.className = className;
	}
	public Class1(String className) {
		super();
		this.className = className;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	@Override
	public String toString() {
		return "Class [id=" + id + ", className=" + className + "]";
	}
	
}
