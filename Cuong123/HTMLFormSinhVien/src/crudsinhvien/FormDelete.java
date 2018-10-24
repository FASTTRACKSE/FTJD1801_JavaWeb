package crudsinhvien;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SinhVien2;

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
		ArrayList<SinhVien2> dsSinhVien = (ArrayList<SinhVien2>) request.getSession().getAttribute("dsSinhVien");
		
		int id = Integer.parseInt(request.getParameter("id"));	
		PrintWriter out = response.getWriter();
		SinhVien2 sinhvien = new SinhVien2();
		for(SinhVien2 sv : dsSinhVien) {
			if(sv.getiD()==id) {
				sinhvien=sv;
				break;
			}
		}
		
		out.println(
				"<form action=\"Delete\" method=\"GET\">"+
				"<br>ID: <input type=\"text\" name=\"id3\" value = \"" +sinhvien.getiD() +"\" readonly/>"+
				"<br>Họ Tên: " +sinhvien.getHoTen() +
				"<br>Tuoi: " +sinhvien.getNamSinh() +
				"<br><input type=\"submit\" value=\"Submit\" />"+
				"<a href=\"DanhSachSinhVien2\" onclick=\"return confirm('Are you sure you want to return');\">Cancel</a>"+
				"</form>"); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
