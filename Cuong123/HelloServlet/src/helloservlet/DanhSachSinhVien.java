package helloservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLDocument.HTMLReader.FormAction;

import object.SinhVien;

/**
 * Servlet implementation class DanhSachSinhVien
 */
@WebServlet("/qlsv/*")
public class DanhSachSinhVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ArrayList<SinhVien> dsSinhVien = new ArrayList<>();
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhSachSinhVien() {
        super();
        // TODO Auto-generated constructor stub
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		
		String action = "";
		action = (request.getPathInfo() != null ? request.getPathInfo() : (request.getServletPath() != null ? request.getServletPath() : "/"));
		
		try {
			switch (action) {
			/*case "/new":
				addStudent(request, response);
				break;*/
				
			case "/insert":
				insertStudent(request, response);
				break;

			case "/delete":
				deleteStudent(request, response);
				break;
				
			case "/editInsert":
				showAddFormInsert(request, response);
				break;
				
			case "/editUpdate":
				showAddFormUpdate(request, response);
				break;
				
			case "/editDelete":
				showAddFormDelete(request, response);
				break;
				
			case "/update":
				updateStudent(request, response);
				break;
				
			/*case "/index":
				listStudent(request, response);
				break;*/
				
			default:
				listStudent(request, response);
				break;
				
			}
		} catch (Exception ex) {
			//
		}
		
	}

	

	private void showAddFormDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		SinhVien sinhvien = new SinhVien();
		for(SinhVien sv : dsSinhVien) {
			if(sv.getiD()==id) {
				sinhvien=sv;
				break;
			}
		}
		
		out.println(
				"<form action=\"delete\" method=\"GET\">"+
				"<br>ID: <input type=\"text\" name=\"id3\" value = \"" +sinhvien.getiD() +"\" readonly/>"+
				"<br>Họ Tên: " +sinhvien.getHoTen() +
				"<br>Năm Sinh: " +sinhvien.getNamSinh() +
				"<br><input type=\"submit\" value=\"Submit\" />"+
//"<a href=\"url_to_delete\" onclick=\"return confirm('Are you sure you want to delete this item?');\">Delete</a>"+
				"</form>"); 
	}

	
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("id3") != null) {
			
			int id3 = Integer.parseInt(request.getParameter("id3"));
		
			for (SinhVien sv : dsSinhVien) {
				if (sv.getiD() == id3) {
					dsSinhVien.remove(sv);
					break;
				}
			}
			listStudent(request, response);
		}
	}

	private void showAddFormUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
int id = Integer.parseInt(request.getParameter("id"));
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		SinhVien sinhvien = new SinhVien();
		for(SinhVien sv : dsSinhVien) {
			if(sv.getiD()==id) {
				sinhvien=sv;
				break;
			}
		}
		
		out.println(
				"<form action=\"update\" method=\"GET\">"+

				
				"<br>ID: <input type=\"text\" name=\"id2\" value = '" +sinhvien.getiD() +"' readonly />"+
				"<br>Họ Tên: <input type=\"text\" name=\"firstName2\" value = '" +sinhvien.getHoTen() +"' />"+
				"<br>Năm Sinh: <input type=\"text\" name=\"age2\" value = \"" +sinhvien.getNamSinh() +"\" />"+
				"<br><input type=\"submit\" value=\"Submit\" />"+
				"<a href=\"list\"> Cancel</a>"+
				"</form>"); 
	}


	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("firstName2") != null && request.getParameter("age2") != null
		&& request.getParameter("id2") != null) {
	Calendar calendar2 = Calendar.getInstance();
	int namHienTai2 = calendar2.get(Calendar.YEAR);
	int id2 = Integer.parseInt(request.getParameter("id2"));
	int tuoi2 = namHienTai2 - Integer.parseInt(request.getParameter("age2"));
	String ten2 = request.getParameter("firstName2");

	for (SinhVien sv : dsSinhVien) {
		if (sv.getiD() == id2) {
			sv.setHoTen(ten2);
			sv.setNamSinh(tuoi2);

		}
	}
}
		
		listStudent(request, response);

	}
	
	private void showAddFormInsert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println(
				"<form action=\"insert\" method=\"GET\">"+
				"ID: <input type=\"text\" name=\"id\" />"+
				"<br>Họ Tên: <input type=\"text\" name=\"firstName\" />"+
				"<br>Năm sinh : <input type=\"text\" name=\"age\" />"+
				"<br><input type=\"submit\" value=\"Submit\" name=\"submitAction\" />"+
				"<br><input type=\"submit\" value=\"Cancel\" name=\"submitAction\"/>"+
				"</form>"); 


				
	}
	
	
	private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		//Thêm
		if(request.getParameter("submitAction").equals("Submit")) {
			if (request.getParameter("firstName") != null && request.getParameter("age") != null
					&& request.getParameter("id") != null) {
				Calendar calendar = Calendar.getInstance();
				int namHienTai = calendar.get(Calendar.YEAR);
				int id = Integer.parseInt(request.getParameter("id"));
				int tuoi = namHienTai - Integer.parseInt(request.getParameter("age"));
				String ten = request.getParameter("firstName");

				dsSinhVien.add(new SinhVien(ten, tuoi, id));

			}
			listStudent(request, response);
		}
		if(request.getParameter("submitAction").equals("Cancel")) {
			listStudent(request, response);
		}
		
	}
	
	private void listStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		
		PrintWriter out = response.getWriter();
		out.println("<html>" + "<head>" + "<title></title>Thông tin sinh viên " + "</head>" + "<body>"
				+ "<br><a href=\"editInsert\"> Thêm Sinh Viên</a>" + "<table border=\"1\">" + "<tr>"
				+ "<td width=\"50px\">id</td>" + "<td width=\"200px\">Họ tên</td>" + "<td width=\"50px\">Tuổi</td>"
				+ "<td width=\"100px\">Action</td>" + "</tr>");

		int i = 0;
		for (SinhVien sv : dsSinhVien) {
			i++;
			out.println("<table border=\"1\" >" + "<tr>" + "<td width=\"50px\">" + sv.getiD() + "</td>"
					+ "<td width=\"200px\">" + sv.getHoTen() + "</td>" + "<td width=\"50px\">" + sv.getNamSinh()
					+ "</td>" + "<td width=\"100px\"><a href= \"editUpdate?id=" + sv.getiD() + "\">Sửa</a>" + "<a href= \"editDelete?id=" + sv.getiD() + "\">Xóa</a>" +

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
