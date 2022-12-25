package com.nueral.calculator.controller;

import com.nueral.calculator.dto.AllCharactersDto;
import com.nueral.calculator.dto.UserSaveDto;
import com.nueral.calculator.entity.Characters;
import com.nueral.calculator.service.CharacterService;
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
    private SkillSaveService skillService;
    @Autowired
    private UserService userService;
    @Autowired
    private NeedExpService expService;


    @GetMapping(value = "/test/insert")
    @ResponseBody
    public Characters find(){
        Characters characters = characterService.save("수춘", DealType.ap, RoleType.depender, AreaType.target, CompanyType.lab,1);
        System.out.println("insert character---------------------------------------------------------------------------------------------");
        skillService.saveAllSkills("수춘", SkillType.pas,"치유의 녹색","","");
        System.out.println("insert skill-------------------------------------------------------------------------------------------------");
        skillService.saveSkillLevels(1,"수춘","치유의 녹색",1,1,1,1	);
        System.out.println("insert skillLevel---------------------------------------------------------------------------------------------");
        System.out.println(characters.toString());

        return characters;
    }

    @GetMapping(value = "/test/allCharacters")
    @ResponseBody
    public List<AllCharactersDto> findCharacterList(){
        return characterService.findAllCharacterInfo();
    }

    @GetMapping(value = "/create")
    public String createUser(){
        UserSaveDto user = new UserSaveDto();
        user.setUsername("bluecomet");
        user.setRole(Role.ADMIN);
        user.setPassword("dmadkr48");
        userService.savaUser(user);
        return "/home";
    }

}
