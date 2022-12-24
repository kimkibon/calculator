package com.nueral.calculator.service;

import com.nueral.calculator.dto.AllCharactersDto;
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

        Characters characters = characterRepository.findByName(name).orElse(new Characters());
        if(characters.getName() == null){
            return new CharacterInfoDto();
        } else {
            return new CharacterInfoDto(characters);
        }
    }

    public List<AllCharactersDto> findAllCharacterInfo(){
        List<Characters> charactersList = characterRepository.findAll();
        List<AllCharactersDto> characterInfoDtoList = new ArrayList<>();

        for (Characters characters : charactersList) {
            AllCharactersDto allCharactersDto = new AllCharactersDto();
            allCharactersDto.setCharacterName(characters.getName());
            allCharactersDto.setDealType(characters.getDealType().getType());
            allCharactersDto.setRoleType(characters.getRoleType().getType());
            allCharactersDto.setDefaultStar(characters.getDefaultStar());
            characterInfoDtoList.add(allCharactersDto);
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
