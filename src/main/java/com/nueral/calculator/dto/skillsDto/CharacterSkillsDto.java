package com.nueral.calculator.dto.skillsDto;

import com.nueral.calculator.entity.skill.AllSkills;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CharacterSkillsDto {
    private String skillType;
    private String skillName;
    private String explain;
    private String effect;
    private List<SkillLevelDto> skillLevelDtoList;

    public CharacterSkillsDto(AllSkills allSkills){
        this.skillType = allSkills.getSkillType().getType();
        this.skillName = allSkills.getSkillName();
        this.explain = allSkills.getExplain();
        this.effect = allSkills.getEffect();
        this.skillLevelDtoList = allSkills.getSkillLevelsList().stream().map(SkillLevelDto::new).collect(Collectors.toList());
    }
}
