package com.github.gr3gdev.valkyrie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.github.gr3gdev.valkyrie.model.UserModel;
import com.github.gr3gdev.valkyrie.service.JpaUserDetailsService;
import com.github.gr3gdev.valkyrie.validator.UsernameExists;

@Controller
class ValkyrieController {

    private final JpaUserDetailsService userDetailsService;

    public ValkyrieController(JpaUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/login")
    String login() {
        return "index";
    }

    @PostMapping("/register")
    public String register(@Validated @RequestBody UserModel userModel) {
        userDetailsService.save(userModel);
        return "index";
    }

    @PostMapping("/resetPassword")
    public String resetPassword(@UsernameExists @RequestBody String username) {
        return "index";
    }
}
