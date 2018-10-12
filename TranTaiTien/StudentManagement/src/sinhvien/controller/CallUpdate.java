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
 * Servlet implementation class CallUpdate
 */
@WebServlet("/call_update")
public class CallUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
		SinhVienDAO studentDAO = new SinhVienDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CallUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		SinhVien sv = studentDAO.selectSinhVien(id);
		request.getSession().setAttribute("shareStudent", sv);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/sinhvien/update_sinhvien.jsp");

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
