package com.nueral.calculator.service.characterService;

import com.nueral.calculator.dto.character.AllCharactersDto;
import com.nueral.calculator.dto.character.CharacterInfoDto;
import com.nueral.calculator.dto.save.CharacterSaveDto;
import com.nueral.calculator.entity.Characters;
import com.nueral.calculator.repository.CharacterRepository;
import com.nueral.calculator.types.AreaType;
import com.nueral.calculator.types.CompanyType;
import com.nueral.calculator.types.DealType;
import com.nueral.calculator.types.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService {
    @Autowired
    private CharacterRepository characterRepository;

    public CharacterInfoDto findCharacterInfo(String name){

        Characters characters = characterRepository.findByName(name).orElse(new Characters());

        return new CharacterInfoDto(characters);
    }

    public List<AllCharactersDto> findAllCharacterInfo(){
        List<Characters> charactersList = characterRepository.findAll(Sort.by(Sort.Direction.DESC, "defaultStar"));

        return charactersList.stream().map(AllCharactersDto::new).collect(Collectors.toList());
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

    public void saveByDto(CharacterSaveDto characterSaveDto){
        Characters characters = new Characters(characterSaveDto);
        characterRepository.save(characters);
    }
}
