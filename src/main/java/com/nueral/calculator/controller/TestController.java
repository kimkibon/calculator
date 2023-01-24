
package com.nueral.calculator.controller;

import com.nueral.calculator.dto.character.AllCharactersDto;
import com.nueral.calculator.dto.UserSaveDto;
import com.nueral.calculator.service.characterService.CharacterService;
import com.nueral.calculator.service.UserService;
import com.nueral.calculator.service.needExp.NeedExpService;
import com.nueral.calculator.service.skill.SkillSaveService;
import com.nueral.calculator.types.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    private CharacterService characterService;
    @Autowired
    private UserService userService;


    @GetMapping(value = "/test/allCharacters")
    @ResponseBody
    public List<AllCharactersDto> findCharacterList(){
        return characterService.findAllCharacterInfo();
    }

    @GetMapping(value = "/create")
    public String createUser(){
        UserSaveDto user = new UserSaveDto();
        user.setUsername("bluecomet");
        user.setRole(Role.ADMIN.getAuthority());
        user.setPassword("dmadkr48");
        userService.savaUser(user);
        return "home";
    }

}
