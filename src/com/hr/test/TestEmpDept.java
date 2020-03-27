package com.hr.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.hr.bean.Dept;
import com.hr.bean.Emp;
import com.hr.mapper.EmpDeptMapper;
import com.hr.mapper.EmpSelectMapper;

public class TestEmpDept {

	@Test
	public void testSelect() throws IOException {

		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlSession = sqlSessionFactory.openSession(true); // 自动处理事务

		EmpDeptMapper mapper = sqlSession.getMapper(EmpDeptMapper.class);
//		List<Emp> list = mapper.getAllEmp();
//		System.out.println(list);
		
		//测试分步查询多对一
//		Emp emp = mapper.getEmpStep("1");
//		System.out.println(emp);
		
//		Dept dept = mapper.getDeptEmpsByDid("2");
//		System.out.println(dept);

		//测试分步查询一对多
		Dept dept = mapper.getOnlyDeptByDid("2");
		System.out.println(dept.getDname());
	}
}
