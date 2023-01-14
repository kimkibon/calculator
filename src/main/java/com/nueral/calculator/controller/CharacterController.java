package com.nueral.calculator.controller;

import com.nueral.calculator.service.characterService.CharacterService;
import com.nueral.calculator.dto.character.CharacterInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/information")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping(value = "/characterList")
    public String findCharacterList(Model model){
        model.addAttribute("characterList" , characterService.findAllCharacterInfo());
        return "information/characterList";
    }

    @GetMapping(value = "/character")
    public String findCharacter(@RequestParam("name") String name, Model model){
        CharacterInfoDto characterInfoDto =
                characterService.findCharacterInfo(name);
        if(characterInfoDto.getCharacterName() != null) {
            model.addAttribute("character", characterInfoDto);
            return "information/character";
        } else {
            return "home";
        }
    }

    @GetMapping(value = "/characterTest")
    public String findCharacterTest(@RequestParam("name") String name, Model model){
        CharacterInfoDto characterInfoDto =
                characterService.findCharacterInfo(name);
        model.addAttribute("character" , characterInfoDto);

        return "test/characterTest";
    }

}
