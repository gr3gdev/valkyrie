package com.github.gr3gdev.valkyrie.model;

import com.github.gr3gdev.valkyrie.validator.EmailMatch;
import com.github.gr3gdev.valkyrie.validator.PasswordMatch;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@PasswordMatch
@EmailMatch
public class UserModel {
    @NotBlank
    @Size(min = 1, max = 100)
    private String firstname;
    @NotBlank
    @Size(min = 1, max = 100)
    private String lastname;
    @NotBlank
    @Size(min = 4, max = 32)
    private String username;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Email
    private String confirmEmail;
    @NotBlank
    @Size(min = 8, max = 100)
    private String password;
    @NotBlank
    @Size(min = 8, max = 100)
    private String confirmPassword;
}
