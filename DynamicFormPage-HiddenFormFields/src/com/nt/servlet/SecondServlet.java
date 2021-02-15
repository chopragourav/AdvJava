package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	private static final String INSERT_QUERY="INSERT INTO PERSON_INFO(NAME,FATHER,MS,INFO1,INFO2) VALUES(?,?,?,?,?)";
	@Resource(name="DsJndi-mysql")
	private DataSource ds;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Get PrintWriter
				PrintWriter pw=res.getWriter();
				//set responce content type
				res.setContentType("text/html");
				//read form1 data from hidden boxes
				String name=req.getParameter("hname");
				String father=req.getParameter("hfname");
				String ms=req.getParameter("hms");
				//read form2 data
				String f2val1=req.getParameter("f2v1");
				String f2val2=req.getParameter("f2v2");
				try (Connection con=ds.getConnection()){
					try(PreparedStatement ps=con.prepareStatement(INSERT_QUERY)){
						//set query param
						ps.setString(1, name);ps.setString(2, father);ps.setString(3, ms);
						ps.setString(4, f2val1);ps.setString(5, f2val2);
						//execute the query
						int result=ps.executeUpdate();
						//process the result
						pw.println("<body bgcolor='grey'>");
						if(result==0)
							pw.println("<h1 style='color:red; text-align:center'>Record not Inserted</h1>");
						else
							pw.println("<h1 style='color:red; text-align:center'>Record Inserted</h1>");
					}
				} catch (SQLException se) {
					pw.println("<b>Problem in Insertion</b>");
					se.printStackTrace();
				}
				catch (Exception e) {
					pw.println("<b>Unknown DB Problem</b>");
					e.printStackTrace();
				}
				//pw.println("<body bgcolor='grey'>");
				//display form1 and form2 data in webpage
				pw.println("<b>form1 /req 1 data ::"+name+"....."+father+"....."+ms+"<b>");
				pw.println("<br><br> <b>form2 /req 2 data ::"+f2val1+"....."+f2val2+"<b>");
				//add hyper link
				pw.println("<br><a href='form1.html'>Home </a>");
				pw.println("</body>");
				//close stream
				pw.close();
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
