package com.nt.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.tomcat.util.http.fileupload.IOUtils;


@WebServlet("/downloadurl")
public class FileDownloadServlet extends HttpServlet {
	@Resource(name = "DsJndi")
	private DataSource ds;
		protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			//read additional req param
			int id=Integer.parseInt(req.getParameter("id"));
			String type=req.getParameter("type");
			//decide the sql query to download file
			String query=null;
			if(type.equalsIgnoreCase("resume"))
				query="SELECT RESUME FROM PERSON_PROFILE WHERE PID=?";
			else
				query="SELECT PHOTO FROM PERSON_PROFILE WHERE PID=?";
			//establish the connection
			String filePath=null;
			try(Connection con=ds.getConnection()){
				try(PreparedStatement ps=con.prepareStatement(query)){
					//set valus to query param
					ps.setInt(1, id);
					try(ResultSet rs=ps.executeQuery()){
						if(rs.next())
							filePath=rs.getString(1);
					}//try3
				}//try2
			}//try1
			catch (SQLException se) {
				se.printStackTrace();
				// TODO: handle exception
			}
			catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
			//create java.io.FIle obj
			try {
				File file=new File(filePath);
				res.setContentLengthLong(file.length());
				ServletContext sc=getServletContext();
				String mimeType=sc.getMimeType(filePath);
				mimeType=(mimeType==null)?"application/octet-stream":mimeType;
				res.setContentType(mimeType);
				InputStream is=new FileInputStream(file);
				ServletOutputStream sos=res.getOutputStream();
				res.setHeader("Content-Disposition","attachment;fileName="+file.getName());
				IOUtils.copy(is, sos);
				//close stream
				is.close();
				sos.close();
			}
			catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		
		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			doGet(req,res);
		}
		
	}
