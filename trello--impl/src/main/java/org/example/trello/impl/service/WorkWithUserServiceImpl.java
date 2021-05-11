//package org.example.trello.impl.service;
//
//
//import org.modelmapper.ModelMapper;
//import org.example.trello.api.dto.UserDto;
//import org.example.trello.api.dto.UserFormDto;
//import org.example.trello.api.service.WorkWithUserService;
//import org.example.trello.impl.entity.UserEntity;
//import org.example.trello.impl.jpa.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class WorkWithUserServiceImpl implements WorkWithUserService {
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private ModelMapper modelMapper;
//
//    public void signUp(UserFormDto form) {
//        UserEntity newUser = UserEntity.builder()
//                .email(form.getEmail())
//                .username(form.getUsername())
//                .hashPassword(passwordEncoder.encode(form.getPassword()))
//                .role(UserEntity.Role.USER)
//                .build();
//
//        userRepository.save(newUser);
//    }
//
//
//    public UserDto getByUsername(String username) {
//        return userRepository.findByEmail(username).map(userEntity -> modelMapper
//        .map(userEntity, UserDto.class))
//        .orElse(null);
//    }
//}
