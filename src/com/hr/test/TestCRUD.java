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

public class TestCRUD {

	@Test
	public void testCRUD() throws IOException {
		
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		//SqlSession sqlSession = sqlSessionFactory.openSession();//需要手动处理事务
		SqlSession sqlSession = sqlSessionFactory.openSession(true);//自动处理事务
		EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
		
		//测试:根据eid获取员工信息
//		Emp emp = empMapper.getEmpByEid("3");
//		System.out.println(emp);
		
		//测试：获取所有的员工信息
//		List<Emp> list = empMapper.getAllEmp();
//		System.out.println(list);
		
		//测试：添加员工信息
//		empMapper.addEmp(new Emp(null, "admin", 28, "男"));
//		//手动提交事务
//		sqlSession.commit();
		
		//测试：修改员工信息
		empMapper.updateEmp(new Emp(13, "小红", 21, "女"));
		
		//测试：删除员工信息
//		empMapper.deleteEmp("6");
	}
}
