package com.nueral.calculator.controller;

import com.nueral.calculator.service.skill.SkillSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/update")
public class UpdateController {
    @Autowired
    SkillSaveService skillSaveService;

    @GetMapping(value = "/updateSkillEffects")
    public String updateSkillEffectsPro(Model model){
        model.addAttribute("skillEffects" , skillSaveService.skillEffects());
        return "update/updateSkillEffects";
    }
}
