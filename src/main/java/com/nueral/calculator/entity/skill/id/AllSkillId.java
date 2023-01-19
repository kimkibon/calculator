package com.nueral.calculator.entity.skill.id;

import com.nueral.calculator.types.SkillType;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class AllSkillId implements Serializable {
    private String characters;
    @Enumerated(EnumType.STRING)
    private SkillType skillType;
}
