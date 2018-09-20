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
 * Servlet implementation class QuanLySinhVienRF
 */
@WebServlet("/qlsv2/*")
public class QuanLySinhVienRF extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ArrayList<SinhVien> dsSinhVien = new ArrayList<SinhVien>();
	String baseURL = "";
	int page = 1;
	int perPage = 5;
	int totalPage = 1;
	String lastAction = "";


	int randomWithRange(int min, int max)
	{
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
	}
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QuanLySinhVienRF() {
		super();
		// Khởi tạo danh sách sinh viên nháp
		for (int i=0; i<32; i++) {
			dsSinhVien.add(new SinhVien(i+1, "Cao Lê Thành " + (i+1), randomWithRange(1970, 1999)));
		}	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		if (request.getParameter("action") != null) {
			lastAction = request.getParameter("action");
		}

		String action = "";
		baseURL = request.getContextPath() + request.getServletPath() + "/";
		action = (request.getPathInfo() != null ? request.getPathInfo() : (request.getServletPath() != null ? request.getServletPath() : "/"));
		
		try {
			switch (action) {
			case "/new":
				showAddForm(request, response);
				break;
				
			case "/insert":
				addStudent(request, response);
				break;

			case "/delete":
				deleteStudent(request, response);
				break;
				
			case "/edit":
				showEditForm(request, response);
				break;
				
			case "/update":
				updateStudent(request, response);
				break;
				
			case "/index":
				listStudent(request, response);
				break;
				
			default:
				listStudent(request, response);
				break;
				
			}
		} catch (Exception ex) {
			//
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void listStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		totalPage = (int) Math.ceil( dsSinhVien.size() * 1.0 / perPage);

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		else {
			if (lastAction.equals("save")) {
				page = totalPage;
			} else if (!(lastAction.equals("update") || lastAction.equals("cancel") || lastAction.equals("delete"))) {
				page = 1;
			}
		}
		
		if (totalPage < 1) {
			totalPage = 1;
		}

		if (page > totalPage) {
			page = totalPage;
		}
		
		if (page < 1) {
			page = 1;
		}
		
		PrintWriter out = response.getWriter();

		String content = "<!doctype html>\n" + "<html lang=\"en\">\n" + "  <head>\n"
				+ "    <!-- Required meta tags -->\n" + "    <meta charset=\"utf-8\">\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n"
				+ "    <!-- Bootstrap CSS -->\n"
				+ "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n"
				+ "	   <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.3.1/css/all.css\" integrity=\"sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU\" crossorigin=\"anonymous\">"
				+ "<title>Chương trình quản lý sinh viên</title>\n" + "</head>\n"
				+ "<body><main role=\"main\" class=\"container\">\n";

		out.println(content);
		out.println("<h1>Danh sách sinh viên</h1>");
		out.println("<h3><a href='new'>Thêm mới</a></h1>");

		String tableContent = "<table class=\"table\">\n" 
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

		out.println(tableContent);
		
		int i = (page - 1) * perPage;
		int j = 0;
		
		while ((j < perPage) && ((j + i) < dsSinhVien.size())) {
			SinhVien sv = dsSinhVien.get(i+j);
			
			out.println("<tr><th scope=\"row\">" + (i+j+1) + "</th><td>" 
					+ sv.getHoTen() + "</td><td>"
					+ (2018 - sv.getNamSinh()) + "</td><td><a href=\"edit?studentID=" 
					+ sv.getID() + "\"><i class=\"fa fa-edit\"></i></a>&nbsp;&nbsp;<a href=\"delete?studentID=" 
					+ sv.getID() + "\" onclick=\"return confirm('Are you sure you want to delete this item?');\"><i class=\"fa fa-trash-alt\"></i></a></td></tr>");
			
			j++;
		}
		
		out.println("</table>");
		
		String firstPage 	= "    <li class=\"page-item\"><a class=\"page-link\" href=\"" + baseURL + "?page=" + 1 + "\" tabindex=\"-1\">&laquo;</a></li>\n";
		String pageIndex1 	= "    <li class=\"page-item\"><a class=\"page-link\" href=\"" + baseURL + "?page=" + (page-1) + "\">" + (page-1) + "</a></li>\n";
		String pageIndex2 	= "    <li class=\"page-item active\"><a class=\"page-link\" href=\"" + baseURL + "?page=" + page + "\">" + (page) + "<span class=\"sr-only\">(current)</span></a></li>\n";
		String pageIndex3 	= "    <li class=\"page-item\"><a class=\"page-link\" href=\"" + baseURL + "?page=" + (page+1) + "\">" + (page+1) + "</a></li>\n";
		String lastPage 	= "    <li class=\"page-item\"><a class=\"page-link\" href=\"" + baseURL + "?page=" + totalPage + "\">&raquo;</a></li>\n";
		
		if (page <= 1) {
			pageIndex1 = "";
		}
		
		if (page >= totalPage) {
			pageIndex3 = "";
		}

		String pagingContent = "<nav aria-label=\"Pagination\">\n" + 
				"  <ul class=\"pagination justify-content-end\">\n" + 
				firstPage + 
				pageIndex1 + 
				pageIndex2 + 
				pageIndex3 + 
				lastPage + 
				"  </ul>\n" + 
				"</nav>";
		out.println(pagingContent);
		out.println("</main><footer class=\"footer\">\n" 
				+ "      <div class=\"container\">\n"
				+ "        <span class=\"text-muted\">FastTrackSE @ 2018</span>\n" 
				+ "      </div>\n"
				+ "    </footer>\n" 
				+ "</body></html>");
		lastAction = "";
	}

	private void showAddForm(HttpServletRequest request, HttpServletResponse response)
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
		
		String formInput = "<form action=\"insert\" method=\"POST\">\n" + 
				"  <div class=\"form-group\">\n" + 
				"    <label for=\"hovaten\">Họ và Tên</label>\n" + 
				"    <input type=\"text\" class=\"form-control\" id=\"hovaten\" name=\"hovaten\" aria-describedby=\"hovatenHelp\" placeholder=\"Họ và tên Sinh Viên\">\n" + 
				"    <small id=\"hovatenHelp\" class=\"form-text text-muted\">Họ tên đầy đủ và có dấu nha các bạn</small>\n" + 
				"  </div>\n" + 
				"  <div class=\"form-group\">\n" + 
				"    <label for=\"namsinh\">Năm sinh</label>\n" + 
				"    <input type=\"number\" class=\"form-control\" id=\"namsinh\" name=\"namsinh\" placeholder=\"Năm sinh\">\n" + 
				"  </div>\n" + 
				"  <button type=\"submit\" class=\"btn btn-primary\" name=\"action\" value=\"addnew\">Add New</button>\n" + 
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

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int editedID = Integer.parseInt(request.getParameter("studentID"));

		SinhVien sv = new SinhVien();
		
		for (int i=0; i< dsSinhVien.size(); i++) {
			if (dsSinhVien.get(i).getID() == editedID) {
				sv = dsSinhVien.get(i);
				break;
			}
		}
		
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
		
		String formInput = "<form action=\"update\" method=\"POST\">\n" + 
				"  <div class=\"form-group\">\n" + 
				"    <label for=\"hovaten\">Mã Sinh Viên</label>\n" + 
				"    <input type=\"text\" class=\"form-control\" id=\"masinvien\" name=\"masinvien\" value=\"" + sv.getID() + "\" placeholder=\"ID Sinh Viên\" readonly>\n" + 
				"    <label for=\"hovaten\">Họ và Tên</label>\n" + 
				"    <input type=\"text\" class=\"form-control\" id=\"hovaten\" name=\"hovaten\" aria-describedby=\"hovatenHelp\" value=\"" + sv.getHoTen() + "\" placeholder=\"Họ và tên Sinh Viên\">\n" + 
				"    <small id=\"hovatenHelp\" class=\"form-text text-muted\">Họ tên đầy đủ và có dấu nha các bạn</small>\n" + 
				"  </div>\n" + 
				"  <div class=\"form-group\">\n" + 
				"    <label for=\"namsinh\">Năm sinh</label>\n" + 
				"    <input type=\"number\" class=\"form-control\" id=\"namsinh\" name=\"namsinh\" value=\"" + sv.getNamSinh() + "\" placeholder=\"Năm sinh\">\n" + 
				"  </div>\n" + 
				"  <button type=\"submit\" class=\"btn btn-primary\" name=\"action\" value=\"save\">Save</button>\n" + 
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

	private void addStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		if (request.getParameter("action") != null && request.getParameter("action").equals("addnew")) {
			String theName = request.getParameter("hovaten");
			int theNamSinh = Integer.parseInt(request.getParameter("namsinh"));
			int theNewID;
			if (dsSinhVien.size() < 1) {
				theNewID = 1;
			} else {
				theNewID = dsSinhVien.get(dsSinhVien.size() - 1).getID() + 1;				
			}

			dsSinhVien.add(new SinhVien(theNewID, theName, theNamSinh));
			lastAction = "save";
		}
		else {
			lastAction = "cancel";
		}
		
		response.sendRedirect(baseURL);
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		if (request.getParameter("action") != null && request.getParameter("action").equals("save")) {
			
			int theID = Integer.parseInt(request.getParameter("masinvien"));
			String theName = request.getParameter("hovaten");
			int theNamSinh = Integer.parseInt(request.getParameter("namsinh"));
			
			for (SinhVien sv : dsSinhVien) {
				if (sv.getID() == theID) {
					sv.setHoTen(theName);
					sv.setNamSinh(theNamSinh);
					break;
				}
			}
		}
		lastAction = "update";
		response.sendRedirect(baseURL);
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int deletedID = Integer.parseInt(request.getParameter("studentID"));

		int deletedSinhVienIndex = -1;
		
		for (int i=0; i< dsSinhVien.size(); i++) {
			if (dsSinhVien.get(i).getID() == deletedID) {
				deletedSinhVienIndex = i;
				break;
			}
		}
		
		if (deletedSinhVienIndex > -1) {
			dsSinhVien.remove(deletedSinhVienIndex);
		}
		lastAction = "delete";
		response.sendRedirect(baseURL);
	}

	public void removeSameNumber() {
		int[] b = new int[100000];
		int[] c = new int[100000];
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		b = new int[]{0};
		c = new int[]{0};
		for (int i = 0; i <= arr.size() - 1;) {
			int x = arr.get(i);
			if (x >= 0)
				if (b[x] == 1)
					arr.remove(i);
				else {
					b[x] = 1;
					i++;
				}
			else {
				x = Math.abs(x);
				if (c[x] == 1)
					arr.remove(i);
				else {
					c[x] = 1;
					i++;
				}
			}
		}
	}
}
