package com.nueral.calculator.controller.apicontroller;

import com.nueral.calculator.dto.character.AllCharactersDto;
import com.nueral.calculator.dto.character.CharacterInfoDto;
import com.nueral.calculator.dto.character.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api")
public class ApiCharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping(value = "characterList")
    @ResponseBody
    public List<AllCharactersDto> findCharacterList(){
        return characterService.findAllCharacterInfo();
    }

    @GetMapping(value = "character")
    @ResponseBody
    public String findCharacter(Model model , String name){
        CharacterInfoDto characterInfoDto =
                characterService.findCharacterInfo(name);
        model.addAttribute("character" , characterInfoDto);

        return "/information/character";
    }

}
