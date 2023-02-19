package com.nueral.calculator.controller.userController;

import com.nueral.calculator.dto.UserSaveDto;
import com.nueral.calculator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Map;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "join")
    public String join(@ModelAttribute UserSaveDto userSaveDto , HttpServletRequest request ){
        if (request.getHeader("REFERER") != null) {
            userService.savaUser(userSaveDto);
        }
        return "home";
    }

    @GetMapping(value = "join")
    public String joinPro(HttpServletRequest request , Principal principal){
        if (request.getHeader("REFERER") == null){
            return "home";
        } else {
            if(principal != null) {
                return "redirect:home";
            }
            return "users/joinForm";
        }
    }

    @GetMapping(value = "/allUsers")
    public String userInfo(Model model){
        model.addAttribute("user" , userService.userInfo());
        return "users/allUsers";
    }

    @PostMapping(value = "/updateUser")
    public String updateUser(@RequestBody Map<String,Object> inputMap){
        UserSaveDto userSaveDto = new UserSaveDto((String)inputMap.get("username") , (String)inputMap.get("password") , (String)inputMap.get("role"), Long.parseLong((String) inputMap.get("id")));
        return userService.updateUser(userSaveDto);
    }

}
