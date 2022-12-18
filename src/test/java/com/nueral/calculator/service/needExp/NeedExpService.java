package com.nueral.calculator.service.needExp;

import com.nueral.calculator.entity.needExp.NeedExp;
import com.nueral.calculator.repository.needExp.NeedExpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@SpringBootTest
public class NeedExpService {
    @Autowired
    private NeedExpRepository needExpRepository;
    public void saveExp(int exp,int characterLevel , int gray , int green , int blue , int purple , int orange , int rainbow){

        NeedExp needExp = NeedExp.builder()
                .exp(exp)
                .characterLevel(characterLevel)
                .gray(gray)
                .green(green)
                .blue(blue)
                .orange(orange)
                .purple(purple)
                .orange(orange)
                .rainbow(rainbow)
                .build();

        needExpRepository.save(needExp);
    }

}
