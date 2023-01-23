package com.nueral.calculator.service.needExp;

import com.nueral.calculator.dto.ExpListDto.StarExpDto;
import com.nueral.calculator.dto.ExpListDto.StarExpListDto;
import com.nueral.calculator.entity.needExp.NeedStarExp;
import com.nueral.calculator.repository.needExp.NeedStarExpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
public class NeedStarExpService {

    @Autowired
    private NeedStarExpRepository starExpRepository;

    public StarExpListDto updateStarExpPro(){
        return new StarExpListDto(starExpRepository.findAll().stream().map(StarExpDto::new).collect(Collectors.toList()));
    }

    @Transactional
    public String updateStarExp(StarExpListDto starExpListDto){
        try {
            starExpRepository.deleteAll();
            starExpRepository.flush();
            starExpRepository.saveAll(starExpListDto.getNeedStarExpList().stream().map(NeedStarExp::new).collect(Collectors.toList()));
            return "home";
        } catch (Exception e){
            System.out.println("에러가 발생 했습니다. "+e.getMessage());
            return "saveError";
        }
    }
}
