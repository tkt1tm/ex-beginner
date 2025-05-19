package com.example.controller;

import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam3")
public class Exam03Controller {
    @Autowired
    private ServletContext application;

    @GetMapping("/input")
    public String input() {
        return "exam03";
    }

    @PostMapping("/result")
    public String result(int item1, int item2, int item3) {
        int total = item1 + item2 + item3;
        application.setAttribute("taxExcluded", total);
        application.setAttribute("taxIncluded", (int)(total * 1.1));
        return "exam03-result";
    }
}
