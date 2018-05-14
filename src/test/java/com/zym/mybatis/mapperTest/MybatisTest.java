package com.zym.mybatis.mapperTest;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.zym.mybatis.mapper.EmployeeMapper;
import com.zym.mybatis.test.domain.Employee;

public class MybatisTest {

	@Test
	public void test() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();

		try {
			Employee selectOne = (Employee) openSession.selectOne("com.zym.mybatis.mapper.employeeMapper.selectEmp", 4);
			System.out.println(selectOne);
		} finally {
			openSession.close();
		}
	}

	@Test
	public void test01() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			Employee employee = mapper.getEmployeeById(3);
			System.out.println(employee);
		} finally {
			session.close();
		}
	}

	@Test
	public void test02() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			Object[] args = {"zhao", 3};
			mapper.updateEmployeeById(args);
		} finally {
			session.close();
		}
	}

}
