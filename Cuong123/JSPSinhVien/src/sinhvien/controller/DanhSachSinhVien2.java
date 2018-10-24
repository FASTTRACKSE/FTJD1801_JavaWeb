package sinhvien.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sinhvien.entity.SinhVien;

/**
 * Servlet implementation class DanhSachSinhVien2
 */
@WebServlet("/DanhSachSinhVien2")
public class DanhSachSinhVien2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<SinhVien> dsSinhVien = new ArrayList<>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhSachSinhVien2() {
        super();
       	
    }	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
	
		HttpSession session = request.getSession();
		session.setAttribute("dsSinhVien", dsSinhVien);	
		

		request.setAttribute("student_list", dsSinhVien);
		request.setAttribute("uploadFileName1", request.getSession().getAttribute("uploadFileName"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("List.jsp");
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
