package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/reporturl")
public class GenerateReportServlet extends HttpServlet {
	private static final String GET_PERSON_QUERY="SELECT PID,PNAME,PADD,RESUME,PHOTO FROM PERSON_PROFILE";
	
	@Resource(name = "DsJndi")
	private DataSource ds;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//PrintWriter
		PrintWriter pw=res.getWriter();
		//set responce content type
		res.setContentType("text/html");
		//stablish the connection
		try(Connection con=ds.getConnection()){
			try(PreparedStatement ps=con.prepareStatement(GET_PERSON_QUERY)){
				try(ResultSet rs=ps.executeQuery(GET_PERSON_QUERY)){
					pw.println("<h1 style='color:red;text-align:center'>Report Generation</h1>");
					pw.println("<table border='5' align='center' bgcolor='aqua'");
					pw.println("<tr><th> PID </th> <th> PNAME </th> <th> PADD </th> <th> RESUME </th> <th> PHOTO </th></tr>");
					while(rs.next()) {
						pw.println("<tr>");
						pw.println("<td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><Td><a href='downloadurl?id="+rs.getInt(1)+"&type=resume'> download </a> </td> <Td><a href='downloadurl?id="+rs.getInt(1)+"&type=photo'> download </a> </td>");
						pw.println("</tr>");
					}
					pw.println("</table>");
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
		pw.close();
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
