package com.nueral.calculator.service.skin;

import com.nueral.calculator.dto.character.SkinSaveDto;
import com.nueral.calculator.dto.character.SkinSaveDtoList;
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
    private SkinRepository skinRepository;
    @Autowired
    private FileUtil fileUtil;
    @Autowired
    private CharacterRepository characterRepository;

    public String saveSkins(SkinSaveDtoList skinSaveDtoList) {
        try{
            for(SkinSaveDto skinSaveDto:skinSaveDtoList.getSkinSaveDto()) {
                if (!skinSaveDto.getFile().isEmpty()) {
                    String insertFile = fileUtil.saveProfile(skinSaveDto.getCharacterName(), skinSaveDto.getType(), skinSaveDto.getFile());
                    Skins skins = Skins.builder()
                            .stdName(insertFile)
                            .type(skinSaveDto.getType())
                            .characters(characterRepository.findByName(skinSaveDto.getCharacterName()).orElseThrow())
                            .build();
                    skinRepository.save(skins);
                }
            }
            return "/home";
        } catch (Exception e){
            return "/saveError";
        }
    }

    public SkinSaveDtoList findByCharacter(String name){
        List<SkinSaveDto> skinsList = skinRepository.findByCharacters(name).stream().map(SkinSaveDto::new).collect(Collectors.toList());
        if (skinsList.isEmpty()) {
            skinsList.add(new SkinSaveDto(name));
        }
        return new SkinSaveDtoList(skinsList);
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
