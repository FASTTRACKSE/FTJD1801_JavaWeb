package sv.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sv.dao.SinhVienDAO;
import sv.entity.*;

/**
 * Servlet implementation class doRemove
 */
@WebServlet("/doRemove")
public class doRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SinhVienDAO studentDAO = new SinhVienDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doRemove() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		
		int id = Integer.parseInt(request.getParameter("iDUD"));
		String hoTen = request.getParameter("hoTenUD");
		String namSinh = request.getParameter("dateUD");

		SinhVien sinhVien = new SinhVien(id, hoTen, namSinh);
		studentDAO.removeSinhVien(sinhVien);
		response.sendRedirect("sv");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
