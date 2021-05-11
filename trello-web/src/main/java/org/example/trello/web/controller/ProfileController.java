package org.example.trello.web.controller;

import org.example.trello.api.dto.UserDto;
import org.example.trello.api.service.UserService;
import org.example.trello.web.security.details.UserDetailsImpl;
import org.example.trello.web.security.oauth2.CustomOAuth2User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {
    @Autowired
    public UserService userService;


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/profile")
    public String getProfilePage(@AuthenticationPrincipal UserDetailsImpl user, @AuthenticationPrincipal CustomOAuth2User customOAuth2User, Model model) {
        UserDto userDto;
        if (user == null) {
            userDto = userService.findByEmail(customOAuth2User.getEmail());
        } else {
            userDto = userService.findByEmail(user.getEmail());
        }
        model.addAttribute("user", userDto);
        return "profile";
    }
}
