package com.paypal.bfs.validations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EmployeeValidator.class})
@Documented
public @interface ValidateEmployeeDetails {
    String message() default "Invalid Employee Details";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
