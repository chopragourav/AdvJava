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
import javax.servlet.http.HttpSession;


@WebServlet("/s2url")
public class Servlet2 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set responce content type
		res.setContentType("text/html");
		//read and display request attribute value
		pw.println("<b>Servlet2:: Request Attribute Value :" + req.getAttribute("attr1")+"</b></br></br>");
		//create session attribute 
		HttpSession ses=req.getSession();
		//read and display session attribute value
		pw.println("<b>Servlet2:: Session Attribute Value:: "+ses.getAttribute("attr2")+"</b></br>");
		//create ServletContext
		ServletContext sc=req.getServletContext();
		//read and display session attribute value
				pw.println("<b>Servlet2:: ServletContext Attribute Value:: "+sc.getAttribute("attr3")+"</b></br>");
		//RequestDispatcher
		RequestDispatcher rd=req.getRequestDispatcher("/s3url");
		rd.forward(req, res);
	}


	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doGet(req, res);
	}

}
