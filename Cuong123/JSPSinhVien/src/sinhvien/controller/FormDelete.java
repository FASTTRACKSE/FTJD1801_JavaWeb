package sinhvien.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class FormDelete
 */
@WebServlet("/FormDelete")
public class FormDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		ArrayList<SinhVien> dsSinhVien = (ArrayList<SinhVien>) request.getSession().getAttribute("dsSinhVien");
		
		int id = Integer.parseInt(request.getParameter("id"));	
		PrintWriter out = response.getWriter();
		SinhVien sinhvien = new SinhVien();
			for(SinhVien sv : dsSinhVien) {
			if(sv.getiD()==id) {
				sinhvien=sv;
				break;
			}
		}
		
		request.setAttribute("sinhvien", sinhvien);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/FormDelete.jsp");
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
