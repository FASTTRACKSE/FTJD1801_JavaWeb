package fasttrackse.demoproject1.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fasttrackse.demoproject1.dao.StudentDAO;
import fasttrackse.demoproject1.entity.SinhVien;

/**
 * Servlet implementation class SinhVienAddNew
 */
@WebServlet("/insert")
public class SVInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentDAO studentDAO = new StudentDAO();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SVInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String hoTen = request.getParameter("hoten");
		int namSinh = Integer.parseInt(request.getParameter("namsinh"));
		
		SinhVien sinhVien = new SinhVien(0, hoTen, namSinh);
		studentDAO.addNewSinhVien(sinhVien);
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
