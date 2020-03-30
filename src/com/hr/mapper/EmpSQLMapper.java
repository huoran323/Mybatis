package com.hr.mapper;

import java.util.List;

import com.hr.bean.Emp;

public interface EmpSQLMapper {

	//根据eid,ename,age,sex多条件查询员工信息
	List<Emp> getEmpListByMoreTJ(Emp emp);
	
	//根据eid,ename,age,sex中的其中一个查询一个员工信息
	List<Emp> getEmpListByChoose(Emp emp);
	
	//添加员工信息，将0或1操作成女或男
	void insertEmp(Emp emp);
	
	//通过eid所组成的字符串实现批量删除
	void deleteMoreEmp(String eids);
	
	//通过list集合实现批量删除
	void deleteMoreByList(List<Integer> eids);
}
