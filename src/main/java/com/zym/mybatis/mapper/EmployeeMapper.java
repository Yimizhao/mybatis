package com.zym.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.zym.mybatis.test.domain.Employee;

@Mapper
public interface EmployeeMapper {
	public Employee getEmployeeById(int id);
}
