package com.shivila.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shivila.boot.model.Employee;
import com.shivila.boot.repository.EmployeeRepository;

@SpringBootApplication
public class BootBackEndApplication implements CommandLineRunner {

	public static void main(String[] args){SpringApplication.run(BootBackEndApplication.class, args);
	}
		
	@Autowired
	private EmployeeRepository repo;
		
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Employee employee=new Employee();
		employee.setId(1);
		employee.setFirstName("Rohit");
		employee.setLastName("Sharma");
 		employee.setEmai_id("Sharma@gmail.com");   
		employee.setGender("Male");
		employee.setMobileNumber(904999999);
		repo.save(employee);
		
		
		Employee employee1=new Employee();
		employee1.setId(2);
		employee1.setFirstName("virat");
		employee1.setLastName("kohli");
		employee1.setEmai_id("virat@gmail.com");
		employee1.setGender("Male");
		employee1.setMobileNumber(90498888);
		repo.save(employee1);
	}
		 
		
	}


