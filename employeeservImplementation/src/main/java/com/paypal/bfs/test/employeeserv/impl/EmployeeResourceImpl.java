package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.service.EmployeeService;
import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.print.attribute.standard.Severity;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.glassfish.jersey.internal.Errors.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {
	
	@Autowired
	EmployeeService employeeService;
	
	/**
	 * This method is a rest end point which accepts an employee id and return employee object if exists.
	 */
    @Override
    public ResponseEntity<Employee> employeeGetById(String id) {

        Employee employee = employeeService.getEmployeeById(id);

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    /**
     * This method is a rest end point which accepts employee object and saves it in DB
     */
	@Override
	public ResponseEntity<Employee> addEmployee(@Valid Employee employee) {
		
		employeeService.addEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	/**
	 * This method is a rest end point which will return all the employee details present in DB.
	 */
	@Override
	public ResponseEntity<List<Employee>> getEmployees() {
		
        List<Employee> employees = employeeService.getEmplyoee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	/**
	 * 
	 * This method acts as an exception handler. If any validation or error occurs, It sends the response accordingly.
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> handleConstraintViolatedException(ConstraintViolationException ex) {
		Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();


		List<String> errors = new ArrayList<>(constraintViolations.size());
		String error;
		for (ConstraintViolation constraintViolation : constraintViolations) {

			error = constraintViolation.getMessage();
			errors.add(error);
		}

		Error errorString = new Error(errors.toString());
		return new ResponseEntity<>(errorString.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
