package org.example.trello.web.controller.rest;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.trello.api.dto.UserFormDto;
import org.example.trello.api.service.UserService;
import org.example.trello.web.security.config.jwt.provider.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
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


    @Operation(summary = "Get authenticate")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "all good",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserFormDto.class)) }),
            @ApiResponse(responseCode = "500", description = "Invalid email ",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "u have some problem",
                    content = @Content) })
    @PostMapping("/restApi/SignIn")
    public ResponseEntity login(@RequestBody UserFormDto formDto) {
        try {
            String email = formDto.getEmail();


            if (userService.signIn(formDto)) {
                String token = jwtTokenProvider.createToken(email);

                Map<Object, Object> response = new HashMap<>();
                response.put("email", email);
                response.put("token", token);

                return ResponseEntity.ok(response);

            }
            throw new UsernameNotFoundException("User with username: " + email + " not found");

        } catch (UsernameNotFoundException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }
}

