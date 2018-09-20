package fasttrackse.jspservlet.sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QuanLySinhVien
 */
@WebServlet("/addsinhvien")
public class QuanLySinhVien extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QuanLySinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String content = "<!doctype html>\n" 
				+ "<html lang=\"en\">\n" 
				+ "  <head>\n"
				+ "    <!-- Required meta tags -->\n" 
				+ "    <meta charset=\"utf-8\">\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n"
				+ "    <!-- Bootstrap CSS -->\n"
				+ "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n"
				+ "<title>Thêm mới sinh viên</title>\n" 
				+ "</head>\n"
				+ "<body><main role=\"main\" class=\"container\">\n" 
				+ "	<h1>Thông tin sinh viên</h1>\n";
		
		String formInput = "<form action=\"list\" method=\"POST\">\n" + 
				"  <div class=\"form-group\">\n" + 
				"    <label for=\"hovaten\">Họ và Tên</label>\n" + 
				"    <input type=\"text\" class=\"form-control\" id=\"hovaten\" name=\"hovaten\" aria-describedby=\"hovatenHelp\" placeholder=\"Họ và tên Sinh Viên\">\n" + 
				"    <small id=\"hovatenHelp\" class=\"form-text text-muted\">Họ tên đầy đủ và có dấu nha các bạn</small>\n" + 
				"  </div>\n" + 
				"  <div class=\"form-group\">\n" + 
				"    <label for=\"namsinh\">Năm sinh</label>\n" + 
				"    <input type=\"number\" class=\"form-control\" id=\"namsinh\" name=\"namsinh\" placeholder=\"Năm sinh\">\n" + 
				"  </div>\n" + 
				"  <button type=\"submit\" class=\"btn btn-primary\" name=\"action\" value=\"submit\">Submit</button>\n" + 
				"  <button type=\"input\" class=\"btn btn-primary\" name=\"action\" value=\"cancel\">Cancel</button>\n" + 
				"</form>";
		String footer = "</main><footer class=\"footer\">\n" 
				+ "      <div class=\"container\">\n"
				+ "        <span class=\"text-muted\">FastTrackSE @ 2018</span>\n" 
				+ "      </div>\n"
				+ "    </footer>\n" 
				+ "</body></html>";

		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println(content);
		out.println(formInput);
		out.println(footer);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
