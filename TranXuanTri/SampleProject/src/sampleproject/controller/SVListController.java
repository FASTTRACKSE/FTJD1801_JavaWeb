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

import sampleproject.dao.SinhVienDAO;
import sampleproject.entity.SinhVien;

/**
 * Servlet implementation class SVListController
 */
@WebServlet("/list")
public class SVListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SinhVienDAO studentDAO = new SinhVienDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SVListController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<SinhVien> dsSinhVien = new ArrayList<SinhVien>();
		int pageid = 1;
		int start = 1;
		if (request.getParameter("page") != null) {
			start = Integer.parseInt(request.getParameter("page"));
			pageid = Integer.parseInt(request.getParameter("page"));
		} 
		int recordsPerPage = 3;
		if (start == 1) {
		} else {
			start = start - 1;
			start = (int) (start * recordsPerPage + 1);
		}

		dsSinhVien = studentDAO.getAllSinhVien(start,recordsPerPage);
		double rows = studentDAO.getNumberOfRows();
		int nOfPages = (int) Math.ceil(rows / recordsPerPage);
		
		request.getSession().setAttribute("pageid", pageid);
		request.getSession().setAttribute("noOfPages", nOfPages);

		request.getSession().setAttribute("students_list", dsSinhVien);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/sinhvien/view_students.jsp");

		// Step 3: forward to the JSP
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
