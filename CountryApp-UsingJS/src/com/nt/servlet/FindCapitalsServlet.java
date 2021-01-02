package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindCapitalsServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		//get printwriter
		PrintWriter pw=res.getWriter();
		//set response Content type
		res.setContentType("text/html");
		//read data
		int countryCode=Integer.parseInt(req.getParameter("country"));
		//write b.Logic
		String capitals[]=new String[] {"New Delhi","Washington DC","Bejing","Tokyo","Berlin"};
		
		//write responce/output
		pw.println("<h1 style='color:red;text-align:center'> Country Capital is::"+capitals[countryCode]+"</h1>");
		
		//home hyperlink
		pw.println("<br><a href='input.html'>Home</a>");
		//close stream
		pw.close();
	}//doPost
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}//class
