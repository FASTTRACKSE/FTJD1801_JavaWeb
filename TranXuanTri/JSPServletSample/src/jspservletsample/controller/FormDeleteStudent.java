package jspservletsample.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspservletsample.entity.SinhVien;

/**
 * Servlet implementation class DeleteStudent
 */
@WebServlet("/formDelete")
public class FormDeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormDeleteStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<SinhVien> dsSinhVien = new ArrayList<SinhVien>();
		if (request.getSession().getAttribute("students_list") != null) {
			dsSinhVien = (ArrayList<SinhVien>) request.getSession().getAttribute("students_list");
		}
		SinhVien student = new SinhVien();
		int id = Integer.parseInt(request.getParameter("id"));
		for (SinhVien sv : dsSinhVien) {
			if (sv.getId() == id) {
				student.setId(sv.getId());
				student.setHoTen(sv.getHoTen());
				student.setNamSinh(sv.getNamSinh());
			}
		}
		request.setAttribute("student_delete", student);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/FormDeleteStudent.jsp");

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
