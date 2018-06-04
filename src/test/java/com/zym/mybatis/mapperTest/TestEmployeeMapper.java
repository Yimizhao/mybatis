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

public class TestEmployeeMapper {

	@Test
	public void testaddEmp() throws IOException {

		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			Employee employee = new Employee("Lee", "0", "123@2564");
			mapper.addEmp(employee);
			System.out.println(mapper.getClass().getName());
			session.commit();
		} finally {
			session.close();
		}
	}

	@Test
	public void testdeleteEmpById() throws IOException {

		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			mapper.deleteEmpById(1);
			session.commit();
		} finally {
			session.close();
		}

	}

	@Test
	public void testupdateEmp() throws IOException {

		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession(true);
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			System.out.println(mapper.getClass());
			Employee employee = new Employee(2,"Lee", "0", "123@2564");
			mapper.updateEmp(employee);
		} finally {
			session.close();
		}

	}
	
	@Test
	public void testgetEmployeeById() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			Employee employee = mapper.getEmployeeById(2);
			System.out.println(mapper.getClass());
			System.out.println(employee);
		} finally {
			session.close();
		}
	}

}
