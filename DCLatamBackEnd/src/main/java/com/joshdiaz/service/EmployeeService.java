package com.joshdiaz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.joshdiaz.model.Employee;
import com.joshdiaz.model.ResponseEmployee;
import com.joshdiaz.model.ResponseEmployeesList;
import com.joshdiaz.repository.EmployeeRepository;

@Service
public class EmployeeService implements EmployeeRepository {
	
	@Value("${spring.external.service.url.employeeById}")
	private String uriEmployeeById;
	
	@Value("${spring.external.service.url.employeeList}")
	private String uriEmployeeList;
	
	private RestTemplate restTemplate;

	@Override
	public Employee getEmployeeByID(Integer Id) {
		restTemplate = new RestTemplate();
		String uri = uriEmployeeById + Id;
		ResponseEmployee responseEmployee = restTemplate.getForObject(uri, ResponseEmployee.class);
		Employee employee = responseEmployee.getData();
		employee.setEmployee_anual_salary(employee.getEmployee_salary()*12);
		return employee;
	}

	@Override
	public List<Employee> getEmployeesList() {
		restTemplate = new RestTemplate();
		String uri = uriEmployeeList;
		ResponseEmployeesList responseEmployeesList = restTemplate.getForObject(uri, ResponseEmployeesList.class);
		List<Employee> employeeList = responseEmployeesList.getData();
		List<Employee> employeeNewList = new ArrayList<>();
		for(Employee employ : employeeList) {
			employ.setEmployee_anual_salary(employ.getEmployee_salary()*12);
			employeeNewList.add(employ);
		}
		return employeeNewList;
	}

}
