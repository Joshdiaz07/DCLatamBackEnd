package com.joshdiaz.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joshdiaz.model.Employee;
import com.joshdiaz.repository.EmployeeRepository;

@RestController
@RequestMapping("/DCLatamBackEnd/")
public class EmployeeREST {
	
	@Autowired
	private EmployeeRepository employeeService;
	
	@GetMapping("/employeeById")
	private ResponseEntity<Employee> getEmployeeByID(Integer Id){
		return ResponseEntity.ok(employeeService.getEmployeeByID(Id));
	}
	
	@GetMapping("/employeesList")
	private ResponseEntity<List<Employee>> getEmployeesList(){
		return ResponseEntity.ok(employeeService.getEmployeesList());
	}
	

}
