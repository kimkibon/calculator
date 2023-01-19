package com.nueral.calculator.service.characterService;

import com.nueral.calculator.dto.character.AllCharactersDto;
import com.nueral.calculator.dto.character.CharacterInfoDto;
import com.nueral.calculator.dto.character.CharacterSaveDto;
import com.nueral.calculator.entity.Characters;
import com.nueral.calculator.mapping.CharacterName;
import com.nueral.calculator.repository.CharacterRepository;
import com.nueral.calculator.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService {
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private FileUtil fileUtil;

    public CharacterInfoDto findCharacterInfo(String name){

        return new CharacterInfoDto(characterRepository.findByName(name).orElse(new Characters()));
    }

    public List<String> findAllCharacterName(){
        return characterRepository.findAllBy().stream().map(CharacterName::getName).collect(Collectors.toList());
    }

    public List<AllCharactersDto> findAllCharacterInfo(){

        return characterRepository.findAll(Sort.by(Sort.Direction.DESC, "defaultStar"))
                .stream().sorted(Comparator.comparing(Characters::getRoleType)).map(AllCharactersDto::new)
                .collect(Collectors.toList());
    }

    public CharacterSaveDto beforeSave(String name){
        Characters characters = characterRepository.findByName(name).orElse(new Characters());
        return new CharacterSaveDto(characters);
    }

    public String saveByDto(CharacterSaveDto characterSaveDto , MultipartFile file) throws Exception {
        System.out.println(!file.isEmpty());
        if(!file.isEmpty()) {
            String insertFile = fileUtil.saveProfile(characterSaveDto.getCharacterName(), "profile", file);
            characterSaveDto.setProfile(insertFile);
        }
            Characters characters = new Characters(characterSaveDto);
        try {
            characterRepository.save(characters);
            return "home";
        } catch (Exception e){
            return "saveError";
        }
    }
    public void deleteCharacter(String name){
        characterRepository.deleteById(name);
    }

/**
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
                .profile("/image/character/profile/"+name+".png")
                .build();

        characterRepository.saveAndFlush(characters);
        return characters;
    }
*/
}
