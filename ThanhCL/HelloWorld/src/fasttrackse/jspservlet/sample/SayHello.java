package fasttrackse.jspservlet.sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SayHello
 */
@WebServlet("/SayHello")
public class SayHello extends HttpServlet {
	private static final long serialVersionUID = 1L;    
	private ArrayList<String> dsSinhVien = new ArrayList<String>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SayHello() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		String theName = request.getParameter("hovaten");
		dsSinhVien.add(theName);
		int theAge = 2018 - Integer.parseInt(request.getParameter("namsinh"));

		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>Ung dung Hello World Servlet cua toi</title></head><body>");
		out.println("<h1>FastTrackSE hân hạnh chào bạn " + theName + " </h1>");
		out.println("<h2>Bạn năm nay " + theAge + " tuổi nhỉ!!!</h2>");
		
		for (String theNameInArray : dsSinhVien) {
			out.println("<h3>" + theNameInArray + "</h3>");
		}
		
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
