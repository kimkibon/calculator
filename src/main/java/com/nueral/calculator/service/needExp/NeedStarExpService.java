package com.nueral.calculator.service.needExp;

import com.nueral.calculator.entity.needExp.NeedStarExp;
import com.nueral.calculator.repository.needExp.NeedStarExpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NeedStarExpService {

    @Autowired
    private NeedStarExpRepository starExpRepository;

    public void saveStarExp(int starLevel , int exp){

        NeedStarExp needStarExp = NeedStarExp.builder()
                .exp(exp)
                .starLevel(starLevel)
                .build();

        starExpRepository.save(needStarExp);

    }
}
