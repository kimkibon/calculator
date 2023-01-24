package com.nueral.calculator.dto.skillsDto;

import com.nueral.calculator.entity.skill.AllSkills;
import com.nueral.calculator.entity.skill.SkillEffectsMap;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

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

    private List<SkillEffectDto> skillEffectDtoList;
    public CharacterSkillsDto(AllSkills allSkills){
        this.characterName = allSkills.getCharacters().getName();
        this.skillType = allSkills.getSkillType().getType();
        this.skillName = allSkills.getSkillName();
        this.explain = allSkills.getSkillExplain().replace("<br>","\r\n" );
        this.effect = allSkills.getEffect().replace("<br>","\r\n");
        this.skillEffectDtoList =  allSkills.getSkillEffectsMapList().stream().map(SkillEffectsMap::getSkillEffects).map(SkillEffectDto::new).collect(Collectors.toList());

    }
}
