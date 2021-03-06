package sinhvien.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<SinhVien> dsSinhVien = new ArrayList<>();
	SinhVienDAO studentDAO = new SinhVienDAO();
	private ServletFileUpload uploader = null;
	private static final String UPLOAD_DIRECTORY = "upload";

	@Override
	public void init() throws ServletException {
		DiskFileItemFactory fileFactory = new DiskFileItemFactory();
		//
		fileFactory.setRepository(new File(System.getProperty("user.dir")));

		this.uploader = new ServletFileUpload(fileFactory);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Insert() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stu
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		if (!ServletFileUpload.isMultipartContent(request)) {
			throw new ServletException("Content type is not multipart/form-data");
		}

		int id = 0;
		String hoTen = null;
		int namSinh = 0;
		String avatar = null;

		String rootPath = getServletContext().getRealPath("/") + File.separator + UPLOAD_DIRECTORY;

		File uploadFol = new File(rootPath);
		if (!uploadFol.exists()) {
			uploadFol.mkdir();
		}
		try {
			// uploader.setHeaderEncoding("UTF-8");
			List<FileItem> fileItemsList = uploader.parseRequest(request);
			Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();
			while (fileItemsIterator.hasNext()) {
				FileItem fileItem = fileItemsIterator.next();
				if (fileItem.isFormField()) {
					if (fileItem.getFieldName().equals("id")) {
						id = Integer.parseInt(fileItem.getString());
					} else if (fileItem.getFieldName().equals("hoTen")) {
						hoTen = fileItem.getString("UTF-8");
					} else if (fileItem.getFieldName().equals("namSinh")) {
						namSinh = Integer.parseInt(fileItem.getString());
					}
				} else {
					System.out.println("FieldName=" + fileItem.getFieldName());
					System.out.println("FileName=" + fileItem.getName());
					System.out.println("ContentType=" + fileItem.getContentType());
					System.out.println("Size in bytes=" + fileItem.getSize());

					File file = new File(rootPath + File.separator + fileItem.getName().substring(
							fileItem.getName().lastIndexOf(File.separator) + 1, fileItem.getName().length()));
					System.out.println("Absolute Path at server=" + file);

					avatar = file.getName().toString();
					fileItem.write(file);

				}

			}
		} catch (FileUploadException e) {
			// out.write("Exception in uploading file.");
			System.out.println(e);
		} catch (Exception e) {
			// out.write("Exception in uploading file.");
			System.out.println(e);
		}

		studentDAO.addNewSinhVien(hoTen, namSinh, id, avatar);

		response.sendRedirect("DanhSachSinhVien3");
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
