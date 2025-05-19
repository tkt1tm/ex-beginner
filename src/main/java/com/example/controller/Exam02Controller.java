package com.example.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam2")
public class Exam02Controller {
    @Autowired
    private HttpSession session;

    @GetMapping("/input")
    public String input() {
        return "exam02";
    }

    @PostMapping("/result1")
    public String result1(Integer num1, Integer num2) {
        session.setAttribute("num1", num1);
        session.setAttribute("num2", num2);
        session.setAttribute("result", num1 + num2);
        return "exam02-result";
    }

    @GetMapping("/result2")
    public String result2() {
        return "exam02-result2";
    }
}
