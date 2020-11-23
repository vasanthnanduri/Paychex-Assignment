 package com.paypal.bfs.service.Impilementation;

import java.util.List;

import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.bfs.entity.EmployeeEntity;
import com.paypal.bfs.jparepository.repository.EmployeeRepository;
import com.paypal.bfs.macros.EmployeeToEmployeeEnity;
import com.paypal.bfs.service.EmployeeService;
import com.paypal.bfs.test.employeeserv.api.model.Employee;

/**
 * 
 * @author vasanthnanduri
 * Description: This class implements EmployeeService interface and overrides the methods mentioned.
 *
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeRepository employeeRepository;
	
	EmployeeToEmployeeEnity employeeToEmployeeEntity; 
	
	/**
	 * This method is used to perform dependency injection for repository classes and mapper classes
	 * @param employeeToEmployeeEntity
	 * @param employeeRepository
	 */
	public EmployeeServiceImpl(EmployeeToEmployeeEnity employeeToEmployeeEntity, EmployeeRepository employeeRepository) {
		this.employeeToEmployeeEntity = employeeToEmployeeEntity;
		this.employeeRepository = employeeRepository;
	}

	/**
	 * This method accepts an Id and pulls out any employee detail present in DB. validations are performed when mapper class is used to convert
	 * the input object to entity object.
	 */
	@Override
	public Employee getEmployeeById(String Id) {
		EmployeeEntity employeeEntity = employeeRepository.findById(Integer.parseInt(Id)).orElseThrow(NotFoundException::new);
		return employeeToEmployeeEntity.employeeEntityToEmployee(employeeEntity);
	}
	
	/**
	 * This Method accepts employee object and add it to the DB. validations are performed when mapper class is used to convert
	 * the input object to entity object.
	 */
	@Override
	public void addEmployee(Employee employee) {
		EmployeeEntity employeeEntity = employeeToEmployeeEntity.employeeToEmployeeEntity(employee);
		employeeRepository.save(employeeEntity);
		
	}
	
	/**
	 * This Method will pull all the employee details from DB.
	 */
	@Override
	public List<Employee> getEmplyoee() {
		List<EmployeeEntity> employeeEntities = (List<EmployeeEntity>) employeeRepository.findAll();
		return employeeToEmployeeEntity.employeeEntitiesToEmployees(employeeEntities);
	}

}
