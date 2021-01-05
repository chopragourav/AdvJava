package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeServiceImpl;
import com.nt.service.IEmployeeService;

/**
 * Servlet implementation class MainControllerServlet
 */
@WebServlet("/registerurl")
public class MainControllerServlet extends HttpServlet {
	private IEmployeeService service;
	public void init() {
		try {
			service=new EmployeeServiceImpl();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			//PrintWriter
			PrintWriter pw=res.getWriter();
			//set responce content type
			res.setContentType("text/html");
			//read form data
			String ename=req.getParameter("ename");
			String eadd=req.getParameter("eadd");
			float basicsalary=Float.parseFloat(req.getParameter("sal"));
			
			//create EmployeeDTO obj
			EmployeeDTO dto=new EmployeeDTO();
			dto.setEname(ename);dto.setEadd(eadd);
			dto.setBasicsalary(basicsalary);
			//use service
			try {
				String result=service.generateResult(dto);
				pw.println("<h1 style='color:blue;text-align:center>Result is: "+result+"</h1>");
			}
			catch (Exception e) {
				e.printStackTrace();
				pw.println("<h1 style='color:blue;text-align:center>problem in Insertion</h1>");
				// TODO: handle exception
			}
			//add home link
			pw.println("<a href='emp_register.html> Home </a>");
			//close stream
			pw.close();
		}
		
		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
