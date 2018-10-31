package crudsinhvien;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SinhVien2;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ArrayList<SinhVien2> dsSinhVien = new ArrayList<>();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
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
		
		
		
		ArrayList<SinhVien2> dsSinhVien = (ArrayList<SinhVien2>) request.getSession().getAttribute("dsSinhVien");
		//Thêm
		
		
			if (request.getParameter("firstName") != null && request.getParameter("age") != null
					&& request.getParameter("id") != null) {
				Calendar calendar = Calendar.getInstance();
				int namHienTai = calendar.get(Calendar.YEAR);
				int id = Integer.parseInt(request.getParameter("id"));
				int tuoi = namHienTai - Integer.parseInt(request.getParameter("age"));
				String ten = request.getParameter("firstName");

				dsSinhVien.add(new SinhVien2(ten, tuoi, id));
				
			}
			
			
			//out.println("<meta http-equiv=\"refresh\" content=\"0;DanhSachSinhVien2\">");
			response.sendRedirect("DanhSachSinhVien2");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
