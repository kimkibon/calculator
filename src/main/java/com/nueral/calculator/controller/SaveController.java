package com.nueral.calculator.controller;

import com.nueral.calculator.dto.character.SkinSaveDto;
import com.nueral.calculator.dto.save.CharacterSaveDto;
import com.nueral.calculator.service.characterService.CharacterService;
import com.nueral.calculator.service.skin.SkinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/insert")
public class SaveController {

    @Autowired
    private CharacterService characterService;
    @Autowired
    private SkinService skinService;

    @PostMapping("character")
    public String saveCharacter(@ModelAttribute CharacterSaveDto characterSaveDto, @RequestParam("file")MultipartFile file) throws Exception {
        System.out.println(characterSaveDto.toString());
        characterService.saveByDto(characterSaveDto , file);
        return "/home";
    }

    @GetMapping("saveCharacter")
    public String saveCharacterPro(Model model) throws Exception {
        model.addAttribute("CharacterSaveDto", new CharacterSaveDto());
        return "/insert/saveCharacter";
    }

    @PostMapping("skins")
    public String saveSkins(@ModelAttribute List<SkinSaveDto> skinDtoList) throws Exception {
        skinService.saveSkins(skinDtoList);
        return "/home";
    }
}
