package com.nueral.calculator.service;

import com.nueral.calculator.dto.CharacterInfoDto;
import com.nueral.calculator.entity.Characters;
import com.nueral.calculator.repository.CharacterRepository;
import com.nueral.calculator.types.AreaType;
import com.nueral.calculator.types.CompanyType;
import com.nueral.calculator.types.DealType;
import com.nueral.calculator.types.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterService {
    @Autowired
    private CharacterRepository characterRepository;


    public CharacterInfoDto findCharacterInfo(String name){
        Characters characters = characterRepository.findByName(name).orElseThrow(NullPointerException::new);

        return new CharacterInfoDto(characters);
    }

    public List<CharacterInfoDto> findAllCharacterInfo(){
        List<Characters> charactersList = characterRepository.findAll();
        List<CharacterInfoDto> characterInfoDtoList = new ArrayList<>();

        for(int i = 0; i < charactersList.size(); i++){
          characterInfoDtoList.add(new CharacterInfoDto(charactersList.get(i)));
        }

        return characterInfoDtoList;
    }

    public Characters save(
            String name, DealType dealType , RoleType roleType,
            AreaType areaType ,CompanyType companyType , int defaultStar){

        Characters characters = Characters.builder()
                .name(name)
                .dealType(dealType)
                .roleType(roleType)
                .companyType(companyType)
                .areaType(areaType)
                .defaultStar(defaultStar)
                .build();

        characterRepository.saveAndFlush(characters);
        return characters;
    }
}
