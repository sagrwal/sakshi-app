package com.primesoft.sakshiapp.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.primesoft.sakshiapp.jpa.EmployeeJPARepository;
import com.primesoft.sakshiapp.springdata.jpa.EmployeeSpringDataJpaRepository;
import com.primesoft.sakshiapp.util.Employee;

@Component
public class EmployeeCommandLineRunner implements CommandLineRunner{

	@Autowired
   // private EmployeeJdbcRepository  repo;
     // private EmployeeJPARepository repo; 
      private EmployeeSpringDataJpaRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		//  This is use for JDBC and JPA not for SprintData JPA
	  /* repo.insert(new Employee(1,"Sakshi",70000.00f));
		 repo.insert(new Employee(2,"Shikha",90000.00f));
		 repo.insert(new Employee(3,"Swati",60000.00f));
		 repo.insert(new Employee(4,"Saba",80000.00f));
		 
		 repo.deleteById(2);
		 
		 System.out.println(repo.findById(1));
		 System.out.println(repo.findById(3));
		*/
		
		// For Spring data JPA 
		 repo.save(new Employee(1,"Sakshi",70000.00f));
		 repo.save(new Employee(2,"Shikha",90000.00f));
		 repo.save(new Employee(3,"Swati",60000.00f));
		 repo.save(new Employee(4,"Saba",80000.00f));
	
         repo.deleteById(2);
		 
		 System.out.println(repo.findById(1));
		 System.out.println(repo.findById(3));
		 
		 System.out.println(repo.findAll());
		 System.out.println("==========================");
		 
		 //your own custom method created in springdatajparepository
		 System.out.println(repo.findByName("Sakshi"));
	
	}
	

	
}
