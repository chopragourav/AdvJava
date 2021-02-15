package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.nt.bo.EmployeeBO;

public class EmployeeDAOImpl implements IEmployeeDAO {
	private static final String INSERT_EMPLOYEE="INSERT INTO LAYERED_EMPLOYEE VALUES(ENO_SEQ.NEXTVAL,?,?,?,?)";
	
	DataSource ds;
	public EmployeeDAOImpl() throws Exception {
		InitialContext ic=new InitialContext();
		ds=(DataSource) ic.lookup("java:/comp/env/DsJndi");
	}
	@Override
	public int insert(EmployeeBO bo) throws Exception {
		//establish the connenction
		Connection con=getPooledJdbcConnection();
		//PreparedStatement of pre-compiled sql query
		PreparedStatement ps=con.prepareStatement(INSERT_EMPLOYEE);
		//set values to query param
		ps.setString(1, bo.getEname());
		ps.setString(2, bo.getEadd());
		ps.setFloat(3, bo.getGrosssalary());
		ps.setFloat(4, bo.getNetsalary());
		//process the result
		int result=ps.executeUpdate();
		con.close();
		ps.close();
		return result;
	}
	
	private Connection getPooledJdbcConnection() throws Exception {
		Connection con=ds.getConnection();
		return con;
	}
}
