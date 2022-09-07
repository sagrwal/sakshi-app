package com.primesoft.sakshiapp.service;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.primesoft.sakshiapp.util.Employee;


@Component
public class EmployeeDAO {
	
	private static List<Employee> employees= new ArrayList<>();
	private static int empCount =0;
	
/*
	static {
		employees.add(new Employee(++empCount,"Adam",30000.00f));
		employees.add(new Employee(++empCount,"Eve",500000.0f));
		employees.add(new Employee(++empCount,"Jim",900000.0f));
	}
	*/

	public List<Employee> findAll(){
		return employees;
	}
	public Employee save(Employee emp) {
		emp.setId(++empCount);
		employees.add(emp);
		return emp;
	}
	public Employee findOne(int id) {
		Predicate<? super Employee> predicate = emp -> emp.getId().equals(id); 
		
		return employees.stream().filter(predicate).findFirst().orElse(null);
	}

	public void deleteById(int id) {
		Predicate<? super Employee> predicate = emp -> emp.getId().equals(id); 
		employees.removeIf(predicate);
	
	}
	
}
