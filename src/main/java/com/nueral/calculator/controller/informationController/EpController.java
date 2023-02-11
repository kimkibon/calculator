package com.nueral.calculator.controller.informationController;

import com.nueral.calculator.service.epService.EpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/information")
public class EpController {
    @Autowired
    private EpService epService;

    @GetMapping(value = "/ExceptionProtocol")
    public String AllEp(Model model){
        model.addAttribute("EpPool" , epService.EpPoolDtoList());
        return "information/ExceptionProtocol";
    }

}
