package org.example.trello.api.service;


import org.example.trello.api.dto.UserDto;
import org.example.trello.api.dto.UserFormDto;

import java.util.List;

public interface UserService {

     void register(UserFormDto userFromDto);

     void registerOauth2(String email, String name);

    List<UserDto> getAll();

    UserDto findByUsername(String username);

    UserDto findById(Long id);

    UserDto findByEmail(String email);
    boolean signIn(UserFormDto userFormDto);

//    void deleteUser(Long id);

}
