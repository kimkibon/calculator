package com.nueral.calculator.controller;

import com.nueral.calculator.dto.EpDto.EpPartyDto;
import com.nueral.calculator.dto.EpDto.EpPoolDto;
import com.nueral.calculator.dto.character.RecommendPartyDtoList;
import com.nueral.calculator.dto.goodsDto.GoodsCharacterSaveDtoList;
import com.nueral.calculator.dto.goodsDto.GoodsStatusCharacterSaveDtoList;
import com.nueral.calculator.dto.skillsDto.CharacterSkillsDtoList;
import com.nueral.calculator.service.characterService.CharacterService;
import com.nueral.calculator.dto.AlgorithmDto.AlgorithmSaveDtoList;
import com.nueral.calculator.dto.character.CharacterSaveDto;
import com.nueral.calculator.dto.character.SkinSaveDto;
import com.nueral.calculator.service.algorithm.AlgorithmService;
import com.nueral.calculator.service.epService.EpService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    @Autowired
    private EpService epService;
    @PostMapping(value = "/saveCharacter")
    public String saveCharacterByDto(@ModelAttribute CharacterSaveDto characterSaveDto, @RequestParam("file") MultipartFile file , RedirectAttributes re) {
        try {
            characterService.saveByDto(characterSaveDto , file);
        } catch (Exception e){
            System.out.println("에러가 발생했습니다. : "+e.getMessage());
        }
        re.addAttribute("name",characterSaveDto.getCharacterName());
        return "redirect:/information/character";
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
    public String saveSkins(@ModelAttribute SkinSaveDto skinSaveDto , RedirectAttributes re) {
        try {
            skinService.saveSkins(skinSaveDto);
        } catch (Exception e){
            System.out.println("에러가 발생했습니다. : "+e.getMessage());
        }
        re.addAttribute("name",skinSaveDto.getCharacterName());
         return "redirect:/information/character";
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
    public String deleteSkins(@RequestParam("name") @NonNull String name, @RequestParam("type")String type, HttpServletRequest request , RedirectAttributes re){
        if (request.getHeader("REFERER") == null) {
            return "home";
        }
        try {
            skinService.deleteSkins(name , type);
        } catch (Exception e){
            System.out.println("에러가 발생했습니다. : "+e.getMessage());
        }
        re.addAttribute("name" , name);
        return "redirect:/information/character";
    }

    @PostMapping(value = "/saveAlgorithm")
    public String saveAlgorithm(@ModelAttribute AlgorithmSaveDtoList algorithmSaveDtoList , RedirectAttributes re){
        try {
            algorithmService.saveAlgorithmByDto(algorithmSaveDtoList);
        } catch (Exception e){
            System.out.println("에러가 발생했습니다. : "+e.getMessage());
        }
        re.addAttribute("name",algorithmSaveDtoList.getAlgorithmSaveDto().get(0).getCharacterName());
        return "redirect:/information/character";
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
    public String saveGoodsCharacter(@ModelAttribute GoodsCharacterSaveDtoList goodsCharacterSaveDtoList , @RequestParam("name") String name , RedirectAttributes re){
        try {
            goodsService.saveGoodsCharacter(goodsCharacterSaveDtoList , name);
        } catch (Exception e){
            System.out.println("에러가 발생했습니다. : "+e.getMessage());
        }
        re.addAttribute("name",name);
        return "redirect:/information/character";
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
    public String saveSkills(@ModelAttribute CharacterSkillsDtoList characterSkillsDtoList , RedirectAttributes re){
        try {
            skillSaveService.saveSkillsByDto(characterSkillsDtoList);
        } catch (Exception e){
            System.out.println("에러가 발생했습니다. : "+e.getMessage());
        }
        re.addAttribute("name",characterSkillsDtoList.getCharacterSkillsDto().get(0).getCharacterName());
        return "redirect:/information/character";
    }

    @GetMapping(value = "/saveSkills")
    public String saveSkillsPro(@RequestParam("name")String name , Model model){
        model.addAttribute("name" , name);
        model.addAttribute("characterSkillsDtoList" ,skillSaveService.saveSkillsPro(name));
        model.addAttribute("skillEffects" , skillSaveService.skillEffects());
        return "insert/saveSkills";
    }

    @PostMapping(value = "/saveGoodsStatusCharacter")
    public String saveGoodsStatusCharacter(@ModelAttribute GoodsStatusCharacterSaveDtoList goodsStatusCharacterSaveDtoList , RedirectAttributes re){
        try {
            goodsService.saveGoodsStatusCharacter(goodsStatusCharacterSaveDtoList);
            re.addAttribute("name",goodsStatusCharacterSaveDtoList.getGoodsStatusCharacterDto().get(0).getCharacterName());
        } catch (Exception e){
            System.out.println("에러가 발생했습니다. : "+e.getMessage());
            return "home";
        }
        return "redirect:/information/character";
    }

    @GetMapping(value = "/saveGoodsStatusCharacter")
    public String saveGoodsStatusCharacterPro(@RequestParam("name") String name , Model model){
        model.addAttribute("name" , name);
        model.addAttribute("goodsStatusCharacterSaveDtoList" , goodsService.saveGoodsStatusCharacterPro(name));
        model.addAttribute("statusList" , goodsService.allGoodsStatusDtoList());
        return "insert/saveGoodsStatusCharacter";
    }

    @GetMapping(value = "/saveRecommendParty")
    public String saveRecommendPartyPro(@RequestParam("name") String name , Model model){
        model.addAttribute("name", name);
        model.addAttribute("recommendParty" ,characterService.saveRecommendPartyPro(name));
        model.addAttribute("allCharacters", characterService.findAllCharacterInfo());
        return "insert/saveRecommendParty";
    }

    @PostMapping(value = "/saveRecommendParty")
    public String saveRecommendParty(@ModelAttribute RecommendPartyDtoList recommendPartyDtoList , @RequestParam("name") String name, RedirectAttributes re){
        try {
            characterService.saveRecommendParty(name , recommendPartyDtoList);
        } catch (Exception e){
            System.out.println("에러가 발생했습니다. : "+e.getMessage());
        }
        re.addAttribute("name",name);
        return "redirect:/information/character";
    }

    @GetMapping(value = "/saveEpPool")
    public String saveEpPoolPro(@RequestParam("epIndex")int index, Model model){
        model.addAttribute("epPoolDto",epService.saveEpPoolPro(index));
        model.addAttribute("allCharacters", characterService.findAllCharacterInfo());
        return "insert/saveEpPool";
    }

    @PostMapping(value = "/saveEpPool")
    public String saveEpPool(@ModelAttribute EpPoolDto epPoolDto , RedirectAttributes re){
        return epService.saveEpPool(epPoolDto);
    }

    @GetMapping(value = "/saveEpParty")
    public String saveEpPartyPro(@RequestParam("epPoolIndex")int poolIndex , @RequestParam("epPartyIndex")int partyIndex , Model model){
        model.addAttribute("epPoolIndex" , poolIndex);
        model.addAttribute("epPartyDto" , epService.saveEpPartyPro(poolIndex , partyIndex));
        model.addAttribute("allCharacters", epService.epPoolCharacter(poolIndex));
        return "insert/saveEpParty";
    }
    @PostMapping(value = "/saveEpParty")
    public String saveEpParty(@ModelAttribute EpPartyDto epPartyDto){
        return epService.saveEpParty(epPartyDto);
    }
}
