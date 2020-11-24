package com.paypal.bfs.macros;

import com.paypal.bfs.entity.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-23T06:43:57-0500",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_241 (Oracle Corporation)"
)
@Component
public class EmployeeToEmployeeEnityImpl implements EmployeeToEmployeeEnity {

    private final AddressToAddressEntity addressToAddressEntity;

    @Autowired
    public EmployeeToEmployeeEnityImpl(AddressToAddressEntity addressToAddressEntity) {

        this.addressToAddressEntity = addressToAddressEntity;
    }

    @Override
    public EmployeeEntity employeeToEmployeeEntity(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeEntity employeeEntity = new EmployeeEntity();

        employeeEntity.setId( employee.getId() );
        employeeEntity.setFirstName( employee.getFirstName() );
        employeeEntity.setLastName( employee.getLastName() );
        employeeEntity.setDateOfBirth( employee.getDateOfBirth() );
        employeeEntity.setAddress( addressToAddressEntity.addressToAddressEntity( employee.getAddress() ) );

        return employeeEntity;
    }

    @Override
    public Employee employeeEntityToEmployee(EmployeeEntity employeeEntity) {
        if ( employeeEntity == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId( employeeEntity.getId() );
        employee.setFirstName( employeeEntity.getFirstName() );
        employee.setLastName( employeeEntity.getLastName() );
        employee.setDateOfBirth( employeeEntity.getDateOfBirth() );
        employee.setAddress( addressToAddressEntity.addressEntityToAddress( employeeEntity.getAddress() ) );

        return employee;
    }

    @Override
    public List<Employee> employeeEntitiesToEmployees(List<EmployeeEntity> employeeEntities) {
        if ( employeeEntities == null ) {
            return null;
        }

        List<Employee> list = new ArrayList<Employee>( employeeEntities.size() );
        for ( EmployeeEntity employeeEntity : employeeEntities ) {
            list.add( employeeEntityToEmployee( employeeEntity ) );
        }

        return list;
    }
}
