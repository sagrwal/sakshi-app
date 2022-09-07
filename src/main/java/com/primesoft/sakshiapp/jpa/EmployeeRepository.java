package com.primesoft.sakshiapp.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.primesoft.sakshiapp.util.Employee;

public interface EmployeeRepository    extends JpaRepository<Employee,Integer>  {

}
