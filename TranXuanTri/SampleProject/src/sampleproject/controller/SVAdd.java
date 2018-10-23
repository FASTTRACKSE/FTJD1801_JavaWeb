package sampleproject.controller;

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

import sampleproject.dao.SinhVienDAO;
import sampleproject.entity.SinhVien;

/**
 * Servlet implementation class SVAdd
 */
@WebServlet("/insert")
public class SVAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SinhVienDAO studentDAO = new SinhVienDAO();
	private ServletFileUpload uploader = null;
	private static final String SAVE_DIR = "image";

	@Override
	public void init() throws ServletException {
		DiskFileItemFactory fileFactory = new DiskFileItemFactory();

		fileFactory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		this.uploader = new ServletFileUpload(fileFactory);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SVAdd() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/SampleProject/list");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		int id = 0;
		String name = null;
		int birthday = 0;
		String avatar = null;

		String uploadPath = getServletContext().getRealPath("/") + File.separator + SAVE_DIR;

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
						if (!fileItem.getString().equals("")) {
							id = Integer.parseInt(fileItem.getString());
						}
					} else if (fileItem.getFieldName().equals("name")) {
						if (!fileItem.getString().equals("")) {
							name = fileItem.getString("UTF-8");
						}
					} else if (fileItem.getFieldName().equals("birthday")) {
						if (!fileItem.getString().equals("")) {
							birthday = Integer.parseInt(fileItem.getString());
						}
					}
				} else {
					if (!fileItem.getString().equals("")) {
					String uploadFileName = fileItem.getName();
					uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf(File.separator) + 1,
							uploadFileName.length());
					File file = new File(uploadPath + File.separator + uploadFileName);
					fileItem.write(file);
					fileItem.write(file);
					avatar = uploadFileName;
					} 
				}
			}
		} catch (FileUploadException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		if (id!=0 && name != null && birthday != 0 && avatar != null) {
		SinhVien sv = new SinhVien(id, name, birthday, avatar);
		studentDAO.addNewSinhVien(sv);
		}
		doGet(request, response);
	}

}
