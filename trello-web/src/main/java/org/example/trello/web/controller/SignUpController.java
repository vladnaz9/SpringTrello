package org.example.trello.web.controller;

import org.example.trello.api.dto.UserFormDto;
import org.example.trello.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.security.PermitAll;

@Controller
public class SignUpController  {

    @Autowired
    public UserService signUpService;

    @GetMapping("/signUp")
    public String getSignUpPage(Model model) {
        return "register";
    }
    @PermitAll
    @PostMapping("/signUp")
    public String signUp(UserFormDto form){
        signUpService.register(form);
        return "redirect:/signIn";
    }
}
