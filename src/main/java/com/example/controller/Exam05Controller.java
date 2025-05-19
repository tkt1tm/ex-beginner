package com.example.controller;

import com.example.domain.Member;
import com.example.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/exam05")
public class Exam05Controller {
    @Autowired
    private MemberRepository repository;

    @GetMapping("/input")
    public String input() {
        return "exam05";
    }

    @PostMapping("/result")
    public String result(String name, Model model) {
        List<Member> members = repository.findByName(name);
        model.addAttribute("members", members);
        return "exam05-result";
    }
}
