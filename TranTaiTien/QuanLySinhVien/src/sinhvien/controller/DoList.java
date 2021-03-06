package sinhvien.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sinhvien.dao.SinhVienDAO;

/**
 * Servlet implementation class DoList
 */
@WebServlet("/list")
public class DoList<SinhVien> extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SinhVienDAO studentDAO = new SinhVienDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ArrayList<SinhVien> dsSearchSinhVien = new ArrayList<SinhVien>();
		String name = null;
		if(request.getParameter("search") != null) {
			name = request.getParameter("search");
			request.getSession().setAttribute("name", name);
		}
		String hoten = (String) request.getSession().getAttribute("name");
		int perPage = 4;
		int nPage = 1;
		int currentPage = 0;
		double totalCount;
		if (hoten == null) {
			String nameCount = "";
			totalCount = studentDAO.selectCount(nameCount);
		}else {
			totalCount = studentDAO.selectCount(hoten);
		}
		int totalPage = (int) Math.ceil(totalCount/perPage);

		if(request.getParameter("page") != null) {
			nPage = Integer.parseInt(request.getParameter("page"));
			if(nPage < 1) {
				nPage = 1;
			}
			if(nPage > totalPage) {
				nPage = totalPage;
			}
			currentPage = (nPage - 1)*perPage;
		}
		
		request.getSession().setAttribute("totalPage",totalPage);
		request.getSession().setAttribute("crPage",nPage);
		
		if(hoten == null) {
			hoten = "";
		}
		
		dsSearchSinhVien = (ArrayList<SinhVien>) studentDAO.getSearchSinhVien(currentPage, perPage, hoten);		
		request.getSession().setAttribute("student_list", dsSearchSinhVien);
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/sinhvien/ds_sinh_vien.jsp");

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
