package com.hr.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hr.bean.Emp;
import com.hr.mapper.EmpSQLMapper;

public class TestPage {
	
	public SqlSessionFactory getSqlSessionFactory() throws IOException {

		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		return sqlSessionFactory;
	}

	@Test
	public void testPage() throws IOException {
		
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		EmpSQLMapper mapper = sqlSession.getMapper(EmpSQLMapper.class);
		//查询第二页，每页两条数据
		PageHelper.startPage(2, 2);
		List<Emp> list = mapper.getAllEmp();
		
		PageInfo<Emp> pageInfo = new PageInfo<>(list, 3); //第二个参数代表展示3个页码
		System.out.println(Arrays.toString(pageInfo.getNavigatepageNums()));
		
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}
}
