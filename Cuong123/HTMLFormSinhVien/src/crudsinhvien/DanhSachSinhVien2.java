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
 * Servlet implementation class DanhSachSinhVien2
 */
@WebServlet("/DanhSachSinhVien2")
public class DanhSachSinhVien2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ArrayList<SinhVien2> dsSinhVien = new ArrayList<>();  
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
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		HttpSession session = request.getSession();
		session.setAttribute("dsSinhVien", dsSinhVien);	
		
		
		PrintWriter out = response.getWriter();
		out.println("<html>" + "<head>" + "<title></title>Thông tin sinh viên " + "</head>" + "<body>"
				+ "<br><a href=\"FormInsert\"> Thêm Sinh Viên</a>" + "<table border=\"1\">" + "<tr>"
				+ "<td width=\"50px\">id</td>" + "<td width=\"200px\">Họ tên</td>" + "<td width=\"50px\">Tuổi</td>"
				+ "<td width=\"100px\">Action</td>" + "</tr>");

		for (SinhVien2 sv : dsSinhVien) {
			out.println("<table border=\"1\" >" + "<tr>" + "<td width=\"50px\">" + sv.getiD() + "</td>"
					+ "<td width=\"200px\">" + sv.getHoTen() + "</td>" + "<td width=\"50px\">" + sv.getNamSinh()
					+ "</td>" + "<td width=\"100px\"><a href= \"FormUpdate?id=" + sv.getiD() + "\">Sửa</a>" + "<a href= \"FormDelete?id=" + sv.getiD() + "\">Xóa</a>" +

					"</tr>");
		}

		out.println("</table></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
