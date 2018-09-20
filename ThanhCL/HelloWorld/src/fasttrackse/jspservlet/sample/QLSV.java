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
 * Servlet implementation class QLSV
 */
@WebServlet("/QLSV")
public class QLSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<SinhVien> dsSinhVien = new ArrayList<SinhVien>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QLSV() {
        super();
        
        dsSinhVien.add(new SinhVien(1, "Thành", 1977));
        dsSinhVien.add(new SinhVien(2, "Thành 2", 1986));
        dsSinhVien.add(new SinhVien(3, "Thành 3", 1999));
        dsSinhVien.add(new SinhVien(4, "Thành 4", 1997));
        dsSinhVien.add(new SinhVien(5, "Thành 5", 1993));

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		request.getSession().setAttribute("shareDsSinhVien", dsSinhVien);
		
		PrintWriter out = response.getWriter();

		String header = "<!doctype html>\n" 
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

		out.println(header);
		out.println("<h1>Danh sách sinh viên</h1>");
		out.println("<h3><a href='addsinhvien'>Thêm mới</a></h1>");
		
		String tableHeader = "<table class=\"table\">\n" 
				+ "  <caption>Danh sách sinh viên FFSE</caption>\n"
				+ "  <thead>\n" 
				+ "    <tr>\n" 
				+ "      <th scope=\"col\">#</th>\n"
				+ "      <th scope=\"col\">Họ và tên</th>\n" 
				+ "      <th scope=\"col\">Tuổi</th>\n" 
				+ "      <th scope=\"col\">Thao tác</th>\n" 
				+ "    </tr>\n"
				+ "  </thead>\n" 
				+ "  <tbody>";

		out.println(tableHeader);

		// Hiển thị danh sách sinh viên
		int i = 0;
		for (SinhVien sv : dsSinhVien) {
			i++;
			out.println("<tr><th scope=\"row\">" + i + "</th><td>" + sv.getHoTen() + "</td><td>" + (2018 - sv.getNamSinh())
					+ "</td><td><a href=\"editsinhvien?id=" + sv.getID() + "\">Sửa</a></td></tr>");
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
