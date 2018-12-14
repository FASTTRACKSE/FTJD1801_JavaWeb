package helloservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	request.setCharacterEncoding("UTF-8");
	//    response.setCharacterEncoding("UTF-8");
	//    response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Calendar calendar = Calendar.getInstance();
		int namHienTai = calendar.get(Calendar.YEAR);
		
		int tuoi = namHienTai - Integer.parseInt(request.getParameter("age"));
		out.println("FastTrackSE hân hạnh chào đón bạn "+ request.getParameter("firstName") + " "+request.getParameter("lastName"));		
		out.println("<br>Bạn năm nay " + tuoi + " tuổi nhỉ ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out = response.getWriter();
		
		out.println("Student Name: " + request.getParameter("firstName") + " " +
				request.getParameter("lastName")+ " " + request.getParameter("lastName"));
	}

}
