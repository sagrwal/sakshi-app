package com.primesoft.sakshiapp.springdata.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.primesoft.sakshiapp.util.Employee;

public interface EmployeeSpringDataJpaRepository extends JpaRepository<Employee,Integer> {

	//Your own custom method 
	List<Employee> findByName(String name);
}
