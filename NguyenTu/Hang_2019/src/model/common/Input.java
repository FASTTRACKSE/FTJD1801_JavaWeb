package model.common;

import java.util.Scanner;

import model.bean.Class1;
import model.bean.DayOff;
import model.bean.Student;

public class Input {

	Scanner scanner = new Scanner(System.in);
	
	public Student inputStudent() {
		
		System.out.println("Nhap vao ho ten: ");
		String hoTen= scanner.nextLine();
		System.out.println("Nhap vao tuoi:");
		int tuoi= scanner.nextInt();
		Student student= new Student(hoTen,tuoi);
		return student;
	}
	
	public Class1 inputClass() {
		System.out.println("Nhap vao ten lop: ");
		String className =scanner.nextLine();
		Class1 clas= new Class1();
		clas.setClassName(className);
		return clas;
	}
	
	public DayOff inputDayOff() {
		System.out.println("Nhap vao id student");
		int id =scanner.nextInt();
		String i = scanner.nextLine();
		System.out.println("Nhap vao thoi gian nghi(dd-MM-yyyy): ");
		String day=scanner.nextLine();
		DayOff dayOff= new DayOff(id,day);
		return dayOff;
	}
}
