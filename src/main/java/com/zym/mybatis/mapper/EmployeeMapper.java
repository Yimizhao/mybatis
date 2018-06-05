package com.zym.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zym.mybatis.test.domain.Employee;

@Mapper
public interface EmployeeMapper {
	// 查询数据
	public Employee getEmployeeById(int id);

	// 模糊查询数据
	public List<Employee> getEmployeesByLastName(String lastName);

	// 查询数据(命名参数)
	public Employee getEmployeeByIdAndLastName(@Param("id") Integer id, @Param("lastName") String lastName);

	// 增加数据
	public void addEmp(Employee employee);

	// 删除数据
	public Integer deleteEmpById(Integer id);

	// 修改数据
	public void updateEmp(Employee employee);

}
