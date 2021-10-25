package io.codehunters.commons.web.rest.support.constraint.validation.annotation;

import io.codehunters.commons.web.rest.support.constraint.validation.UUIDValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = UUIDValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UUIDConstraint {

    String message() default "Invalid uuid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
