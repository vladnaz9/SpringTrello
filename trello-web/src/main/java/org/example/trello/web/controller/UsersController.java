package org.example.trello.web.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/users")
    public String getUsersPage(){
        return "users";
    }
}
