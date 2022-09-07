package com.primesoft.sakshiapp.dto;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.primesoft.sakshiapp.util.Employee;

@Repository
public class EmployeeJdbcRepository {
	
	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	private static String INSERT_QUERY=
					"""
					insert into emp_details(id,name,salary)
					 values(?,?,?);
	
									""";
	
	private static String DELETE_QUERY =
			"""
			delete from emp_details where id = ?

							""";
	
	private static String SELECT_QUERY =
			"""
			select * from emp_details where id = ?

							""";

	public void insert(Employee emp) {
		springJdbcTemplate.update(INSERT_QUERY,emp.getId(),emp.getName(),emp.getSalary());
	}

	public void deleteById(long id) {
		springJdbcTemplate.update(DELETE_QUERY,id);
	}
	public Employee findById(long id) {
		//ResultSet -> Bean => Row Mapper
		   return springJdbcTemplate.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(Employee.class),id);
		
		
		
	}

}
