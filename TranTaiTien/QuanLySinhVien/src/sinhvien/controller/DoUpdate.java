package sinhvien.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import sinhvien.dao.SinhVienDAO;
import sinhvien.entity.SinhVien;

/**
 * Servlet implementation class DoUpdate
 */
@WebServlet("/do_update")
public class DoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	SinhVienDAO studentDAO = new SinhVienDAO();
	private final String UPLOAD_DIRECTORY = "uploads";
	private ServletFileUpload uploader = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() throws ServletException {
		// configures upload settings
		DiskFileItemFactory fileFactory = new DiskFileItemFactory();

		// sets temporary location to store files
		fileFactory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		// create
		this.uploader = new ServletFileUpload(fileFactory);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = 0;
		String name = null;
		int namsinh = 0;
		String link = null;
		String avatar = null;

		String uploadPath = getServletContext().getRealPath("/") + File.separator + UPLOAD_DIRECTORY;

		// creates the directory if it does not exist
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		try {
			List<FileItem> fileItemsList = uploader.parseRequest(request);
			Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();

			while (fileItemsIterator.hasNext()) {
				FileItem fileItem = fileItemsIterator.next();
				if (fileItem.isFormField()) {

					if (fileItem.getFieldName().equals("id")) {
						id = Integer.parseInt(fileItem.getString());
					} else if (fileItem.getFieldName().equals("hoten")) {
						name = fileItem.getString("UTF-8");
					} else if (fileItem.getFieldName().equals("namsinh")) {
						namsinh = Integer.parseInt(fileItem.getString());
					} else if(fileItem.getFieldName().equals("oldFile")) {
						avatar = fileItem.getString("UTF-8");
					}
				} else {
					if (!fileItem.getName().equals("")) {
						System.out.println("FieldName=" + fileItem.getFieldName());
						System.out.println("FileName=" + fileItem.getName());
						System.out.println("ContentType=" + fileItem.getContentType());
						System.out.println("Size in bytes=" + fileItem.getSize());

						File file = new File(uploadPath + File.separator + fileItem.getName());
						System.out.println("Absolute Path at server=" + file.getAbsolutePath());
						fileItem.write(file);
						link = fileItem.getName();
					} else {
						link = "";
					}
				}
			}
		} catch (FileUploadException e) {
			System.out.println("Exception in uploading file.");
		} catch (Exception e) {
			System.out.println("Exception in uploading file.");
		}
		
		if (!link.equals("")) {
			SinhVien sinhVien = new SinhVien(id, name, namsinh, link);
			studentDAO.updateSinhVien(sinhVien);
		} else {
			SinhVien sinhVien = new SinhVien(id, name, namsinh, avatar);
			studentDAO.updateSinhVien(sinhVien);
		}

		response.sendRedirect("list");
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
