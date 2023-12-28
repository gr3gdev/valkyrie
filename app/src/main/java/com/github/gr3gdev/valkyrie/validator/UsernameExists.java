package com.github.gr3gdev.valkyrie.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

import com.github.gr3gdev.valkyrie.service.JpaUserDetailsService;
import com.github.gr3gdev.valkyrie.validator.UsernameExists.UsernameExistsValidator;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UsernameExistsValidator.class)
@Documented
public @interface UsernameExists {

    String message() default "{error.username.notfound}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Component
    public class UsernameExistsValidator implements ConstraintValidator<UsernameExists, String> {

        private final JpaUserDetailsService userDetailsService;

        public UsernameExistsValidator(JpaUserDetailsService userDetailsService) {
            this.userDetailsService = userDetailsService;
        }

        @Override
        public boolean isValid(String username, ConstraintValidatorContext context) {
            return userDetailsService.exists(username);
        }

    }
}
