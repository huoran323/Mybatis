package com.hr.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.hr.bean.Emp;
import com.hr.mapper.EmpMapper;
import com.hr.mapper.ParamMapper;

public class TestParam {

	@Test
	public void testCRUD() throws IOException {
		
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		//SqlSession sqlSession = sqlSessionFactory.openSession();//需要手动处理事务
		SqlSession sqlSession = sqlSessionFactory.openSession(true);//自动处理事务
		ParamMapper mapper = sqlSession.getMapper(ParamMapper.class);
//		Emp emp = new Emp(null, "admin", 23, "男");
//		mapper.insertEmp(emp);
//		System.out.println(emp.getEid());
		
		//1.
//		Emp emp = mapper.getEmpByEid("1");
//		System.out.println(emp);
		
		//3.
//		Emp emp = mapper.getEmpByEidAndEname("1", "小明");
//		System.out.println(emp);
		
		//4.
//		Map<String, Object> map = new HashMap<>();
//		map.put("eid", "1");
//		map.put("ename", "小明");
//		Emp emp = mapper.getEmpByMap(map);
//		System.out.println(emp);
		
		//5.
		//通过注解自动添加将键值添加，不需要手动添加
		Emp emp = mapper.getEmpByEidAndEnameByParam("1", "小明");
		System.out.println(emp);
	}
}
