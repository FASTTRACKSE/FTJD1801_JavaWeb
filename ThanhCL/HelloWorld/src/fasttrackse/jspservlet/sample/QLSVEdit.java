package fasttrackse.jspservlet.sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fasttrackse.jspservlet.entity.SinhVien;

/**
 * Servlet implementation class QLSVEdit
 */
@WebServlet("/editsinhvien")
public class QLSVEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<SinhVien> dsSinhVien;
	

    /**
     * @see HttpServlet#HttpServlet()
     */
    public QLSVEdit() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int studentID = Integer.parseInt(request.getParameter("id"));
		dsSinhVien = (ArrayList<SinhVien>) request.getSession().getAttribute("shareDsSinhVien");	
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		SinhVien editedSV = new SinhVien();
		
		for (SinhVien sv : dsSinhVien) {
			if (sv.getID() == studentID) {
				editedSV = sv;
				break;
			}
		}
		out.println("Sinh viên cần sửa ID = " + studentID);
		out.println("<br />Họ và tên: <input type=text value=\"" + editedSV.getHoTen() + "\" />");
		out.println("<br />Năm sinh: <input type=text value=\"" + editedSV.getNamSinh() + "\" />");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
