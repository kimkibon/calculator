package com.nueral.calculator.service;

import com.nueral.calculator.entity.Characters;
import com.nueral.calculator.repository.CharacterRepository;
import com.nueral.calculator.types.AreaType;
import com.nueral.calculator.types.CompanyType;
import com.nueral.calculator.types.DealType;
import com.nueral.calculator.types.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    public Characters save(String name, DealType dealType , RoleType roleType, AreaType areaType , CompanyType companyType , int defaultStar){
        Characters characters = Characters.builder()
                .name(name)
                .dealType(dealType)
                .roleType(roleType)
                .companyType(companyType)
                .areaType(areaType)
                .defaultStar(defaultStar)
                .build();

        characterRepository.save(characters);
        return characters;
    }

    public Characters findByCharacterName(String name){

        return characterRepository.findByName(name).orElseThrow(NullPointerException::new);

    }

}
