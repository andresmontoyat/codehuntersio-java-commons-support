package io.codehunters.commons.web.rest.support.constraint.validation;

import io.codehunters.commons.web.rest.support.constraint.validation.annotation.UUIDConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.UUID;

public class UUIDValidator implements ConstraintValidator<UUIDConstraint, String> {

    @Override
    public void initialize(UUIDConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String field, ConstraintValidatorContext constraintValidatorContext) {
        try {
            UUID.fromString(field);
        } catch (Exception e) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
