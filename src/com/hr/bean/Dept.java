package com.hr.bean;

import java.util.List;

public class Dept {

	private Integer did;
	
	private String dname;
	
	private List<Emp> emps;
	

	public List<Emp> getEmps() {
		return emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	@Override
	public String toString() {
		return "Dept [did=" + did + ", dname=" + dname + ", emps=" + emps + "]";
	}
	
	
}
