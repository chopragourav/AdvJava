package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeSearchServlet1 extends HttpServlet {
	private final static String GET_EMP_DETAILS="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		int no=0;
		//get printwriter
		pw=res.getWriter();
		//set responce content type
		res.setContentType("text/html");
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ServletConfig cg=getServletConfig();
			String driver=cg.getInitParameter("driverclass");
			String url=cg.getInitParameter("dburl");
			String user=cg.getInitParameter("dbuser");
			String pwd=cg.getInitParameter("dbpwd");
			//get form data
			no=Integer.parseInt(req.getParameter("eno"));
			
			//jdbc code
			Class.forName(driver);
			
			//create connection obj
			con=DriverManager.getConnection(url,user,pwd);
			
			//create PreparedStatement obj having pre-compiled query
			if(con!=null)
				ps=con.prepareStatement(GET_EMP_DETAILS);
			
			
			if(ps!=null) {
				//set queryparam
				ps.setInt(1, no);
				
				//execute query
				rs=ps.executeQuery();
			}
			//process the resultset obj
			if(rs!=null) {
				if(rs.next()) {
				pw.println("<h1 style='color:red;text-align:center'>Employees Details are::</h1>");
				pw.println("<br><b>Employee Number:: "+rs.getInt(1)+"</b>");
				pw.println("<br><b>Employee Name:: "+rs.getString(2)+"</b>");
				pw.println("<br><b>Employee Job:: "+rs.getString(3)+"</b>");
				pw.println("<br><b>Employee Salary:: "+rs.getInt(4)+"</b>");
				}//if
				else
					pw.println("<h1 style='color:red;text-align:center'>Employees Details not found</h1>");
			}//if
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)
					rs.close();
			}
			catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(ps!=null)
					ps.close();
			}
			catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			}
			catch (SQLException se) {
				se.printStackTrace();
			}
		}//finally
		
		//home hyper link
		pw.println("<br><br><a href='input.html'>Home </a>");
		
		//close stream
		pw.close();
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}
}
