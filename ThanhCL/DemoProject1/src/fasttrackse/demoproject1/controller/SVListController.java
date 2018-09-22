package fasttrackse.demoproject1.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fasttrackse.demoproject1.dao.StudentDAO;
import fasttrackse.demoproject1.entity.SinhVien;

/**
 * Servlet implementation class SinhVienController
 */
@WebServlet("/list")
public class SVListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentDAO studentDAO = new StudentDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SVListController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Step 1: Prepare data
		List<SinhVien> dsSinhVien = new ArrayList<SinhVien>();
		
		// Lay danh sach sinh vien tu tang DAO
		dsSinhVien = studentDAO.getAllSinhVien();
		
		request.getSession().setAttribute("student_list", dsSinhVien);

		// Step 2: get request dispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/sinhvien/view_students.jsp");

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
