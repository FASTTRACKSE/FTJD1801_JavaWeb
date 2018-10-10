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
 * Servlet implementation class SVUpdate
 */
@WebServlet("/update")
public class SVUpdate extends HttpServlet {
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
	public SVUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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
					if (fileItem.getFieldName().equals("idUpdate")) {
						id = Integer.parseInt(fileItem.getString());

					} else if (fileItem.getFieldName().equals("nameUpdate")) {
						name = fileItem.getString("UTF-8");

					} else if (fileItem.getFieldName().equals("birthdayUpdate")) {
						birthday = Integer.parseInt(fileItem.getString());

					}
				} else {
					if (!fileItem.getName().equals("")) {
						String uploadFileName = fileItem.getName();
						uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf(File.separator) + 1,
								uploadFileName.length());
						File file = new File(uploadPath + File.separator + uploadFileName);
						System.out.println("Absolute Path at server=" + file.getAbsolutePath());
						fileItem.write(file);
						fileItem.write(file);
						avatar = uploadFileName;
					} else {
						avatar = "";
					}
				}
			}
		} catch (FileUploadException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		SinhVien sv = new SinhVien(id, name, birthday, avatar);
		studentDAO.updateSinhVien(sv);
		doGet(request, response);

	}

}
