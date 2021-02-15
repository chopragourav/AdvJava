package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Get PrintWriter
				PrintWriter pw=res.getWriter();
				//set responce content type
				res.setContentType("text/html");
				//read form1 data
				String name=req.getParameter("name");
				String father=req.getParameter("father");
				String ms=req.getParameter("ms");
				//read form2 data
				String f2val1=req.getParameter("f2v1");
				String f2val2=req.getParameter("f2v2");
				//display form1 and form2 data in webpage
				pw.println("<b>form1 /req 1 data ::"+name+"....."+father+"....."+ms+"<b>");
				pw.println("<br><br> <b>form2 /req 2 data ::"+f2val1+"....."+f2val2+"<b>");
				//add hyper link
				pw.println("<br><a href='form1.html'>Home </a>");
				//close stream
				pw.close();
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
