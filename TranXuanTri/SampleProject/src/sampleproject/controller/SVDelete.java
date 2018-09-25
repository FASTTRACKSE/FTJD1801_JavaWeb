package sampleproject.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sampleproject.dao.SinhVienDAO;

/**
 * Servlet implementation class SVDelete
 */
@WebServlet("/delete")
public class SVDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SinhVienDAO svDAO = new SinhVienDAO();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SVDelete() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("idDelete"));
		svDAO.deleteSinhVien(id);
		response.sendRedirect("/SampleProject/list");
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
