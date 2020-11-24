package com.paypal.bfs.validations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {AddressValidator.class})
@Documented
public @interface ValidateAddressDetails {
    String message() default "Invalid Address Details";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
