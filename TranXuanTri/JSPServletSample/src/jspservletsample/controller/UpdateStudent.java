package jspservletsample.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspservletsample.entity.SinhVien;

/**
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/update")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<SinhVien> dsSinhVien = new ArrayList<SinhVien>();
		dsSinhVien = (ArrayList<SinhVien>) request.getSession().getAttribute("students_list");
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int idUpdate = Integer.parseInt(request.getParameter("idUpdate"));
		String nameUpdate = request.getParameter("nameUpdate");
		int birthdayUpdate = Integer.parseInt(request.getParameter("birthdayUpdate"));
		
		if (dsSinhVien != null) {
			for (SinhVien sv : dsSinhVien) {
				if (sv.getId() == idUpdate) {
					sv.setHoTen(nameUpdate);
					sv.setNamSinh(birthdayUpdate);
					break;
				}
			}
		}

		response.sendRedirect("/JSPServletSample/Controller");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
