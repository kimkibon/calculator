package com.nueral.calculator.controller;

import com.nueral.calculator.service.characterService.CharacterService;
import com.nueral.calculator.dto.character.CharacterInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/information")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping(value = "/characterList")
    public String findCharacterList(Model model, HttpServletRequest request){
        if (request.getHeader("REFERER") == null){
            return "home";
        }
        model.addAttribute("characterList" , characterService.findAllCharacterInfo());
        return "information/characterList";
    }

    @GetMapping(value = "/character")
    public String findCharacter(@RequestParam("name") String name, Model model, HttpServletRequest request){
        if (request.getHeader("REFERER") == null){
            return "home";
        }
        CharacterInfoDto characterInfoDto =
                characterService.findCharacterInfo(name);
        if(characterInfoDto.getCharacterName() != null) {
            model.addAttribute("character", characterInfoDto);
            return "information/character";
        } else {
            return "home";
        }
    }

}
