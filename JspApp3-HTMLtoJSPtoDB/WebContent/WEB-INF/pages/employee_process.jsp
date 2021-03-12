<%@ page import="java.sql.*"%>
<%!
	private Connection con;
	private PreparedStatement ps1,ps2;
	public void jspInit(){
			//get access to ServletCofig obj
			ServletConfig cg=getServletConfig();
			//read jsp init param value
			String driver=cg.getInitParameter("driver");
			String url=cg.getInitParameter("url");
			String user=cg.getInitParameter("dbuser");
			String pwd=cg.getInitParameter("dbpwd");
			try{
			//load driver class
			Class.forName(driver);
			//estabish the jdbc connection obj
			con=DriverManager.getConnection(url,user,pwd);
			//create PreparedStatement obj
			ps1=con.prepareStatement("INSERT INTO JSP_EMPLOYEE VALUES(EMP_SEQ.NEXTVAL,?,?,?)");
			ps2=con.prepareStatement("SELECT EMPNO,EMPNAME,EMPADDRS,SALARY FROM JSP_EMPLOYEE");
			}
			catch(SQLException se){
			se.printStackTrace();
			}
			catch(ClassNotFoundException  cnf){
			cnf.printStackTrace();
			}
			catch(Exception e){
			e.printStackTrace();
			}
			
	} %>
<%
		//read s1 req param weather req is come from register or link
		String s1val=request.getParameter("s1");
		if(s1val.equalsIgnoreCase("register")){
			//read form data
			String ename=request.getParameter("ename");
			String eadd=request.getParameter("eadd");
			float salary=Float.parseFloat(request.getParameter("sal"));
			//set values to query param
			ps1.setString(1,ename);
			ps1.setString(2,eadd);
			ps1.setFloat(3,salary);
			//execute query
			int result=ps1.executeUpdate();
			//process the result
			if(result==1){ %>
				<h1 style="color: green; text-align: center;">Employee Registered</h1>
				
				<% }//if
			else{ %>
				<h1 style="color: green; text-align: center;">Employee Not Registered</h1>
		<% }//else
		}//if
		
		else{
			//execute select query
			ResultSet rs=ps2.executeQuery();
			//process the result %>
			<table align="center" border="2" bgcolor="pink">
			<tr><th>EMPNO</th> <th>EMPNAME</th> <th>EMPADDRS</th> <th>SALARY</th></tr> 
			<%while(rs.next()){%>
			<tr>
			<td><%=rs.getInt(1) %>	</td>
			<td><%=rs.getString(2) %>	</td>
			<td><%=rs.getString(3) %>	</td>
			<td><%=rs.getFloat(4) %>	</td>
			</tr>
				</table>
			<% }//while
 		}//else
	%>
	<br><br>
	<a href="employee_form.html">Home</a>
	<%!public void jspDestroy(){
		try{
			if(ps1!=null)
			ps1.close();
		}
		catch(SQLException se){
		se.printStackTrace();
		}
		try{
			if(ps2!=null)
			ps2.close();
		}
		catch(SQLException se){
		se.printStackTrace();
		}
		try{
			if(con!=null)
			con.close();
		}
		catch(SQLException se){
		se.printStackTrace();
		}
	}
	 %>