package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//write printwriter
		PrintWriter pw=res.getWriter();
		//set responce content type
		res.setContentType("text/html");
		//read special request param
		String pval=req.getParameter("s1");
		//get all variable locales
		Locale locales[]=Locale.getAvailableLocales();
		
		if(pval.equalsIgnoreCase("link1")) {
			pw.println("All Languages are::");
			for(Locale l:locales) {
				pw.println("<br><b>"+l.getDisplayLanguage()+"</b>");
			}//for
		}//if
		else if(pval.equalsIgnoreCase("link2")) {
			pw.println("All Countries Are::");
			for(Locale l:locales) {
				pw.println("<br><b>"+l.getDisplayCountry()+"</b>");
			}//for
		}//else if
		else {
			pw.println("System Properties Are::"+System.getProperties());
		}//else
		
		//Home Hyper Link
		pw.println("<br><br><a href='links.html'>Home </a>");
		
		//close Stream
		pw.close();
	}//doGet
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}//doPost
}//class
