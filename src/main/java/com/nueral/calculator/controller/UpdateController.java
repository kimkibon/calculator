package com.nueral.calculator.controller;

import com.nueral.calculator.dto.skillsDto.SkillEffectDto;
import com.nueral.calculator.service.skill.SkillSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/update")
public class UpdateController {
    @Autowired
    SkillSaveService skillSaveService;

    @GetMapping(value = "/updateHome")
    public String updateHome(){
        return "update/updateHome";
    }

    @GetMapping(value = "/updateSkillEffects")
    public String updateSkillEffectsPro(Model model){
        model.addAttribute("skillEffects" , skillSaveService.skillEffects());
        model.addAttribute("SkillEffectDto" , new SkillEffectDto());
        return "update/updateSkillEffects";
    }

    @PostMapping(value = "/updateSkillEffects")
    public String updateSkillEffects(@ModelAttribute SkillEffectDto skillEffectDto){
        return skillSaveService.updateSkillEffects(skillEffectDto);
    }

    @PostMapping(value = "/deleteSkillEffect")
    public String deleteSkillEffects(@RequestParam("index") int index){
        return skillSaveService.deleteSkillEffect(index);
    }
}
