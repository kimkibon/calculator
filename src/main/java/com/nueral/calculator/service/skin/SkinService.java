package com.nueral.calculator.service.skin;

import com.nueral.calculator.dto.character.SkinSaveDto;
import com.nueral.calculator.entity.images.Skins;
import com.nueral.calculator.entity.images.id.SkinsId;
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

    public String saveSkins(SkinSaveDto skinSaveDto) {
        try{
            if (!skinSaveDto.getFile().isEmpty()) {
                String insertFile = fileUtil.saveProfile(skinSaveDto.getCharacterName(), skinSaveDto.getType(), skinSaveDto.getFile());
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

    public SkinSaveDto findByCharacterAndType(String name , String type){
        SkinSaveDto skinSaveDto;
        if(type.isEmpty()){
            skinSaveDto = new SkinSaveDto(name);
        } else {
            SkinsId skinsId = new SkinsId(name , type);
           skinSaveDto = new SkinSaveDto(skinRepository.findById(skinsId).orElseThrow());
        }
        return skinSaveDto;
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
