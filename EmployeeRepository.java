package com.shivila.boot.repository;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivila.boot.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	// All Crud database methods
	
	
}
