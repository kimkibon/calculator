package com.nueral.calculator.entity.skill.id;

import lombok.*;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class SkillEffectMapId implements Serializable {
    private String allSkills;
    private String skillEffects;
}
