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
 * Servlet implementation class FormDelete
 */
@WebServlet("/FormDelete")
public class FormDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    SinhVienDAO sinhVienDAO = new SinhVienDAO();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page = 0;
		if(request.getParameter("page")!=null) {
			 page =  Integer.parseInt(request.getParameter("page"));	
		}
	
		int id = Integer.parseInt(request.getParameter("id"));	
		SinhVien sinhvien = new SinhVien();
		sinhvien = sinhVienDAO.select(id);
		
		request.getSession().setAttribute("pageDelete", page);
		request.setAttribute("sinhvien", sinhvien);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/FormDelete.jsp");
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
