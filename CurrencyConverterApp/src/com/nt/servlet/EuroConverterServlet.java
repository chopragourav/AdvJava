package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/eurourl")
public class EuroConverterServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
				PrintWriter pw=res.getWriter();
				//set responce content type
				res.setContentType("text/html");
				//read form data
				float value=Float.parseFloat(req.getParameter("value"));
				//Dollar converter value
				float EuroValue=value/89.835f;
				pw.println("<br><br><br><h1 style='color: red;text-align: center'><marquee>Euro Value is: "+EuroValue+" is for Indian Rupee "+value+"</marquee></h1>");
				//servletContext
				ServletContext sc1=getServletContext();
				//get foreign context
				ServletContext sc2=sc1.getContext("/UsDollarConverterApp");
				//creat RequestDispatcher obj
				RequestDispatcher rd=sc2.getRequestDispatcher("/dollarurl");
				//include responce
				rd.include(req, res);
				//add home link
				pw.println("<a href='input.html'><marquee><p align='center'>Home </marquee></p></a>");
				//close stream
				pw.close();
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}
	
}
