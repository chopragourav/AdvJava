package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarriageServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		res.setContentType("text/html");
		
		PrintWriter pw=res.getWriter();
		
		String name=req.getParameter("pname");
		
		int age=Integer.parseInt(req.getParameter("page"));
		String gender=req.getParameter("gender");
		
		if(gender.equalsIgnoreCase("M")) {
			if(age<21)
				pw.println("<h1 style='color:red;tex-align:center'> Mr."+name+"u r not eligible for marraige enjoy life</h1>");
			else
				pw.println("<h1 style='color:green;tex-align:center'> Mr."+name+"u r eligible for marraige, but think once</h1>");
		}
		else {
			if(age<18)
				pw.println("<h1 style='color:red;tex-align:center'> Miss."+name+"u r not eligible for marraige be happy</h1>");
			else
				pw.println("<h1 style='color:green;tex-align:center'> Miss."+name+"u r not eligible for marraige, but think once</h1>");
		}
		
		pw.println("<br><a href='http://localhost:2020/MarraigeApp/input.html'><img src='images/home.jpg'></a>");
		pw.close();
	}//doPost
}//class
