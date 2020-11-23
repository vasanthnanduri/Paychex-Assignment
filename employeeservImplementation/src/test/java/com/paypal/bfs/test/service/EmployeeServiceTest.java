package com.paypal.bfs.test.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.paypal.bfs.entity.AddressEntity;
import com.paypal.bfs.entity.EmployeeEntity;
import com.paypal.bfs.jparepository.repository.EmployeeRepository;
import com.paypal.bfs.macros.AddressToAddressEntityImpl;
import com.paypal.bfs.macros.EmployeeToEmployeeEnity;
import com.paypal.bfs.macros.EmployeeToEmployeeEnityImpl;
import com.paypal.bfs.service.EmployeeService;
import com.paypal.bfs.service.Impilementation.EmployeeServiceImpl;
import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {EmployeeToEmployeeEnityImpl.class, AddressToAddressEntityImpl.class})
public class EmployeeServiceTest {
	
	@Autowired
	EmployeeToEmployeeEnity employeeToEmployeeEnity;
	
	@Mock
	EmployeeRepository employeeRepository;
	
	EmployeeService employeeService;
	
	Employee employee;
	Address address;
	
	EmployeeEntity employeeEntity;
	AddressEntity addressEntity;
	List<EmployeeEntity> emList;
	List<Employee> eList;
	
	@Before
	public void setUp() {
		
		employee = new Employee();
		employee.setId(1);
		employee.setFirstName("Sam");
		employee.setLastName("Smith");
		employee.setDateOfBirth("12-Jan-1980");
		
		address = new Address();
		address.setId(1);
		address.setLine1("198 Main St");
		address.setCity("Tully");
		address.setState("NY");
		address.setCountry("USA");
		address.setZipCode("00846");
		
		employee.setAddress(address);
		
		eList = new ArrayList<Employee>();
		eList.add(employee);
		
		employeeEntity = new EmployeeEntity();
		employeeEntity.setId(1);
		employeeEntity.setFirstName("Sam");
		employeeEntity.setLastName("Smith");
		employeeEntity.setDateOfBirth("12-Jan-1980");
		
		addressEntity = new AddressEntity();
		addressEntity.setId(1);
		addressEntity.setLine1("198 Main St");
		addressEntity.setCity("Tully");
		addressEntity.setState("NY");
		addressEntity.setCountry("USA");
		addressEntity.setZipCode("00846");
		
		employeeEntity.setAddress(addressEntity);
		
		emList = new ArrayList<EmployeeEntity>();
		emList.add(employeeEntity);
		
		
		employeeService = new EmployeeServiceImpl(employeeToEmployeeEnity, employeeRepository);
		
		Mockito.when(employeeRepository.findById(1)).thenReturn(Optional.of(employeeEntity));
		
		Mockito.when(employeeRepository.save(employeeEntity)).thenReturn(employeeEntity);
		
		Mockito.when(employeeRepository.findAll()).thenReturn(emList);
		
	}
	
	@Test
	public void getEmployeeByIdTest() {
		Employee employeeActual = employeeService.getEmployeeById("1");
		assertEquals(employeeActual, employee);
	}
	
	@Test
	public void getEmployeesAllTest() {
		List<Employee> employees = employeeService.getEmplyoee();
		assertEquals(eList, employees);
	}

}
