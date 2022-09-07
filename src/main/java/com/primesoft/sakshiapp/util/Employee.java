package com.primesoft.sakshiapp.util;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;


@Entity(name="emp_details")
public class Employee {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer Id;
	

	@Size(min=2, message="Name should have atleast 2 character")
	//@JsonProperty("name")
	private String name;
	
	//@JsonProperty("salary")
	private Float salary;
	public Employee() {
		
	}
	public Employee(Integer id, String name, Float salary) {
		
		Id = id;
		this.name = name;
		this.salary = salary;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getSalary() {
		return salary;
	}
	public void setSalary(Float salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", name=" + name + ", salary=" + salary + "]";
	}
	

}
