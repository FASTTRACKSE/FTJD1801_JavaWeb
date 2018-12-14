package com.journaldev.servlet;


import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.commons.fileupload.UploadContext;

@WebListener
public class FileLocationContextListener2 implements ServletContextListener {
	//tu tao thu muc bang hang so
	//co the tao o dau cung dc
	//phai bien dich lai chuong trinh
	//ko can param tren xml
    private static final String UPLOAD_DIRECTORY = "upload";

	public void contextInitialized(ServletContextEvent servletContextEvent) {
    
    	String rootPath = servletContextEvent.getServletContext().getRealPath("/")+File.separator + UPLOAD_DIRECTORY;
    	
    	ServletContext ctx = servletContextEvent.getServletContext();

    	File file = new File(rootPath + File.separator);
 
    	ctx.setAttribute("FILES_DIR_FILE", file);
  
    }

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		//do cleanup if needed
	}
	
}

