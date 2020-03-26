package com.hr.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hr.bean.Emp;

public interface ParamMapper {

	//添加员工信息
	void insertEmp(Emp emp);

	//根据eid获取员工信息
	Emp getEmpByEid(String eid);
	
	//根据eid和ename获取员工信息
	Emp getEmpByEidAndEname(String eid, String ename);
	
	//根据map获取员工信息
	Emp getEmpByMap(Map<String, Object> map);
	
	//根据eid和ename获取员工信息,通过注解@Param将eid放到map中，不需要手动map put添加了
	Emp getEmpByEidAndEnameByParam(@Param("eid")String eid, @Param("ename")String ename);
}
