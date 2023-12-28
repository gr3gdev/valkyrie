package com.github.gr3gdev.valkyrie.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Objects;

import com.github.gr3gdev.valkyrie.model.UserModel;
import com.github.gr3gdev.valkyrie.validator.EmailMatch.EmailMatchValidator;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailMatchValidator.class)
@Documented
public @interface EmailMatch {
    String message() default "{error.email.mismatch}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    public class EmailMatchValidator implements ConstraintValidator<EmailMatch, UserModel> {

        @Override
        public boolean isValid(UserModel value, ConstraintValidatorContext context) {
            return Objects.equals(value.getEmail(), value.getConfirmEmail());
        }

    }
}
