package com.nueral.calculator.service.skill;

import com.nueral.calculator.entity.Characters;
import com.nueral.calculator.entity.skill.AllSkills;
import com.nueral.calculator.entity.skill.SkillLevels;
import com.nueral.calculator.entity.skill.id.AllSkillId;
import com.nueral.calculator.repository.CharacterRepository;
import com.nueral.calculator.repository.skill.AllSkillsRepository;
import com.nueral.calculator.repository.skill.SkillLevelRepository;
import com.nueral.calculator.types.SkillType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillSaveService {
    @Autowired
    private AllSkillsRepository allSkillsRepository;
    @Autowired
    private SkillLevelRepository skillLevelRepository;
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

    public void saveSkillLevels(
            int skillLevel , String characterName , String skillName ,
            double status1 ,double status2 , double status3,double status4
    ){
        AllSkillId allSkillId = new AllSkillId(characterName , skillName);

        AllSkills allSkills = allSkillsRepository.findById(allSkillId).get();

        SkillLevels skillLevels = SkillLevels.builder()
                .allSkills(allSkills)
                .skillLevel(skillLevel)
                .status(status1)
                .status2(status2)
                .status3(status3)
                .status4(status4)
                .build();

        skillLevelRepository.save(skillLevels);
    }

}
