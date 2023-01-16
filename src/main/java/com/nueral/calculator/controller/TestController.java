/**
package com.neural.calculator.controller;

import com.neural.calculator.dto.character.AllCharactersDto;
import com.neural.calculator.dto.UserSaveDto;
import com.neural.calculator.service.characterService.CharacterService;
import com.neural.calculator.service.UserService;
import com.neural.calculator.service.needExp.NeedExpService;
import com.neural.calculator.service.skill.SkillSaveService;
import com.neural.calculator.types.*;
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
    private SkillSaveService skillService;
    @Autowired
    private UserService userService;
    @Autowired
    private NeedExpService expService;


    @GetMapping(value = "/test/allCharacters")
    @ResponseBody
    public List<AllCharactersDto> findCharacterList(){
        return characterService.findAllCharacterInfo();
    }

//    @GetMapping(value = "/create")
//    public String createUser(){
//        UserSaveDto user = new UserSaveDto();
//        user.setUsername("bluecomet");
//        user.setRole(Role.ADMIN);
//        user.setPassword("dmadkr48");
//        userService.savaUser(user);
//        return "home";
//    }

}
*/
