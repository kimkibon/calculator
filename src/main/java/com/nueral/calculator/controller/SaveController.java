package com.nueral.calculator.controller;

import com.nueral.calculator.dto.goodsDto.GoodsCharacterSaveDtoList;
import com.nueral.calculator.dto.goodsDto.GoodsStatusCharacterSaveDtoList;
import com.nueral.calculator.dto.skillsDto.CharacterSkillsDtoList;
import com.nueral.calculator.service.characterService.CharacterService;
import com.nueral.calculator.dto.AlgorithmDto.AlgorithmSaveDtoList;
import com.nueral.calculator.dto.character.CharacterSaveDto;
import com.nueral.calculator.dto.character.SkinSaveDto;
import com.nueral.calculator.service.algorithm.AlgorithmService;
import com.nueral.calculator.service.friendship.GoodsService;
import com.nueral.calculator.service.skill.SkillSaveService;
import com.nueral.calculator.service.skin.SkinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/insert")
public class SaveController {

    @Autowired
    private CharacterService characterService;
    @Autowired
    private SkinService skinService;
    @Autowired
    private AlgorithmService algorithmService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private SkillSaveService skillSaveService;

    @PostMapping(value = "/saveCharacter")
    public String saveCharacterByDto(@ModelAttribute CharacterSaveDto characterSaveDto, @RequestParam("file") MultipartFile file) throws Exception {
        return characterService.saveByDto(characterSaveDto , file);
    }

    @GetMapping(value = "/saveCharacter")
    public String saveCharacterPro(@RequestParam("name") @Nullable String name , Model model, HttpServletRequest request) {
        if (request.getHeader("REFERER") == null){
            return "home";
        }

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
    public String saveSkinsPro(@RequestParam("name") @NonNull String name, @RequestParam("type")String type, Model model, HttpServletRequest request){
        if (request.getHeader("REFERER") == null) {
            return "home";
        }
        model.addAttribute("skinSaveDto", skinService.findByCharacterAndType(name , type));
        model.addAttribute("skinType" , skinService.skinTypes());
        model.addAttribute("name" , name);
        return "insert/saveSkins";
    }

    @PostMapping(value = "/deleteSkins")
    public String deleteSkins(@RequestParam("name") @NonNull String name, @RequestParam("type")String type, HttpServletRequest request){
        if (request.getHeader("REFERER") == null) {
            return "home";
        }
        return skinService.deleteSkins(name , type);
    }

    @PostMapping(value = "/saveAlgorithm")
    public String saveAlgorithm(@ModelAttribute AlgorithmSaveDtoList algorithmSaveDtoList){
        return algorithmService.saveAlgorithmByDto(algorithmSaveDtoList);
    }

    @GetMapping(value = "/saveAlgorithm")
    public String saveAlgorithmPro(@RequestParam("name") @Nullable String name , Model model , HttpServletRequest request){
        if (request.getHeader("REFERER") == null){
            return "home";
        }

        model.addAttribute("name" , name);
        model.addAttribute("characterAlgorithm", algorithmService.saveAlgorithmPro(name));
        model.addAttribute("setAlgorithmList", algorithmService.setAlgorithmDtoList());
        model.addAttribute("mainAlgorithmList",algorithmService.mainAlgorithmDtoList());
        model.addAttribute("subAlgorithmList",algorithmService.subAlgorithmDtoList());
        return "insert/saveAlgorithm";
    }

    @PostMapping(value = "/saveGoodsCharacter")
    public String saveGoodsCharacter(@ModelAttribute GoodsCharacterSaveDtoList goodsCharacterSaveDtoList , @RequestParam("name") String name){
        return goodsService.saveGoodsCharacter(goodsCharacterSaveDtoList , name);
    }

    @GetMapping(value = "/saveGoodsCharacter")
    public String saveGoodsCharacterPro(@RequestParam("name") String name , Model model , HttpServletRequest request){
        if (request.getHeader("REFERER") == null){
            return "home";
        }

        model.addAttribute("name" , name);
        model.addAttribute("goodsCharacterSaveDtoList", goodsService.saveGoodsCharacterPro(name));
        model.addAttribute("goodsList" , goodsService.allGoodsList());
        return "insert/saveGoodsCharacter";
    }

    @PostMapping(value = "/saveSkills")
    public String saveSkills(@ModelAttribute CharacterSkillsDtoList characterSkillsDtoList){
        return skillSaveService.saveSkillsByDto(characterSkillsDtoList);
    }

    @GetMapping(value = "/saveSkills")
    public String saveSkillsPro(@RequestParam("name")String name , Model model){
        model.addAttribute("name" , name);
        model.addAttribute("characterSkillsDtoList" ,skillSaveService.saveSkillsPro(name));
        model.addAttribute("skillEffects" , skillSaveService.skillEffects());
        return "insert/saveSkills";
    }

    @PostMapping(value = "/saveGoodsStatusCharacter")
    public String saveGoodsStatusCharacter(@ModelAttribute GoodsStatusCharacterSaveDtoList goodsStatusCharacterSaveDtoList){
        return goodsService.saveGoodsStatusCharacter(goodsStatusCharacterSaveDtoList);
    }

    @GetMapping(value = "/saveGoodsStatusCharacter")
    public String saveGoodsStatusCharacterPro(@RequestParam("name") String name , Model model){
        model.addAttribute("name" , name);
        model.addAttribute("goodsStatusCharacterSaveDtoList" , goodsService.saveGoodsStatusCharacterPro(name));
        model.addAttribute("statusList" , goodsService.allGoodsStatusDtoList());
        return "insert/saveGoodsStatusCharacter";
    }
}
