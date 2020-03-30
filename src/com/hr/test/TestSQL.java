package com.hr.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
	
	@Test
	public void testDeleteMore() throws IOException {

		SqlSessionFactory factory = getSqlSessionFactory();
		SqlSession session = factory.openSession(true);
		EmpSQLMapper mapper = session.getMapper(EmpSQLMapper.class);
		
		//批量删除方式一
//		String eids = "1,2";
//		mapper.deleteMoreEmp(eids);
		
		//批量删除方式二
		List<Integer> eids = new ArrayList<>();
		eids.add(3);
		eids.add(4);
		mapper.deleteMoreByList(eids);
		
	}
	
	//批量添加
	@Test
	public void testInsertMore() throws IOException {

		SqlSessionFactory factory = getSqlSessionFactory();
		SqlSession session = factory.openSession(true);
		EmpSQLMapper mapper = session.getMapper(EmpSQLMapper.class);
		
		//创建数组的三种方式
//		Emp[] emps = new Emp[3];
//		Emp[] emps = new Emp[]{};
		Emp emp1 = new Emp(null, "a", 23, "男");
		Emp emp2 = new Emp(null, "b", 23, "女");
		Emp emp3 = new Emp(null, "c", 23, "男");
		Emp[] emps = {emp1,emp2,emp3};
		mapper.insertMoreArray(emps);
	}
}
