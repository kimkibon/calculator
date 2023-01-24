package com.nueral.calculator.controller.informationController;

import com.nueral.calculator.service.needExp.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;
    @GetMapping(value = "/calculator/skillExp")
    public String skillExpList(Model model){
        model.addAttribute("skillExpList" , calculatorService.skillExpList());
        return "calculator/skillExp";
    }

    @GetMapping(value = "/calculator/exp")
    public String expList(Model model){
        model.addAttribute("expList" , calculatorService.expList());
        return "calculator/exp";
    }

    @GetMapping(value = "/calculator/starExp")
    public String starExp(Model model){
        model.addAttribute("starExpList" , calculatorService.starExpList());
        return "calculator/starExp";
    }

    @GetMapping(value = "/calculator/goodsExp")
    public String goodsExp(Model model){
        model.addAttribute("goodsExpList" , calculatorService.goodsExpList());
        return "calculator/goodsExp";
    }

    @GetMapping(value = "/calculator/allExp")
    public String allExp(Model model){
        model.addAttribute("expList" , calculatorService.expList());
        model.addAttribute("skillExpList" , calculatorService.skillExpList());
        model.addAttribute("starExpList" , calculatorService.starExpList());
        model.addAttribute("goodsExpList" , calculatorService.goodsExpList());
        return "calculator/allExp";
    }
}
