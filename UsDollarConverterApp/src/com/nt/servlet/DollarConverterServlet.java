package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dollarurl")
public class DollarConverterServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set responce content type
		res.setContentType("text/html");
		//read form data
		float value=Float.parseFloat(req.getParameter("value"));
		//Dollar converter value
		float dollarValue=value/73.34f;
		
		pw.println("<br><br><br><h1 style='color: red;text-align: center'><marquee>Dollar Value is: "+dollarValue+" is for Indian Rupee "+value+"</marquee></h1>");
		//do'nt close stream
		//pw.close();
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
}
