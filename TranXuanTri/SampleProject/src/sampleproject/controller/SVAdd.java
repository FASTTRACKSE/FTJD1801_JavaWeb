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

	@Override
	public void init() throws ServletException {
		DiskFileItemFactory fileFactory = new DiskFileItemFactory();
		File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
		fileFactory.setRepository(filesDir);
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
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		SinhVien sv = new SinhVien();
		try {
			List<FileItem> fileItemsList = uploader.parseRequest(request);
			Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();
			while (fileItemsIterator.hasNext()) {
				FileItem fileItem = fileItemsIterator.next();
				if (fileItem.isFormField()) {
					if (fileItem.getFieldName().equals("id")) {
						int id = Integer.parseInt(fileItem.getString());
						sv.setId(id);
					} else if (fileItem.getFieldName().equals("name")) {
						String name = fileItem.getString();
						sv.setHoTen(name);
					} else if (fileItem.getFieldName().equals("birthday")) {
						int namSinh = Integer.parseInt(fileItem.getString());
						sv.setNamSinh(namSinh);
					}
				} else {
					if (fileItem.getContentType() != null) {
						System.out.println("FieldName=" + fileItem.getFieldName());
						System.out.println("FileName=" + fileItem.getName());
						System.out.println("ContentType=" + fileItem.getContentType());
						System.out.println("Size in bytes=" + fileItem.getSize());
						String uploadFileName = fileItem.getName();
						uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf(File.separator) + 1,
								uploadFileName.length());
						System.out.println("New file name=" + uploadFileName);
						
						File file = new File(request.getServletContext().getAttribute("FILES_DIR") + File.separator
								+ uploadFileName);
						System.out.println("Absolute Path at server=" + file.getAbsolutePath());
						fileItem.write(file);
						File file1 = new File(request.getServletContext().getAttribute("FILES_DIR") + File.separator + uploadFileName);
						if (!file1.exists()) {
							throw new ServletException("File doesn't exists on server.");
						}
						System.out.println("File location on server::" + file1.getAbsolutePath());
						sv.setFileName(file1.getAbsolutePath());
					}
				}
			}
		} catch (FileUploadException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		studentDAO.addNewSinhVien(sv);
		doGet(request, response);
	}

}
