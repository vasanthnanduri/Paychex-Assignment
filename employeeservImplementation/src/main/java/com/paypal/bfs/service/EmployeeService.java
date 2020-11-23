package com.paypal.bfs.service;

import java.util.List;

import com.paypal.bfs.test.employeeserv.api.model.Employee;

/**
 * 
 * @author vasanthnanduri
 * Description: This is an employee Service interface.
 *
 */

public interface EmployeeService {
	
	public Employee getEmployeeById(String Id);
	
	public void addEmployee(Employee employee);
	
	public List<Employee> getEmplyoee();

}
