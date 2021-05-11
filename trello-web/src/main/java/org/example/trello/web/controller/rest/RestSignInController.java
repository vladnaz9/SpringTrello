package org.example.trello.web.controller.rest;

import org.example.trello.api.dto.UserDto;
import org.example.trello.api.dto.UserFormDto;
import org.example.trello.api.service.UserService;
import org.example.trello.impl.entity.UserEntity;
import org.example.trello.web.security.config.jwt.provider.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RestSignInController {


    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;


    @Autowired
    public RestSignInController(JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @PostMapping("/restApi/SignIn")
    public ResponseEntity login(@RequestBody UserFormDto formDto) {
        try {
            String email = formDto.getUsername();


            if (userService.signIn(formDto)) {
                String token = jwtTokenProvider.createToken(email);

                Map<Object, Object> response = new HashMap<>();
                response.put("username", email);
                response.put("token", token);

                return ResponseEntity.ok(response);

            }
            throw new UsernameNotFoundException("User with username: " + email + " not found");

        } catch (UsernameNotFoundException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }
}

