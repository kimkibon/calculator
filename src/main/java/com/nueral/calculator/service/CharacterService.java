package com.nueral.calculator.service;

import com.nueral.calculator.dto.AllCharactersDto;
import com.nueral.calculator.dto.CharacterInfoDto;
import com.nueral.calculator.entity.Characters;
import com.nueral.calculator.repository.CharacterRepository;
import com.nueral.calculator.repository.algorithm.AlgorithmRepository;
import com.nueral.calculator.repository.friendship.GoodsCharacterRepository;
import com.nueral.calculator.repository.friendship.GoodsStatusCharacterRepository;
import com.nueral.calculator.repository.skill.AllSkillsRepository;
import com.nueral.calculator.types.AreaType;
import com.nueral.calculator.types.CompanyType;
import com.nueral.calculator.types.DealType;
import com.nueral.calculator.types.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CharacterService {
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private AllSkillsRepository allSkillsRepository;
    @Autowired
    private GoodsCharacterRepository goodsCharacterRepository;
    @Autowired
    private AlgorithmRepository algorithmRepository;
    @Autowired
    private GoodsStatusCharacterRepository goodsStatusCharacterRepository;


    public CharacterInfoDto findCharacterInfo(String name){

        Characters characters = characterRepository.findByName(name).orElse(new Characters());

        CharacterInfoDto characterInfoDto = new CharacterInfoDto(characters);

        return characterInfoDto;
    }

    public List<AllCharactersDto> findAllCharacterInfo(){
        List<Characters> charactersList = characterRepository.findAll();
        List<AllCharactersDto> characterInfoDtoList =
        charactersList.stream().map(AllCharactersDto::new).collect(Collectors.toList());

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
