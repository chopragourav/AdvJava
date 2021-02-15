package com.nt.dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {
	private String ename;
	private String eadd;
	private float basicsalary;

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEadd() {
		return eadd;
	}

	public void setEadd(String eadd) {
		this.eadd = eadd;
	}

	public float getBasicsalary() {
		return basicsalary;
	}

	public void setBasicsalary(float basicsalary) {
		this.basicsalary = basicsalary;
	}

}
