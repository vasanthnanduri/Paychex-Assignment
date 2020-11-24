package com.paypal.bfs.validations;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.paypal.bfs.entity.AddressEntity;

public class AddressValidator implements ConstraintValidator<ValidateAddressDetails, String> {
	
    @Autowired
    Validator validator;


	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value != null ) {
			return !value.isEmpty();
		}
		return false;
	}

}
