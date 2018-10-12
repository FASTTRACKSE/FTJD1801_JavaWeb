package sv.controller;

import java.io.File;
import java.io.IOException;
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

import sv.dao.SinhVienDAO;
import sv.entity.SinhVien;

/**
 * Servlet implementation class doAdd
 */
@WebServlet("/doAdd")
public class doAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SinhVienDAO sinhVienDAO = new SinhVienDAO();

	private static final String UPLOAD_DIRECTORY = "uploads";
	private ServletFileUpload uploader = null;

	public doAdd() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws SecurityException {
		// configures upload settings
		DiskFileItemFactory fileFactory = new DiskFileItemFactory();

		// sets temporary location to store files
		fileFactory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		// create
		this.uploader = new ServletFileUpload(fileFactory);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");

		int id = 0;
		String hoTen = null;
		String namSinh = null;
		String image = null;

		String uploadPath = getServletContext().getRealPath("/") + File.separator + UPLOAD_DIRECTORY;
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
					if (fileItem.getFieldName().equals("iD")) {
						id = Integer.parseInt(fileItem.getString());
					} else if (fileItem.getFieldName().equals("hoTen")) {
						hoTen = fileItem.getString();
					} else if (fileItem.getFieldName().equals("date")) {
						namSinh = fileItem.getString();
					}else if (fileItem.getFieldName().equals("image")) {
						image = fileItem.getString();
				} else {
					System.out.println("FieldName=" + fileItem.getFieldName());
					System.out.println("FileName=" + fileItem.getName());
					System.out.println("ContentType=" + fileItem.getContentType());
					System.out.println("Size in bytes=" + fileItem.getSize());

					File file = new File(uploadPath + File.separator + fileItem.getName());
					System.out.println("Absolute Path at server=" + file.getAbsolutePath());
					fileItem.write(file);
					image = fileItem.getName();
				}
			}
		}
		}catch (FileUploadException e) {
			System.out.println("Exception in uploading file.");
		} catch (Exception e) {
			System.out.println("Exception in uploading file.");
		}
		SinhVien sv = new SinhVien(id, hoTen, namSinh, image);
		sinhVienDAO.addNewSinhVien(sv);
		response.sendRedirect("/sv");
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
