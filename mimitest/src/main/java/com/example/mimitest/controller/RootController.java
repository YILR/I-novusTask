package com.example.mimitest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/")
    public String root() {
        return "index.html";
    }

    @GetMapping("/top")
    public String top() {
        return "topCats.html";
    }
}
