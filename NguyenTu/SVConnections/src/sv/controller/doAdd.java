package sv.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import sv.dao.SinhVienDAO;
import sv.entity.SinhVien;

/**
 * Servlet implementation class doAdd
 */
@WebServlet("/doAdd")
public class doAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SinhVienDAO  sinhVienDAO = new SinhVienDAO();
    
	private static final String UPLOAD_DIRECTORY = "uploads";
	private ServletFileUpload uploader = null;
	 
    public doAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    @Override
    public void init() throws SecurityException{
    	// configures upload settings
    			DiskFileItemFactory fileFactory = new DiskFileItemFactory();
    			
    			// sets temporary location to store files
    			fileFactory.setRepository(new File(System.getProperty("java.io.tmpdir")));
    			
    			// create 
    			this.uploader = new ServletFileUpload(fileFactory);
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		request.setCharacterEncoding("UTF-8");

		
		int id = 0;
		String hoTen = null;
		String namSinh = null;
		String image = null;

		SinhVien sinhVien = new SinhVien(id, hoTen, namSinh,image);
		sinhVienDAO.addNewSinhVien(sinhVien);
		response.sendRedirect("sv");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
