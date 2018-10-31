package sinhvien.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sinhvien.dao.SinhVienDAO;
import sinhvien.entity.SinhVien;

/**
 * Servlet implementation class DanhSachSinhVien3
 */
@WebServlet("/DanhSachSinhVien3")
public class DanhSachSinhVien3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  
	 SinhVienDAO studentDAO = new SinhVienDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhSachSinhVien3() {
        super();
       	
    }	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request	.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		

		int perPage = 3;
		int totalSinhVien = studentDAO.countSinhVien();
		int totalPage = (int) Math.ceil((float) (totalSinhVien) / perPage);
		int currentPage = 1;
		if (request.getParameter("page") != null) {
			
			if(totalPage == 0) {
				currentPage = 1;
			}else if(Integer.parseInt(request.getParameter("page")) < 1) {
				currentPage = 1;
			}else if(Integer.parseInt(request.getParameter("page")) > totalPage) {
				currentPage = totalPage;	
			}else {
				currentPage = Integer.parseInt(request.getParameter("page"));
			}
		}

		

		
	
		List<SinhVien> list = studentDAO.getRecords(currentPage, perPage);
		/*
		 * PrintWriter out = response.getWriter();
		 * out.print("<h1>Page No: "+currentPage+"</h1>");
		 * out.print("<table border='1' cellpadding='4' width='60%'>");
		 * out.print("<tr><th>Id</th><th>Họ tên</th><th>Tuổi</th>"); for(SinhVien
		 * e:list){
		 * out.print("<tr><td>"+e.getiD()+"</td><td>"+e.getHoTen()+"</td><td>"+e.
		 * getNamSinh()+"</td></tr>"); } out.print("</table>");
		 * 
		 * 
		 * if(currentPage==1) {
		 * 
		 * out.print("<a href= \"DanhSachSinhVien3?page=" + 1 + "\">  1   </a>");
		 * out.print("<a href= \"DanhSachSinhVien3?page=" + (currentPage+1) + "\">"
		 * +(currentPage+1)+"</a>"); out.print("<a href= \"DanhSachSinhVien3?page=" +
		 * (currentPage+1) + "\">  sau </a>");
		 * out.print("<a href= \"DanhSachSinhVien3?page=" + totalPage +
		 * "\">  Về cuối  </a>");
		 * 
		 * }else if(currentPage==totalPage) {
		 * out.print("<a href= \"DanhSachSinhVien3?page=" + 1 + "\">  Về đâu  </a>");
		 * out.print("<a href= \"DanhSachSinhVien3?page=" + (currentPage-1) +
		 * "\">  trước </a>"); out.print("<a href= \"DanhSachSinhVien3?page=" +
		 * (currentPage-1) + "\">" + (currentPage-1)+"</a>");
		 * out.print("<a href= \"DanhSachSinhVien3?page=" + totalPage +
		 * "\">  totalPage  </a>");
		 * 
		 * 
		 * }else { out.print("<a href= \"DanhSachSinhVien3?page=" + 1 +
		 * "\">  Về đâu  </a>"); out.print("<a href= \"DanhSachSinhVien3?page=" +
		 * (currentPage-1) + "\">  trước </a>");
		 * out.print("<a href= \"DanhSachSinhVien3?page=" + (currentPage-1) + "\">" +
		 * (currentPage-1)+"</a>"); out.print("<a href= \"DanhSachSinhVien3?page=" +
		 * currentPage + "\">"+currentPage+"</a>");
		 * out.print("<a href= \"DanhSachSinhVien3?page=" + (currentPage+1) + "\">" +
		 * (currentPage+1)+"</a>"); out.print("<a href= \"DanhSachSinhVien3?page=" +
		 * (currentPage+1) + "\">  sau </a>");
		 * out.print("<a href= \"DanhSachSinhVien3?page=" + totalPage +
		 * "\">  Về cuối  </a>");
		 * 
		 * }
		 */

		

		request.setAttribute("student_list", list);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPage", totalPage);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/List.jsp");
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
