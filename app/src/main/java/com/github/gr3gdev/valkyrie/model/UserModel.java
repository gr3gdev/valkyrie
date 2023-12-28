package com.github.gr3gdev.valkyrie.model;

import lombok.Data;

import com.github.gr3gdev.valkyrie.validator.EmailMatch;
import com.github.gr3gdev.valkyrie.validator.PasswordMatch;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Data
@PasswordMatch
@EmailMatch
public class UserModel {
    @Min(1)
    @Max(100)
    private String firstname;
    @Min(1)
    @Max(100)
    private String lastname;
    @NotNull
    @Min(4)
    @Max(32)
    private String username;
    @Email
    private String email;
    @Email
    private String confirmEmail;
    @Min(8)
    @Max(100)
    private String password;
    @Min(8)
    @Max(100)
    private String confirmPassword;
}
