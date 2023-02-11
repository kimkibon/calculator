package com.nueral.calculator.controller.apicontroller;

import com.nueral.calculator.service.skill.SkillSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UpdateApiController {
    @Autowired
    SkillSaveService skillSaveService;

    @PostMapping(value = "/api/deleteSkillEffects")
    public String deleteSkillEffects(int effectIndex){
        return skillSaveService.deleteSkillEffect(effectIndex);
    }
}
