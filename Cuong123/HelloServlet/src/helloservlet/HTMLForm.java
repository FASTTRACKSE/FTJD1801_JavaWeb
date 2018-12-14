package helloservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HTMLForm
 */
@WebServlet("/HTMLForm")
public class HTMLForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HTMLForm() {
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
		// Step 2: get the printwriter
		PrintWriter out = response.getWriter();
		// Step 3: generate HTML content
		out.println("<form action=\"StudentServlet\" method=\"GET\">");
		out.println("First name: <input type=\"text\" name=\"firstName\" />");
		out.println("<br>Last name: <input type=\"text\" name=\"lastName\" />");
		out.println("<br>Năm sinh : <input type=\"text\" name=\"age\" />");
		out.println("<br><input type=\"submit\" value=\"Submit\" />");
		out.println("</form>"); 
		
	
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
