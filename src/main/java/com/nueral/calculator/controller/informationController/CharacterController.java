package com.nueral.calculator.controller.informationController;

import com.nueral.calculator.service.characterService.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/information")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping(value = "/characterList")
    public String findCharacterList(Model model, HttpServletRequest request){
        if (request.getHeader("REFERER") == null){
            return "home";
        }
        try {
            model.addAttribute("characterList" , characterService.findAllCharacterInfo());
            return "information/characterList";
        } catch (Exception e){
            System.out.println("오류가 발생 했습니다. : " + e.getMessage());
            return request.getHeader("REFERER");
        }
    }

    @GetMapping(value = "/character")
    public String findCharacter(@RequestParam("name") String name, Model model){
        try {
            model.addAttribute("character", characterService.findCharacterInfo(name));
            return "information/character";
        } catch (Exception e){
            System.out.println("오류가 발생 했습니다 : " + e.getMessage());
            return "redirect:/home";
        }
    }
    @GetMapping(value = "/reCharacter/{name}")
    public String reCharacter(@PathVariable("name")String name , RedirectAttributes redirectAttributes){
        redirectAttributes.addAttribute("name" , name);
        return "redirect:/information/character";
    }

}
