package com.github.gr3gdev.valkyrie.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Objects;

import com.github.gr3gdev.valkyrie.model.UserModel;
import com.github.gr3gdev.valkyrie.validator.PasswordMatch.PasswordMatchValidator;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatchValidator.class)
@Documented
public @interface PasswordMatch {
    String message() default "{error.password.mismatch}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, UserModel> {

        @Override
        public boolean isValid(UserModel value, ConstraintValidatorContext context) {
            return Objects.equals(value.getPassword(), value.getConfirmPassword());
        }

    }
}
