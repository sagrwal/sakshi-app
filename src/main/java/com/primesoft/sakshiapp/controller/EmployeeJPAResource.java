package com.primesoft.sakshiapp.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.primesoft.sakshiapp.exception.UserNotFoundException;
import com.primesoft.sakshiapp.jpa.EmployeeRepository;
import com.primesoft.sakshiapp.util.Employee;



@RestController
public class EmployeeJPAResource {
	
	
	private EmployeeRepository repository;

	public EmployeeJPAResource(EmployeeRepository repository) {
		
		this.repository = repository;
	}
	
	@GetMapping("/jpa/employees")
	public List<Employee> retrieveAllUsers(){
		return repository.findAll();
		
	}
	

	@GetMapping("/jpa/users/{id}")
	public EntityModel<Employee> retrieveUser(@PathVariable int id){
		 Optional<Employee> user= repository.findById(id);
		
		 if(user.isEmpty())throw new UserNotFoundException("id:"+id);
		
		EntityModel<Employee>  entityModel = EntityModel.of(user.get());
		
		WebMvcLinkBuilder link= linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}
	
}
