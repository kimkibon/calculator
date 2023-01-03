package com.nueral.calculator.controller.adminController;

import com.nueral.calculator.service.characterService.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    CharacterService characterService;
    @GetMapping(value = "/characer")
    public String deleteCharacter(@RequestAttribute String name){
        characterService.deleteCharacter(name);
        return "/home";
    }
}
