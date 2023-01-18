package com.nueral.calculator.dto.skillsDto;

import com.nueral.calculator.entity.skill.AllSkills;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CharacterSkillsDto {
    private String characterName;
    private String skillType;
    private String skillName;
    private String explain;
    private String effect;
    public CharacterSkillsDto(AllSkills allSkills){
        this.characterName = allSkills.getCharacters().getName();
        this.skillType = allSkills.getSkillType().getType();
        this.skillName = allSkills.getSkillName();
        this.explain = allSkills.getSkillExplain().replace("<br>","\r\n" );
        this.effect = allSkills.getEffect().replace("<br>","\r\n");
    }
}
