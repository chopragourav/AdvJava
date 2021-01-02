package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.nt.bo.StudentBO;

public class StudentDAOImpl implements IStudentDAO {
	private final static String INSERT_LAYERED_STUDENT="INSERT INTO LAYERED_STUDENT VALUES(SNO_SEQ.NEXTVAL,?,?,?,?,?)";
	
	
	DataSource ds=null;
	public StudentDAOImpl() throws Exception {
		InitialContext ic=new InitialContext();
		ds=(DataSource) ic.lookup("java:/comp/env/DsJndi");
	}
	@Override
	public int insert(StudentBO bo) throws Exception {
		Connection con=getPooledJdbcConnection();
		PreparedStatement ps=con.prepareStatement(INSERT_LAYERED_STUDENT);
		ps.setString(1, bo.getSname());
		ps.setString(2, bo.getSadd());
		ps.setInt(3, bo.getTotal());
		ps.setFloat(4, bo.getAvg());
		ps.setString(5, bo.getResult());
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
