package com.nueral.calculator.entity.skill.id;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class AllSkillId implements Serializable {
    private String characters;
    private String skillName;
}
