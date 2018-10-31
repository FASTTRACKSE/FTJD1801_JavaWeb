package crudsinhvien;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormAdd
 */
@WebServlet("/FormInsert")
public class FormInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println(
				"<form action=\"Insert\" method=\"GET\">"+
				"ID: <input type=\"text\" name=\"id\" />"+
				"<br>Họ Tên: <input type=\"text\" name=\"firstName\" />"+
				"<br>Năm sinh : <input type=\"text\" name=\"age\" />"+
				"<br><input type=\"submit\" value=\"Submit\" name=\"submitAction\" />"+
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
