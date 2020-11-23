package com.paypal.bfs.macros;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.paypal.bfs.entity.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.api.model.Employee;

/**
 * 
 * @author vasanthnanduri
 * Description: This class is used to map data from dao to entity and back to dto. As typical entity classes have same structure as the table, so that we can easily persist them.
 * This Mapper class make it simple. this will dynamically create the implementation class to copy date from dao to entity and back to dto once curd operation is done.
 *
 */

@Mapper(componentModel = "spring", uses = AddressToAddressEntity.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface EmployeeToEmployeeEnity {
	
	EmployeeEntity employeeToEmployeeEntity(Employee employee);
	
	Employee employeeEntityToEmployee(EmployeeEntity employeeEntity);
	
	List<Employee> employeeEntitiesToEmployees(List<EmployeeEntity> employeeEntities);

}
