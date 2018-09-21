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
 * Servlet implementation class DeleteStudent
 */
@WebServlet("/delete")
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudent() {
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
		if (request.getSession().getAttribute("students_list") != null) {
			dsSinhVien = (ArrayList<SinhVien>) request.getSession().getAttribute("students_list");
		} 
		int id = Integer.parseInt(request.getParameter("idDelete"));
		if (id != 0 && dsSinhVien != null) {
			for (SinhVien sv : dsSinhVien) {
				if (sv.getId() == id) {
					dsSinhVien.remove(sv);
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
