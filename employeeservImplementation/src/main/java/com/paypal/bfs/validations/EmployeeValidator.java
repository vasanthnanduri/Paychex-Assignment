package com.paypal.bfs.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmployeeValidator implements ConstraintValidator<ValidateEmployeeDetails, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value != null ) {
			return !value.isEmpty();
		}
		return false;
	}

}
