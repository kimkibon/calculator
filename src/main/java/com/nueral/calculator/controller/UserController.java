package com.nueral.calculator.controller;

import com.nueral.calculator.dto.UserSaveDto;
import com.nueral.calculator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "join")
    public String join(@ModelAttribute UserSaveDto userSaveDto , HttpServletRequest request ){
        userService.savaUser(userSaveDto);
        return "home";
    }

    @GetMapping(value = "join")
    public String joinPro(HttpServletRequest request){

        if (request.getHeader("REFERER") == null){
            return "home";
        } else {
            return "users/joinForm";
        }
    }

}
