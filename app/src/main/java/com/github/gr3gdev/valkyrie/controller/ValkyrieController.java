package com.github.gr3gdev.valkyrie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class ValkyrieController {

    @GetMapping({"/login", "/register", "/resetPassword"})
    String singlePage() {
        return "index";
    }
}
