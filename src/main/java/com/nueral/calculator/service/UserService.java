package com.nueral.calculator.service;

import com.nueral.calculator.dto.UserSaveDto;
import com.nueral.calculator.repository.UserRepository;
import com.nueral.calculator.entity.User;
import com.nueral.calculator.types.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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
                .role(Role.valueOf(userSaveDto.getRole()))
                .build();

        userRepository.save(user);
    }
    public List<User> userInfo(){
        return userRepository.findAll();
    }

    public String updateUser(UserSaveDto userSaveDto){
        User saveUser = User.builder()
                .username(userSaveDto.getUsername())
                .password(userSaveDto.getPassword())
                .role(Role.valueOf(userSaveDto.getRole()))
                .id(userSaveDto.getId())
                .build();
        userRepository.save(saveUser);
        return "redirect:/home";
    }
}
