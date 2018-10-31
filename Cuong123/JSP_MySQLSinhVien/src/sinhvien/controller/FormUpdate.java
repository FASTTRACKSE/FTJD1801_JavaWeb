package sinhvien.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sinhvien.dao.SinhVienDAO;
import sinhvien.entity.SinhVien;

/**
 * Servlet implementation class FormUpdate
 */
@WebServlet("/FormUpdate")
public class FormUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    SinhVienDAO sinhVienDAO   = new SinhVienDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int currentPage = 0;
		if(request.getParameter("page")!=null) {
			 currentPage=Integer.parseInt(request.getParameter("page"));
		}
		
		int id = Integer.parseInt(request.getParameter("id"));
		SinhVien sinhvien = new SinhVien();	
		sinhvien = sinhVienDAO.select(id);
		
		request.getSession().setAttribute("currentPageSs", currentPage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("sinhvien", sinhvien);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/FormUpdate.jsp");
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
