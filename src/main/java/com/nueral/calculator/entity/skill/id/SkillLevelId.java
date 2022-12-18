package com.nueral.calculator.entity.skill.id;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class SkillLevelId implements Serializable {
    private AllSkillId allSkills;
    private int skillLevel;

}
