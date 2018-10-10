package sampleproject.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sampleproject.entity.SinhVien;

/**
 * Servlet implementation class SVDeleteForm
 */
@WebServlet("/formDelete")
public class SVDeleteForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SVDeleteForm() {
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
		List<SinhVien> dsSinhVien = new ArrayList<SinhVien>();
		if (request.getSession().getAttribute("students_list") != null) {
			dsSinhVien = (List<SinhVien>) request.getSession().getAttribute("students_list");
		}

		SinhVien student = new SinhVien();
		int id = Integer.parseInt(request.getParameter("id"));
		for (SinhVien sv : dsSinhVien) {
			if (sv.getID() == id) {
				student.setID(sv.getID());
				student.setHoTen(sv.getHoTen());
				student.setNamSinh(sv.getNamSinh());
				student.setAvatar(sv.getAvatar());
			}
		}

		request.setAttribute("student_delete", student);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/sinhvien/FormDeleteStudent.jsp");

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
