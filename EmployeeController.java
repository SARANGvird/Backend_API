package com.shivila.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shivila.boot.exceptn.ResourceNFExcption;
import com.shivila.boot.model.Employee;
import com.shivila.boot.repository.EmployeeRepository;




@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository repo;
	
	@GetMapping
	public java.util.List<Employee>getList(){
	return repo.findAll();	
	}
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return repo.save(employee);
	}
	
	//Build get employee id
	
	@GetMapping("{id}")    
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
	Employee employee=repo.findById(id).orElseThrow(()->new ResourceNFExcption("Employee not exist with id:"+id));
	return ResponseEntity.ok(employee);
	}
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody  Employee employeeDetails){
	Employee updateemployee=repo.findById(id).orElseThrow(()->new ResourceNFExcption("Employee not exist with id:"+id));
	
	updateemployee.setFirstName(employeeDetails.getFirstName());
	updateemployee.setLastName(employeeDetails.getLastName());
	updateemployee.setEmai_id(employeeDetails.getEmai_id());
	updateemployee.setGender(employeeDetails.getGender());        
	updateemployee.setMobileNumber(employeeDetails.getMobileNumber());
	repo.save(updateemployee);
	return ResponseEntity.ok(updateemployee);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id){
	Employee employee=repo.findById(id).orElseThrow(()->new ResourceNFExcption("Employee  not exist with id:"+id));
	repo.delete(employee);
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

} 


