package sinhvien.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sinhvien.entity.SinhVien;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		HttpSession session = request.getSession();
		ArrayList<SinhVien> dsSinhVien = (ArrayList<SinhVien>) session.getAttribute("dsSinhVien");
	
	
		//Suawr
		if (request.getParameter("firstName2") != null && request.getParameter("age2") != null
				&& request.getParameter("id2") != null) {
			Calendar calendar2 = Calendar.getInstance();
			int namHienTai2 = calendar2.get(Calendar.YEAR);
			int id2 = Integer.parseInt(request.getParameter("id2"));
			int tuoi2 = namHienTai2 - Integer.parseInt(request.getParameter("age2"));
			String ten2 = request.getParameter("firstName2");

			for (SinhVien sv : dsSinhVien) {
				if (sv.getiD() == id2) {
					sv.setHoTen(ten2);
					sv.setNamSinh(tuoi2);
					break;
				} 
				
			}
		
		}
		
				
		
		response.sendRedirect("DanhSachSinhVien2");
		//	out.println("<meta http-equiv=\"refresh\" content=\"0;DanhSachSinhVien2\">");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
