package com.nueral.calculator.dto.skillsDto;

import com.nueral.calculator.entity.skill.SkillEffects;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SkillEffectDto {
    private String effectsName;
    private String effects;

    public SkillEffectDto(SkillEffects skillEffects){
        this.effectsName = skillEffects.getEffectsName();
        this.effects = skillEffects.getEffects();
    }
}
