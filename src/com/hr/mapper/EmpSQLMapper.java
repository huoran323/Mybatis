package com.hr.mapper;

import java.util.List;

import com.hr.bean.Emp;

public interface EmpSQLMapper {

	//根据eid,ename,age,sex多条件查询员工信息
	List<Emp> getEmpListByMoreTJ(Emp emp);
}
