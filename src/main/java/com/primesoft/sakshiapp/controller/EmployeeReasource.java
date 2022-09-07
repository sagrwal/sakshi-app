package com.primesoft.sakshiapp.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.primesoft.sakshiapp.exception.UserNotFoundException;
import com.primesoft.sakshiapp.service.EmployeeDAO;
import com.primesoft.sakshiapp.util.Employee;

import jakarta.validation.Valid;


@RestController
public class EmployeeReasource {
	
	private EmployeeDAO service;

	public EmployeeReasource(EmployeeDAO service) {
	
		this.service = service;
	}
	
	@GetMapping("/emps")
	public List<Employee> retrieveAllEmployees(){
		return service.findAll();
		
	}
	
	@GetMapping("/emps/{id}")
	public EntityModel<Employee> retrieveEmployees(@PathVariable int id){
		 Employee emp= service.findOne(id);
		if(emp==null)throw new UserNotFoundException("id:"+id);
		
		EntityModel<Employee>  entityModel = EntityModel.of(emp);
		
		WebMvcLinkBuilder link= linkTo(methodOn(this.getClass()).retrieveAllEmployees());
		entityModel.add(link.withRel("all-employees"));
		return entityModel;
	}
	
	@DeleteMapping("/emps/{id}")
	public void deleteEmployee(@PathVariable int id){
		 service.deleteById(id);
		
	}
	
	@PostMapping("/emps")
	public ResponseEntity<Employee> createUser(@Valid @RequestBody Employee emp) {
		Employee savedEmp=service.save(emp);
		
		URI location =ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedEmp.getId())
				.toUri();
		return ResponseEntity.created(location).build(); //201 response
	}
	
}
