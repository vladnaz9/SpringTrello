package org.example.trello.impl.service;

import org.example.trello.api.dto.UserDto;
import org.example.trello.api.dto.UserFormDto;
import org.example.trello.api.service.UserService;
import org.example.trello.impl.entity.UserEntity;
import org.example.trello.impl.jpa.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void register(UserFormDto form) {
        UserEntity newUser = UserEntity.builder()
                .email(form.getEmail())
                .username(form.getUsername())
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .role(UserEntity.Role.USER)
                .build();

        userRepository.save(newUser);
    }

    @Override
    public void registerOauth2(String email, String name) {
        Optional<UserEntity> userEntity = userRepository.findByEmail(email);
        if (!userEntity.isPresent()) {
            UserEntity newUser = UserEntity.builder()
                    .email(email)
                    .username(name)
                    .role(UserEntity.Role.USER)
                    .provider(UserEntity.Provider.GOOGLE)
                    .build();
            userRepository.save(newUser);
        }
    }

    @Override
    public boolean signIn(UserFormDto formDto){
        UserEntity  user = userRepository.findByEmail(formDto.getEmail())
                .orElseThrow(IllegalArgumentException::new);
                if(passwordEncoder.matches(formDto.getPassword(), user.getHashPassword())) {
                    return true;
                }
                return false;
    }

    @Override
    public List<UserDto> getAll() {
        return null;
    }

    @Override
    public UserDto findByUsername(String username) {
        return userRepository.findByUsername(username).map(userEntity -> modelMapper
                .map(userEntity, UserDto.class))
                .orElse(null);
    }


    @Override
    public UserDto findById(Long id) {
        return modelMapper.map(userRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new), UserDto.class);
    }

    @Override
    public UserDto findByEmail(String email) {
        return userRepository.findByEmail(email).map(userEntity -> modelMapper
                .map(userEntity, UserDto.class))
                .orElse(null);
    }


}
