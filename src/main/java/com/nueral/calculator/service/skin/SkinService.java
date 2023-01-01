package com.nueral.calculator.service.skin;

import com.nueral.calculator.dto.character.SkinDto;
import com.nueral.calculator.dto.character.SkinSaveDto;
import com.nueral.calculator.entity.images.Skins;
import com.nueral.calculator.repository.CharacterRepository;
import com.nueral.calculator.repository.skin.SkinRepository;
import com.nueral.calculator.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public String saveSkins(List<SkinSaveDto> skinSaveDtoList) {
        try{
            for (SkinSaveDto dto : skinSaveDtoList) {
                if(!dto.getFile().isEmpty() || dto.getType() != null || dto.getCharacterName() != null) {
                    Skins skins = Skins.builder()
                            .stdName(fileUtil.saveProfile(dto.getCharacterName(), dto.getType(), dto.getFile()))
                            .type(dto.getType())
                            .characters(characterRepository.findByName(dto.getCharacterName()).orElseThrow())
                            .build();
                    skinRepository.save(skins);
                }
            }
            return "/home";
        } catch (Exception e){
            return "/saveError";
        }
    }

    public List<SkinDto> findByCharacter(String name){
        return skinRepository.findByCharacters(name).stream().map(SkinDto::new).collect(Collectors.toList());
    }

    public List<String> skinTypes(){
        return skinRepository.findType().stream().map(String::new).collect(Collectors.toList());
    }

}
