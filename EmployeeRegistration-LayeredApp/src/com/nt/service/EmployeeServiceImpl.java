package com.nt.service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAOImpl;
import com.nt.dao.IEmployeeDAO;
import com.nt.dto.EmployeeDTO;

public class EmployeeServiceImpl implements IEmployeeService {
	
	private IEmployeeDAO dao;
	public EmployeeServiceImpl() throws Exception {
		dao=new EmployeeDAOImpl();
	}
	@Override
	public String generateResult(EmployeeDTO dto) throws Exception {
		//write B.Logic
		float grosssalary=dto.getBasicsalary()+(dto.getBasicsalary()*30/100);
		float netsalary=grosssalary-(grosssalary*10/100);
		//prepared EmployeeBO obj
		EmployeeBO bo=new EmployeeBO();
		bo.setEname(dto.getEname());bo.setEadd(dto.getEadd());
		bo.setGrosssalary(grosssalary);
		//use dao
		int count=dao.insert(bo);
		if(count==0)
			return "Employee Not Registered";
		else
			return "Employee Registered";
	}


}
