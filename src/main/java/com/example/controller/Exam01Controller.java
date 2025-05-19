package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam1")
public class Exam01Controller {
    @GetMapping("/input")
    public String input() {
        return "exam01";
    }

    @PostMapping("/result")
    public String result(String name, Model model) {
        model.addAttribute("name", name);
        return "exam01-result";
    }
}
