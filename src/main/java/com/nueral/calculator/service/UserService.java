package com.nueral.calculator.service;

import com.nueral.calculator.dto.UserSaveDto;
import com.nueral.calculator.repository.UserRepository;
import com.nueral.calculator.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void savaUser(UserSaveDto userSaveDto){
        User user = User.builder()
                .username(userSaveDto.getUsername())
                .password(passwordEncoder.encode(userSaveDto.getPassword()))
                .role(userSaveDto.getRole())
                .build();

        userRepository.save(user);
    }
}
