package com.zym.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.zym.mybatis.test.domain.Employee;

@Mapper
public interface EmployeeMapper {
	// 查询数据
	public Employee getEmployeeById(int id);
	
	// 增加数据
	public void addEmp(Employee employee);
	
	// 删除数据
	public Integer deleteEmpById(Integer id);
	
	// 修改数据
	public void updateEmp(Employee employee);
	
}
