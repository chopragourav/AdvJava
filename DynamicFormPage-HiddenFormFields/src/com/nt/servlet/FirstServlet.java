package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Get PrintWriter
		PrintWriter pw=res.getWriter();
		//set responce content type
		res.setContentType("text/html");
		//read form1 data
		String name=req.getParameter("name");
		String father=req.getParameter("father");
		String ms=req.getParameter("ms");
		//create dynamic form 2
		if(ms.equalsIgnoreCase("married")) {
			pw.println("<h1 style='color:red;text-align:center'>Provide Married Life Details(Form2)</h1>");
			pw.println("<form action='secondurl' method='POST'>");
			pw.println("<table bgcolor='aqua' align='center'>");
			pw.println("<tr><td>Spouce Name:: </td><td><input type='text' name='f2v1'></td></tr>");
			pw.println("<tr><td>No. of Kids:: </td><td><input type='text' name='f2v2'></td></tr>");
			pw.println("<tr><td colspan='2'><input type='submit' value='Submit'></td></tr>");
			pw.println("<tr><td><input type='hidden' name='hname' value='"+name+"'></td>"
					+ "<td><input type='hidden' name='hfname' value='"+father+"'></td></tr>");
			pw.println("<tr><td><input type='hidden' name='hms' value='"+ms+"'</td></tr>");
			pw.println("</table>");
			pw.println("</form>");
		}
		else {
			pw.println("<h1 style='color:red;text-align:center'>Provide Single Life Details(Form2)</h1>");
			pw.println("<form action='secondurl' method='POST'>");
			pw.println("<table bgcolor='aqua' align='center'>");
			pw.println("<tr><td>When do u want to marry? </td><td><input type='text' name='f2v1'></td></tr>");
			pw.println("<tr><td>Why do u want to marry? </td><td><input type='text' name='f2v2'></td></tr>");
			pw.println("<tr><td colspan='2'><input type='submit' value='Submit'></td></tr>");
			pw.println("<tr><td><input type='hidden' name='hname' value='"+name+"'></td>"
					+ "<td><input type='hidden' name='hfname' value='"+father+"'></td></tr>");
			pw.println("<tr><td><input type='hidden' name='hms' value='"+ms+"'</td></tr>");
			pw.println("</table>");
			pw.println("</form>");
		}
		//close stream
		pw.close();
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)
}//class
