package com.nueral.calculator.controller;

import com.nueral.calculator.dto.UserSaveDto;
import com.nueral.calculator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/join")
    public String join(@ModelAttribute UserSaveDto userSaveDto){
        userService.savaUser(userSaveDto);
        return "/home";
    }

}
