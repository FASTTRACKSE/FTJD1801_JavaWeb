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
 * Servlet implementation class DanhSachSinhVien
 */
@WebServlet("/list")
public class DanhSachSinhVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<SinhVien> dsSinhVien = new ArrayList<SinhVien>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DanhSachSinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		if (request.getParameter("action") != null && request.getParameter("action").equals("submit")) {
			String theName = request.getParameter("hovaten");
			int theNamSinh = Integer.parseInt(request.getParameter("namsinh"));

			dsSinhVien.add(new SinhVien(dsSinhVien.size()+1, theName, theNamSinh));
		}

		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		String content = "<!doctype html>\n" 
				+ "<html lang=\"en\">\n" 
				+ "  <head>\n"
				+ "    <!-- Required meta tags -->\n" 
				+ "    <meta charset=\"utf-8\">\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n"
				+ "    <!-- Bootstrap CSS -->\n"
				+ "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n"
				+ "<title>Chương trình quản lý sinh viên</title>\n" 
				+ "</head>\n" 
				+ "<body><main role=\"main\" class=\"container\">\n";

		out.println(content);
		out.println("<h1>Danh sách sinh viên</h1>");
		out.println("<h3><a href='addsinhvien'>Thêm mới</a></h1>");
		
		String tableContent = "<table class=\"table\">\n" 
				+ "  <caption>Danh sách sinh viên FFSE</caption>\n"
				+ "  <thead>\n" 
				+ "    <tr>\n" 
				+ "      <th scope=\"col\">#</th>\n"
				+ "      <th scope=\"col\">Họ và tên</th>\n" 
				+ "      <th scope=\"col\">Tuổi</th>\n" 
				+ "    </tr>\n"
				+ "  </thead>\n" 
				+ "  <tbody>";

		out.println(tableContent);
		int i = 0;
		for (SinhVien sv : dsSinhVien) {
			i++;
			out.println("<tr><th scope=\"row\">" + i + "</th><td>" + sv.getHoTen() + "</td><td>" + (2018 - sv.getNamSinh())
					+ "</td></tr>");
		}
		out.println("</table>");
		out.println("</main><footer class=\"footer\">\n" + 
				"      <div class=\"container\">\n" + 
				"        <span class=\"text-muted\">FastTrackSE @ 2018.</span>\n" + 
				"      </div>\n" + 
				"    </footer>\n" + 
				"</body></html>");
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
