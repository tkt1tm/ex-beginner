package com.example.controller;

import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam3")
public class Exam03Controller {
    @Autowired
    private ServletContext application;

    @GetMapping("input")
    public String input() {
        return "exam03";
    }
}
