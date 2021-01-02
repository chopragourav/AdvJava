package com.nt.service;

import com.nt.bo.StudentBO;
import com.nt.dao.IStudentDAO;
import com.nt.dao.StudentDAOImpl;
import com.nt.dto.StudentDTO;

public class StudentMgmtServiceImpl implements IStudentMgmtService {
	public IStudentDAO dao;
	public StudentMgmtServiceImpl() throws Exception {
		dao=new StudentDAOImpl();
	}
	@Override
	public String generetResult(StudentDTO dto) throws Exception {
		int total=dto.getMarks1()+dto.getMarks2()+dto.getMarks3();
		float avg=total/3.0f;
		String result;
		if(dto.getMarks1()<35||dto.getMarks2()<35||dto.getMarks3()<35)
			result="Fail";
		else if (avg<35)
			result="Fail";
		else if(avg<50)
			result="Third Division";
		else if(avg<60)
			result="Second Division";
		else
			result="First Division";
		StudentBO bo=new  StudentBO();
		bo.setSname(dto.getSname());bo.setSadd(dto.getSadd());
		bo.setTotal(total);bo.setAvg(avg);bo.setAvg(avg);
		int count=dao.insert(bo);
		if(count==0)
			return "Student Registration Failed";
		else
			return "Student Registration Succeded";
	}

}
