package com.nueral.calculator.service.skill;

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
        Characters characters = characterRepository.findByName(characterName).get();

        AllSkills allSkills = AllSkills.builder()
                .skillType(skillType)
                .characters(characters)
                .effect(effect)
                .explain(explain)
                .skillName(skillName)
                .build();

        allSkillsRepository.save(allSkills);

    }

}
