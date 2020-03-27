package com.hr.mapper;

import java.util.List;

import com.hr.bean.Dept;
import com.hr.bean.Emp;

public interface EmpDeptMapper {
	
	List<Emp> getAllEmp();

	Emp getEmpStep(String eid);
	
	//查询部门有多少人
	Dept getDeptEmpsByDid(String did);
	
	//查询部门
	Dept getOnlyDeptByDid(String did);
	
	//根据部门查询Emp
	List<Emp> getEmpListByDid(String did);
}
