package fasttrackse.jspservletsample.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fasttrackse.jspservletsample.entity.SinhVien;

/**
 * Servlet implementation class SinhVienController
 */
@WebServlet("/")
public class SinhVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<SinhVien> dsSinhVien = new ArrayList<SinhVien>();

	int randomWithRange(int min, int max) {
		int range = (max - min) + 1;
		return (int) (Math.random() * range) + min;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SinhVienController() {
		super();
		// Khởi tạo danh sách sinh viên nháp
		for (int i = 0; i < 32; i++) {
			dsSinhVien.add(new SinhVien(i + 1, "Cao Lê Thành " + (i + 1), randomWithRange(1970, 1999)));
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Step 1: Prepare data
		request.setAttribute("student_list", dsSinhVien);

		// Step 2: get request dispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view_students.jsp");

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
