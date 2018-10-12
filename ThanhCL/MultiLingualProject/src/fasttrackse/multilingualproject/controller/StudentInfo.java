package fasttrackse.multilingualproject.controller;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fasttrackse.multilingualproject.entity.Student;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentInfo")
public class StudentInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentInfo() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Student student_en = new Student(1, "Cao Le Thanh", 1977, "thanhcl.jpg");
		Student student_vi = new Student(1, "Cao Lê Thành", 1977, "thanhcl.jpg");
		Student student_ja = new Student(1, "Kao Re Tain", 1977, "thanhcl.jpg");
		
		//Locale locale = request.getLocale();
		//ResourceBundle bundle = ResourceBundle.getBundle("fasttrackse.multilingualproject.resources.languagepack", locale);
		String language = "en_US";
		if (request.getSession().getAttribute("language") != null) {
			language = request.getSession().getAttribute("language").toString();
		}
		if (request.getParameter("language") != null) {
			language = request.getParameter("language").toString();
		}
		
		if (language.equals("en_US")) {
			request.getSession().setAttribute("student", student_en);			
		}
		else if (language.equals("vi_VN")) {
			request.getSession().setAttribute("student", student_vi);			
		}
		else {
			request.getSession().setAttribute("student", student_ja);			
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/student/StudentFormViewI18n.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
