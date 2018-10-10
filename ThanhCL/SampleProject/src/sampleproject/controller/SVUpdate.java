package sampleproject.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sampleproject.dao.SinhVienDAO;
import sampleproject.entity.SinhVien;

/**
 * Servlet implementation class SVUpdate
 */
@WebServlet("/update")
public class SVUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SinhVienDAO studentDAO = new SinhVienDAO();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SVUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int idUpdate = Integer.parseInt(request.getParameter("idUpdate"));
		String nameUpdate = request.getParameter("nameUpdate");
		int birthdayUpdate = Integer.parseInt(request.getParameter("birthdayUpdate"));
		SinhVien sv = new SinhVien();
		sv.setID(idUpdate);
		sv.setHoTen(nameUpdate);
		sv.setNamSinh(birthdayUpdate);
		
		studentDAO.updateSinhVien(sv);
		response.sendRedirect("/SampleProject/list");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
