package com.joshdiaz.repository;

import java.util.List;

import com.joshdiaz.model.Employee;

public interface EmployeeRepository {
	
	public Employee getEmployeeByID(Integer Id);	
	
	public List<Employee> getEmployeesList();	

}
