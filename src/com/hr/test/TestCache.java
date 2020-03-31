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
import com.hr.mapper.EmpSQLMapper;

public class TestCache {
	
	public SqlSessionFactory getSqlSessionFactory() throws IOException {

		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		return sqlSessionFactory;
	}

	@Test
	public void testFirstCache() throws IOException {
		
		/**
		 * mybatis中的一级缓存默认开启，是SqlSession级别的
		 * 即同一个SqlSession对应一个sql语句，执行以后就会存储在缓存中，下次执行相同的sql，直接从缓存中取
		 * 一级缓存失效的情况：
		 * 		不同的SqlSession对应不同的一级缓存
		 * 		同一个SqlSession但是查询条件不同
		 * 		同一个SqlSession两次查询期间执行了任何一次增删改操作，会自动将缓存清空
		 * 		同一个SqlSession两次查询期间手动清空了缓存
		 */
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		EmpSQLMapper mapper = sqlSession.getMapper(EmpSQLMapper.class);
		Emp emp = mapper.getEmpByEid("16");
		Emp emp1 = mapper.getEmpByEid("16");
		System.out.println(emp);
		System.out.println("++++++++++");
		System.out.println(emp1);
	}
	
	@Test
	public void testSecondCache() throws IOException {
		
		/**
		 * mybatis的二级缓存默认不开启，需要设置：
		 * 		1.在核心配置文件<settings/>中，加入配置：<setting name="cacheEnabled" value="true" />
		 * 		2.需要使用二级缓存的映射文件处使用cache配置缓存<cache />
		 * 		3.注意：POJO需要实现Serializable接口
		 * 注意：二级缓存在SqlSession关闭或提交之后才会生效
		 */
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		EmpSQLMapper mapper = sqlSession.getMapper(EmpSQLMapper.class);
		EmpSQLMapper mapper1 = sqlSession.getMapper(EmpSQLMapper.class);
		Emp emp = mapper.getEmpByEid("16");
		System.out.println(emp);
		
		//手动提交或关闭 二级缓存才会生效
		sqlSession.commit();
		System.out.println("++++++++++");
		
		Emp emp1 = mapper1.getEmpByEid("16");
		System.out.println(emp1);
	}
}
