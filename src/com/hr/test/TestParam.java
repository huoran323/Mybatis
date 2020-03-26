package com.hr.test;

import java.io.IOException;
import java.io.InputStream;

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
		mapper.insertEmp(new Emp(null, "admin", 23, "男"));
		
	}
}
