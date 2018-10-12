package sinhvien.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sinhvien.dao.SinhVienDAO;
import sinhvien.entity.SinhVien;

/**
 * Servlet implementation class DoRemove
 */
@WebServlet("/do_remove")
public class DoRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	SinhVienDAO studentDAO = new SinhVienDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoRemove() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String hoTen = request.getParameter("hoten");
		int namSinh = Integer.parseInt(request.getParameter("namsinh"));
		String link = "";

		SinhVien sinhVien = new SinhVien(id, hoTen, namSinh,link);
		studentDAO.removeSinhVien(sinhVien);
		response.sendRedirect("list");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
