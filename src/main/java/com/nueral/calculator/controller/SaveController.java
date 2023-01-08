package com.nueral.calculator.controller;

import com.nueral.calculator.dto.character.SkinSaveDto;
import com.nueral.calculator.dto.save.AlgorithmSaveDto;
import com.nueral.calculator.dto.save.CharacterSaveDto;
import com.nueral.calculator.service.algorithm.AlgorithmService;
import com.nueral.calculator.service.characterService.CharacterService;
import com.nueral.calculator.service.skin.SkinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/insert")
public class SaveController {

    @Autowired
    private CharacterService characterService;
    @Autowired
    private SkinService skinService;
    @Autowired
    private AlgorithmService algorithmService;

    @PostMapping(value = "/saveCharacter")
    public String saveCharacterByDto(@ModelAttribute CharacterSaveDto characterSaveDto, @RequestParam("file") MultipartFile file) throws Exception {
        return characterService.saveByDto(characterSaveDto , file);
    }

    @GetMapping(value = "/saveCharacter")
    public String saveCharacterPro(@RequestParam("name") @Nullable String name , Model model) {
        CharacterSaveDto characterSaveDto = new CharacterSaveDto();
        if(name != null){
            characterSaveDto = characterService.beforeSave(name);
        }
        model.addAttribute("CharacterSaveDto", characterSaveDto);
        return "insert/saveCharacter";
    }

    @PostMapping(value = "/saveSkins")
    public String saveSkins(@ModelAttribute SkinSaveDto skinSaveDto) {
        return skinService.saveSkins(skinSaveDto);
    }

    @GetMapping(value = "/saveSkins")
    public String saveSkinsPro(@RequestParam("name") @Nullable String name, Model model){
        SkinSaveDto skinSaveDto = new SkinSaveDto();
        skinSaveDto.setCharacterName(name);
        model.addAttribute("SkinSaveDto", skinSaveDto);
        model.addAttribute("skinType" , skinService.skinTypes());
        return "insert/saveSkins";
    }

    @PostMapping(value = "/saveAlgorithm")
    public String saveAlgorithm(@ModelAttribute List<AlgorithmSaveDto> algorithmSaveDto){
        return algorithmService.saveAlgorithmByDto(algorithmSaveDto);
    }

    @GetMapping(value = "/saveAlgorithm")
    public String saveAlgorithmPro(@RequestParam("name") @Nullable String name , Model model){
        Map<String , Object> map = new HashMap<>();
        if(name != null) {
           map = algorithmService.saveAlgorithmPro();
        }
        model.addAttribute("algorithm",map);
        return "insert/saveAlgorithm";
    }
}
