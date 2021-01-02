package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.StudentDTO;
import com.nt.service.IStudentMgmtService;
import com.nt.service.StudentMgmtServiceImpl;
@WebServlet(value = "/registerurl")
public class MainControllerServlet extends HttpServlet {
	public IStudentMgmtService service;
	public void init() {
		try {
			service=new StudentMgmtServiceImpl();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String sname=req.getParameter("sname");
		String sadd=req.getParameter("sadd");
		int marks1=Integer.parseInt(req.getParameter("marks1"));
		int marks2=Integer.parseInt(req.getParameter("marks2"));
		int marks3=Integer.parseInt(req.getParameter("marks3"));
		StudentDTO dto=new StudentDTO();
		dto.setSname(sname);dto.setSadd(sadd);
		dto.setMarks1(marks1);dto.setMarks2(marks2);dto.setMarks3(marks3);
		try {
			String result=service.generetResult(dto);
			pw.println("<h1 style='color: red;text_align: center'>Result is: "+result+"</h1>");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			pw.println("<h1 style='color: red;text_align: center'>Problem in Insertion</h1>");
		}
		pw.println("<a href='register.html'>Home</a>");
		pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
