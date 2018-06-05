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

		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
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

		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			Integer re = mapper.deleteEmpById(3);
			// 手动提交
			session.commit();
			System.out.println(re);
		} finally {
			session.close();
		}

	}

	@Test
	public void testupdateEmp() throws IOException {

		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		// 自动提交
		SqlSession session = sqlSessionFactory.openSession(true);
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			System.out.println(mapper.getClass());
			Employee employee = new Employee(3, "Lee", "0", "123@2564");
			mapper.updateEmp(employee);
		} finally {
			session.close();
		}

	}

	@Test
	public void testgetEmployeeById() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
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

	private SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}
}
