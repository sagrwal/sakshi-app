package com.primesoft.sakshiapp.jpa;

import org.springframework.stereotype.Repository;

import com.primesoft.sakshiapp.util.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmployeeJPARepository {
	//if you want to talk with database use entityManager
	
	@PersistenceContext
	EntityManager entityManager;
	
	public void insert(Employee employee) {
		entityManager.merge(employee);
	}

	public Employee findById(long id) {
		return entityManager.find(Employee.class,id);
	}
	
	public void deleteById(long id) {
		 Employee employee = entityManager.find(Employee.class,id);
		 entityManager.remove(employee);
	}
}
