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

import sinhvien.entity.SinhVien;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletFileUpload uploader = null;
	@Override
	public void init() throws ServletException{
		DiskFileItemFactory fileFactory = new DiskFileItemFactory();
		File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
		fileFactory.setRepository(filesDir);
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	ArrayList<SinhVien> dsSinhVien = (ArrayList<SinhVien>) request.getSession().getAttribute("dsSinhVien");
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		if(!ServletFileUpload.isMultipartContent(request)){
			throw new ServletException("Content type is not multipart/form-data");
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("<html><head></head><body>");
		
		int id = 0;
		String hoTen = "";
		int namSinh = 0;
		String avatar = "";
		try {
			List<FileItem> fileItemsList = uploader.parseRequest(request);
			Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();
			while(fileItemsIterator.hasNext()){
				FileItem fileItem = fileItemsIterator.next();
				if(fileItem.isFormField()) {
					if(fileItem.getFieldName().equals("id")) {
						id = Integer.parseInt(fileItem.getString());
					}else if(fileItem.getFieldName().equals("hoTen")) {
						hoTen = fileItem.getString();
					}else if(fileItem.getFieldName().equals("namSinh")) {
						namSinh = Integer.parseInt(fileItem.getString());
					}  
				}else {
					System.out.println("FieldName="+fileItem.getFieldName());
					System.out.println("FileName="+fileItem.getName());
					System.out.println("ContentType="+fileItem.getContentType());
					System.out.println("Size in bytes="+fileItem.getSize());
				
				
					
					File file = new File(request.getServletContext().getAttribute("FILES_DIR")+File.separator+
							fileItem.getName().substring(fileItem.getName().lastIndexOf(File.separator)+1, fileItem.getName().length()));
					System.out.println("Absolute Path at server="+file);
					
					avatar = file.getPath();
					System.out.println(avatar);
					fileItem.write(file);
					
					//avatar = avatar.substring(avatar.lastIndexOf(File.separator)+1, avatar.length());
					//System.out.println("New file name="+avatar);
					
					//out.write("File "+avatar+ " uploaded successfully.");
					//out.write("<br>");
					//out.write("<a href=\"UploadDownloadFileServlet?fileName="+avatar+"\">Download "+avatar+"</a>");
					
					request.getSession().setAttribute("uploadFileName", avatar);
					
				}	
				
			}
		} catch (FileUploadException e) {
			//out.write("Exception in uploading file.");
			System.out.println(e);
		} catch (Exception e) {
			//out.write("Exception in uploading file.");
			System.out.println(e);
		}

				dsSinhVien.add(new SinhVien(hoTen, namSinh, id,avatar));
			
			
			
			
			//out.println("<meta http-equiv=\"refresh\" content=\"0;DanhSachSinhVien2\">");
			response.sendRedirect("DanhSachSinhVien2");
	}

}
