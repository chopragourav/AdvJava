package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/errorurl")
public class ErrorServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//PrintWriter
		PrintWriter pw=res.getWriter();
		//responce content type
		res.setContentType("text/html");
		//write non-technical msg
		pw.println("<br><h1 style='color:red;text-align:center'> Internal Problem - Try Again </h1>");
		//add home link
		pw.println("<br><br><a href='input.html'><p align='center'>Home </p></a>");
		
		//close stream
		pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
