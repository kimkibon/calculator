package com.nueral.calculator.dto.skillsDto;

import com.nueral.calculator.entity.skill.AllSkills;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CharacterSkillsDto {
    private String CharacterName;
    private String skillType;
    private String skillName;
    private String explain;
    private String effect;
    private List<SkillLevelDto> skillLevelDtoList;

    public CharacterSkillsDto(AllSkills allSkills){
        this.skillType = allSkills.getSkillType().getType();
        this.skillName = allSkills.getSkillName();
        this.effect = allSkills.getEffect();
    }
}
