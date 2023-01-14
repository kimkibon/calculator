package com.nueral.calculator.service.skill;

import com.nueral.calculator.dto.skillsDto.AllSkillsSaveDto;
import com.nueral.calculator.entity.Characters;
import com.nueral.calculator.entity.skill.AllSkills;
import com.nueral.calculator.repository.CharacterRepository;
import com.nueral.calculator.repository.skill.AllSkillsRepository;
import com.nueral.calculator.types.SkillType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillSaveService {
    @Autowired
    private AllSkillsRepository allSkillsRepository;
    @Autowired
    private CharacterRepository characterRepository;

    public void saveAllSkills(
            String characterName, SkillType skillType ,
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

}
