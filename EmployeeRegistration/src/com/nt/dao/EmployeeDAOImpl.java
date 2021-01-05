package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.EmployeeBO;

public class EmployeeDAOImpl implements IEmployeeDAO {
	private static final String INSERT_EMPLOYEE_QUERY="INSERT INTO LAYERED_EMPLOYEE VALUES(ENO_SEQ.NEXTVAL,?,?,?)";
	
	//
	DataSource ds=null;
	public EmployeeDAOImpl()throws Exception {
		//InitialContext
		InitialContext ic=new InitialContext();
		//datasource
		ds=(DataSource) ic.lookup("java:/comp?env/DsJndi");
	}
	@Override
	public int insert(EmployeeBO bo) throws Exception {
		//establish the connection
		Connection con=getPooledJdbcConnection();
		//PreparedStatement of pre-compiles sql query
		PreparedStatement ps=con.prepareStatement(INSERT_EMPLOYEE_QUERY);
		//process the result
		int result=ps.executeUpdate();
		con.close();
		ps.close();
		return result;
	}

	private Connection getPooledJdbcConnection()throws Exception{
		Connection con=ds.getConnection();
		return con;
	}
}
