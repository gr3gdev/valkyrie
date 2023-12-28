package com.github.gr3gdev.valkyrie.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.gr3gdev.valkyrie.model.UserModel;
import com.github.gr3gdev.valkyrie.service.JpaUserDetailsService;
import com.github.gr3gdev.valkyrie.validator.UsernameExists;

@RestController
@RequestMapping("/")
public class ValkyrieRestController {

    private final JpaUserDetailsService userDetailsService;

    public ValkyrieRestController(JpaUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/register")
    public UserDetails register(@Validated @RequestBody UserModel userModel) {
        return userDetailsService.save(userModel);
    }

    @PostMapping("/resetPassword")
    public String resetPassword(@UsernameExists @RequestBody String username) {
        // TODO reset password
        return "index";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        final Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String source;
            if (error instanceof FieldError) {
                source = ((FieldError) error).getField();
            } else {
                source = error.getObjectName();
            }
            final String errorMessage = error.getDefaultMessage();
            errors.put(source, errorMessage);
        });
        return errors;
    }
}
