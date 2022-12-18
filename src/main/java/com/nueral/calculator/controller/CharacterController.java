package com.nueral.calculator.controller;

import com.nueral.calculator.dto.CharacterInfoDto;
import com.nueral.calculator.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/information")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping(value = "/characterList")
    public String findCharacterList(Model model){
        List<CharacterInfoDto> characterList = characterService.findAllCharacterInfo();
        model.addAttribute("characterList" , characterList);
        return "/information/characterList";
    }

    @GetMapping(value = "character")
    public String findCharacter(Model model , String name){
        CharacterInfoDto characterInfoDto =
                characterService.findCharacterInfo(name);
        model.addAttribute("character" , characterInfoDto);

        return "/information/character";
    }

}
