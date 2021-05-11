package org.example.trello.web.security.config;


import org.example.trello.api.service.UserService;
import org.example.trello.web.security.oauth2.CustomOAuth2User;
import org.example.trello.web.security.oauth2.CustomOAuth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    @Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;

    @Autowired
    public UserService signUpService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/signUp").permitAll()
                .antMatchers("/profile").authenticated()
                .antMatchers("/users").hasAuthority("ADMIN")
                .antMatchers("/", "/signIn","/oauth/**").permitAll()
                .antMatchers("/oauth2").permitAll()
                .and()
                .formLogin()
                .loginPage("/signIn")
                .usernameParameter("email")
                .defaultSuccessUrl("/profile")
                .failureUrl("/signIn?error")
                .and()
                .oauth2Login().loginPage("/signIn").userInfoEndpoint().userService(oAuth2UserService)
                .and()
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        CustomOAuth2User oAuth2User = (CustomOAuth2User) authentication.getPrincipal();
                        signUpService.registerOauth2(oAuth2User.getEmail(), oAuth2User.getName());
                        httpServletResponse.sendRedirect("/profile");
                    }
                })
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Autowired
    private CustomOAuth2UserService oAuth2UserService;
}
