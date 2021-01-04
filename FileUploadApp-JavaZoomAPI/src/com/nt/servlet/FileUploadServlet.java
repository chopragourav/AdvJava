package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Vector;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadParameters;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/uploadurl")
public class FileUploadServlet extends HttpServlet {
	private static final String INSERT_PERSON_PROFILE="INSERT INTO PERSON_PROFILE VALUES(PID_SEQ.NEXTVAL,?,?,?,?)";
	
	@Resource(name = "DsJndi")
	private DataSource ds;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String resumeLocation="D:/upload/resumes/";
		String photoLocation="D:/upload/photos/";
		//PrintWriter Stream
		PrintWriter pw=res.getWriter();
		//set responce content type
		res.setContentType("text/html");
		//set special req obj
		String pname=null,padd=null,resumeFilePath=null,photoFilePath=null;
		try {
			MultipartFormDataRequest nreq=new MultipartFormDataRequest(req);
			//read form data
			pname=nreq.getParameter("pname");
			padd=nreq.getParameter("padd");
			//UploadBean
			UploadBean upb=new UploadBean();
			upb.setFolderstore(resumeLocation);
			upb.store(nreq, "resume");
			upb.setFolderstore(photoLocation);
			upb.store(nreq, "photo");
			//Vector obj
			Vector vector=upb.getHistory();
			resumeFilePath=resumeLocation+((UploadParameters)vector.get(0)).getFilename();
			photoFilePath=photoLocation+((UploadParameters)vector.get(1)).getFilename();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		try(Connection con=ds.getConnection()){
			try(PreparedStatement ps=con.prepareStatement(INSERT_PERSON_PROFILE)){
				//set values to query param
				ps.setString(1, pname);
				ps.setString(2, padd);
				ps.setString(3, resumeFilePath);
				ps.setString(4, photoFilePath);
				//execute the query
				int result=ps.executeUpdate();
				//process the Result
          	  if(result==0)
          		  pw.println("<h1 style='color:red;text-align:center'> Registration not completed </h1>");
          	  else
          		  pw.println("<h1 style='color:red;text-align:center'> Registration  completed </h1>");
            }//try2
         }//try1
	catch(Exception e) {
		e.printStackTrace();
	  pw.println("<h1 style='color:red;text-align:center'> Problem Person Registration</h1>");
	  }
            //add home hyperlink
            pw.println("<br><br> <a href='upload.html'>home </a>");
            //close stream
            pw.close();
}//doGet(-,-)
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)
}//class
