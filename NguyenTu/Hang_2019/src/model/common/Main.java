package model.common;

import java.util.Scanner;

import model.dao.ClassDAO;
import model.dao.StudentDAO;

public class Main {
	public static void main(String[] args) {
		StudentDAO studentDAO = new StudentDAO();
		ClassDAO classDAO = new ClassDAO();
		Input input = new Input();
		System.out.println("Mời nhập lựa chọn: ");
		System.out.println("------------------------");
		System.out.println("1.Thêm sinh viên");
		System.out.println("2.Thêm lớp");
		System.out.println("3.Đăng ký nghỉ");
		System.out.println("------------------------");
		Scanner scaner = new Scanner(System.in);
		int chon= scaner.nextInt();
		switch (chon) {
		case 1:
			studentDAO.insertStudent(input.inputStudent());
			System.out.println("Thêm thành công!");
			break;
		case 2:
			classDAO.insetClass(input.inputClass());
			System.out.println("Thêm lớp thành công!");
			break;
		case 3:
			studentDAO.studentDayOff(input.inputDayOff());
			System.out.println("Đăng ký nghỉ thành công!");
			break;
		default:
			break;
		}
	}
}
