package com.nueral.calculator.controller;

import com.nueral.calculator.dto.AlgorithmDto.AlgorithmSaveDtoList;
import com.nueral.calculator.dto.character.CharacterSaveDto;
import com.nueral.calculator.dto.character.SkinSaveDto;
import com.nueral.calculator.service.algorithm.AlgorithmService;
import com.nueral.calculator.service.characterService.CharacterService;
import com.nueral.calculator.service.skin.SkinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public String saveSkinsPro(@RequestParam("name") @Nullable String name, @RequestParam("type")String type, Model model){
        model.addAttribute("skinSaveDto", skinService.findByCharacterAndType(name , type));
        model.addAttribute("skinType" , skinService.skinTypes());
        model.addAttribute("name" , name);
        return "insert/saveSkins";
    }

    @PostMapping(value = "/saveAlgorithm")
    public String saveAlgorithm(@ModelAttribute AlgorithmSaveDtoList algorithmSaveDtoList){
        return algorithmService.saveAlgorithmByDto(algorithmSaveDtoList);
    }

    @GetMapping(value = "/saveAlgorithm")
    public String saveAlgorithmPro(@RequestParam("name") @Nullable String name , Model model){
        model.addAttribute("name" , name);
        model.addAttribute("characterAlgorithm", algorithmService.saveAlgorithmPro(name));
        model.addAttribute("setAlgorithmList", algorithmService.setAlgorithmDtoList());
        model.addAttribute("mainAlgorithmList",algorithmService.mainAlgorithmDtoList());
        model.addAttribute("subAlgorithmList",algorithmService.subAlgorithmDtoList());
        return "insert/saveAlgorithm";
    }
}
