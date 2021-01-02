package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//printwriter
		PrintWriter pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//read for data
		String name=req.getParameter("pname");
		int age=Integer.parseInt(req.getParameter("page"));
		String address=req.getParameter("paddrs");
		String gender=req.getParameter("gender");
		String ms=req.getParameter("ms");
		String qlfy=req.getParameter("qlfy");
		String language=req.getParameter("language");
		String hb=req.getParameter("hb");
		long number=Long.parseLong(req.getParameter("mobile"));
		String dob=req.getParameter("dob");
		String email=req.getParameter("email");
		String color=req.getParameter("favColor");
		long salary=Long.parseLong(req.getParameter("salary"));
		String fburl=req.getParameter("fburl");
		int favNumber=Integer.parseInt(req.getParameter("favNumber"));
		String month=req.getParameter("month");
		

		//write B.Logic
		if(gender.equalsIgnoreCase("M")) {
			if(age<5)
				pw.println("<h1 style='color:blue;text-align:center>Master."+name+"you are Baby Boy</h1>");
			else if(age<13)
				pw.println("<h1 style='color:blue;text-align:center>Master."+name+"you are Small Boy</h1>");
			else if(age<20)
				pw.println("<h1 style='color:blue;text-align:center>Mr."+name+"you are Teen Age Boy</h1>");
			else if(age<35)
				pw.println("<h1 style='color:blue;text-align:center>Mr."+name+"you are Young Man</h1>");
			else if(age<50)
				pw.println("<h1 style='color:blue;text-align:center>Mr."+name+"you are Middel-Aged Man</h1>");
			else
				pw.println("<h1 style='color:blue;text-align:center>Mr."+name+"you are Old Man</h1>");
		}//if
		
		else {
			if(age<5)
				pw.println("<h1 style='color:blue;text-align:center>Master."+name+"you are Baby Girl</h1>");
			else if(age<13)
				pw.println("<h1 style='color:blue;text-align:center>Master."+name+"you are Small Girl</h1>");
			else if(age<20) {
				if(ms.equalsIgnoreCase("married"))
					pw.println("<h1 style='color:blue;text-align:center>Mrs."+name+"you are Teen Age Girl</h1>");
				else
					pw.println("<h1 style='color:blue;text-align:center>Miss."+name+"you are Teen Age Girl</h1>");
			}
			else if(age<35) {
				if(ms.equalsIgnoreCase("married"))
					pw.println("<h1 style='color:blue;text-align:center>Mrs."+name+"you are Young Woman</h1>");
				else
					pw.println("<h1 style='color:blue;text-align:center>Miss."+name+"you are Young Woman</h1>");
			}
			else if(age<50) {
				if(ms.equalsIgnoreCase("married"))
					pw.println("<h1 style='color:blue;text-align:center>Mrs."+name+"you are Middel Aged Woman</h1>");
				else
					pw.println("<h1 style='color:blue;text-align:center>Miss."+name+"you are Middel Aged Woman</h1>");
			}
			else {
				if(ms.equalsIgnoreCase("married"))
					pw.println("<h1 style='color:blue;text-align:center>Mrs."+name+"you are Old Woman</h1>");
				else
					pw.println("<h1 style='color:blue;text-align:center>Miss."+name+"you are Old Woman</h1>");
			}
		}//else
		
		pw.println("<h2 style='color:cyan:text-align:center>The submitted Details are </h2>");
		pw.println("<br><b style='text-align:center>Name::"+name+"</b>");
		pw.println("<br><b style='text-align:center>Age::"+age+"</b>");
		pw.println("<br><b style='text-align:center>Address::"+address+"</b>");
		pw.println("<br><b style='text-align:center>Gender::"+gender+"</b>");
		pw.println("<br><b style='text-align:center>Merital Status::"+ms+"</b>");
		pw.println("<br><b style='text-align:center>Qualification::"+qlfy+"</b>");
		pw.println("<br><b style='text-align:center>Languages Knows::"+language+"</b>");
		pw.println("<br><b style='text-align:center>Hobbies::"+hb+"</b>");
		pw.println("<br><b style='text-align:center>Mobile Number::"+number+"</b>");
		pw.println("<br><b style='text-align:center>DOB::"+dob+"</b>");
		pw.println("<br><b style='text-align:center>Email Id::"+email+"</b>");
		pw.println("<br><b style='text-align:center>Faviorite Color::"+color+"</b>");
		pw.println("<br><b style='text-align:center>Salary::"+salary+"</b>");
		pw.println("<br><b style='text-align:center>Faceboot Url::"+fburl+"</b>");
		pw.println("<br><b style='text-align:center>Faviorite Number::"+favNumber+"</b>");
		pw.println("<br><b style='text-align:center>Birth Month & Year::"+month+"</b>");
		
		//add home hyper link
		pw.println("<br><br><a href='input.html'>HOME </a>");
		//close Stream
		pw.close();
	}//doGet(-,-)
	
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}//doPost(-,-)
}//class
