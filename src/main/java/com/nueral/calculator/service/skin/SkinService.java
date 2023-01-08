package com.nueral.calculator.service.skin;

import com.nueral.calculator.dto.character.SkinDto;
import com.nueral.calculator.dto.character.SkinSaveDto;
import com.nueral.calculator.entity.images.Skins;
import com.nueral.calculator.repository.CharacterRepository;
import com.nueral.calculator.repository.skin.SkinRepository;
import com.nueral.calculator.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkinService {
    @Autowired
    SkinRepository skinRepository;
    @Autowired
    private FileUtil fileUtil;
    @Autowired
    private CharacterRepository characterRepository;

    public String saveSkins(SkinSaveDto skinSaveDto) {
        try{
                if(!skinSaveDto.getFile().isEmpty()) {
                    String insertFile = fileUtil.saveProfile(skinSaveDto.getCharacterName() , skinSaveDto.getType(), skinSaveDto.getFile());
                    Skins skins = Skins.builder()
                            .stdName(insertFile)
                            .type(skinSaveDto.getType())
                            .characters(characterRepository.findByName(skinSaveDto.getCharacterName()).orElseThrow())
                            .build();
                    skinRepository.save(skins);
                }
            return "/home";
        } catch (Exception e){
            return "/saveError";
        }
    }

    public List<SkinDto> findByCharacter(String name){

        List<Skins> skinsList = skinRepository.findByCharacters(name).stream().collect(Collectors.toList());
        if(skinsList.isEmpty()){
            return Collections.emptyList();
        } else {
            return skinsList.stream().map(SkinDto::new).collect(Collectors.toList());
        }
    }

    public List<String> skinTypes(){
        List<String> skinType = skinRepository.findType().stream().map(String::new).collect(Collectors.toList());
        if(skinType.isEmpty()){
            skinType.add("기본 투영");
            skinType.add("확장 투영");
            skinType.add("완전 투영");
        }
        return skinType;
    }
}
