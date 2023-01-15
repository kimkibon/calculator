package com.nueral.calculator.service.skill;

import com.nueral.calculator.dto.skillsDto.CharacterSkillsDto;
import com.nueral.calculator.dto.skillsDto.CharacterSkillsDtoList;
import com.nueral.calculator.entity.skill.AllSkills;
import com.nueral.calculator.repository.CharacterRepository;
import com.nueral.calculator.repository.skill.AllSkillsRepository;
import com.nueral.calculator.types.SkillType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillSaveService {
    @Autowired
    private AllSkillsRepository allSkillsRepository;
    @Autowired
    private CharacterRepository characterRepository;

/**
    public void saveAllSkills(
            String characterName, SkillType ,
            String skillName , String explain , String effect
    ){
        Characters characters = characterRepository.findByName(characterName).orElseThrow();

        AllSkills allSkills = AllSkills.builder()
                .skillType(skillType)
                .characters(characters)
                .effect(effect)
                .explain(explain)
                .skillName(skillName)
                .build();

        allSkillsRepository.save(allSkills);

    }

    public void saveAllSkillsByDto(AllSkillsSaveDto allSkillsSaveDto){
        Characters characters = characterRepository.findByName(allSkillsSaveDto.getCharacterName()).orElseThrow();

        AllSkills allSkills = AllSkills.builder()
                .characters(characters)
                .skillType(SkillType.valueOf(allSkillsSaveDto.getSkillName()))
                .skillName(allSkillsSaveDto.getSkillName())
                .explain(allSkillsSaveDto.getExplain())
                .explain(allSkillsSaveDto.getEffect())
                .build();

        allSkillsRepository.save(allSkills);
    }
*/

    public CharacterSkillsDtoList saveSkillsPro(String name){
        List<AllSkills> characterSkillsList
                = allSkillsRepository.findByCharacterName(name).stream().sorted(Comparator.comparing(AllSkills::getSkillType)).collect(Collectors.toList());
        CharacterSkillsDtoList characterSkillsDtoList;
        if(characterSkillsList.isEmpty()){
            List<CharacterSkillsDto> dto = new ArrayList<>();
            dto.add(new CharacterSkillsDto(name , SkillType.pas.getType(),"", "" ,""));
            dto.add(new CharacterSkillsDto(name , SkillType.act.getType(),"", "",""));
            dto.add(new CharacterSkillsDto(name , SkillType.ult.getType(),"", "",""));
            characterSkillsDtoList = new CharacterSkillsDtoList(dto);
        } else {
            characterSkillsDtoList = new CharacterSkillsDtoList(characterSkillsList.stream().map(CharacterSkillsDto::new).collect(Collectors.toList()));
        }
        return characterSkillsDtoList;
    }

    public String saveSkillsByDto(CharacterSkillsDtoList characterSkillsDtoList){
        try{
            for(CharacterSkillsDto dto : characterSkillsDtoList.getCharacterSkillsDto()){
                SkillType skillType;
                switch (dto.getSkillType()){
                    case "패시브" : skillType = SkillType.pas;
                        break;
                    case "액티브" : skillType = SkillType.act;
                        break;
                    case "궁극기" : skillType = SkillType.ult;
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + dto.getSkillType());
                }

                AllSkills allSkills = AllSkills.builder()
                        .skillType(skillType)
                        .skillName(dto.getSkillName())
                        .explain(dto.getExplain())
                        .effect(dto.getEffect())
                        .characters(characterRepository.getReferenceById(dto.getCharacterName()))
                        .build();
                allSkillsRepository.save(allSkills);
            } return "home";
        } catch (Exception e){
            System.out.println("오류가 발생했습니다 : "+e.getMessage());
            return "saveError";
        }
    }

}
