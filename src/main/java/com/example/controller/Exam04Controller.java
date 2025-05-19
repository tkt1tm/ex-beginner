package com.example.controller;

import com.example.domain.User;
import com.example.form.UserForm;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam04")
public class Exam04Controller {

    @GetMapping("/input")
    public String input(UserForm userForm) {
        return "exam04";
    }

    @PostMapping("/result")
    public String result(@Validated UserForm userForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return input(userForm);
        }

        User user = new User();
        BeanUtils.copyProperties(userForm, user);
        model.addAttribute("user", user);
        return "exam04-result";
    }
}
