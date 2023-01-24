package com.nueral.calculator.controller.apicontroller;

import com.nueral.calculator.service.characterService.CharacterService;
import com.nueral.calculator.dto.character.AllCharactersDto;
import com.nueral.calculator.dto.character.CharacterInfoDto;
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

    @GetMapping(value = "/characterName")
    @ResponseBody
    public List<String> findCharacterList(){
        return characterService.findAllCharacterName();
    }
}
