package com.hr.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.hr.bean.Emp;
import com.hr.mapper.EmpMapper;
import com.hr.mapper.EmpSQLMapper;

public class TestSQL {

	public SqlSessionFactory getSqlSessionFactory() throws IOException {

		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		return sqlSessionFactory;
	}

	//根据eid,ename,age,sex多条件查询员工信息
	@Test
	public void testIf() throws IOException {

		SqlSessionFactory factory = getSqlSessionFactory();
		SqlSession session = factory.openSession(true);
		EmpSQLMapper mapper = session.getMapper(EmpSQLMapper.class);
		Emp emp = new Emp();
//		emp.setEid(1);
		emp.setEname("张三");
		emp.setAge(23);
//		emp.setSex("1");
		List<Emp> list = mapper.getEmpListByMoreTJ(emp);
		for (Emp emp2 : list) {
			System.out.println(emp2);
		}
	}

	//根据eid,ename,age,sex中的其中一个查询一个员工信息
	@Test
	public void testChoose() throws IOException {

		SqlSessionFactory factory = getSqlSessionFactory();
		SqlSession session = factory.openSession(true);
		EmpSQLMapper mapper = session.getMapper(EmpSQLMapper.class);
		Emp emp = new Emp();
//		emp.setEid(1);
		emp.setEname("张三");
		emp.setAge(23);
		emp.setSex("1");
//		List<Emp> list = mapper.getEmpListByChoose(emp);
//		for (Emp emp2 : list) {
//			System.out.println(emp2);
//		}
		
		mapper.insertEmp(emp);
	}
}
