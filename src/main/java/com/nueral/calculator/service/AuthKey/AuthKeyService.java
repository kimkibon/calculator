package com.nueral.calculator.service.AuthKey;

import com.nueral.calculator.entity.authKey.AuthKey;
import com.nueral.calculator.repository.authKey.AuthKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthKeyService {
    @Autowired
    private AuthKeyRepository authKeyRepository;

    public void saveKey(int exp , int gray , int green , int blue,
                        int purple , int orange , int skillCore,
                        int skillExp , int starExp){
        AuthKey authKey = AuthKey.builder()
                .blue(blue)
                .exp(exp)
                .gray(gray)
                .green(green)
                .orange(orange)
                .purple(purple)
                .skillCore(skillCore)
                .skillExp(skillExp)
                .starExp(starExp)
                .build();
    }
}
