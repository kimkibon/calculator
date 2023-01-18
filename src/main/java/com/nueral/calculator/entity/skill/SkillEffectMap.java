package com.nueral.calculator.entity.skill;

import com.nueral.calculator.entity.skill.id.SkillEffectMapId;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
@IdClass(SkillEffectMapId.class)
public class SkillEffectMap {
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "skill_name", nullable = false , referencedColumnName ="skill_name")
    @ToString.Exclude
    @Id
    private AllSkills allSkills;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "effects_name", nullable = false , referencedColumnName ="effects_name")
    @ToString.Exclude
    @Id
    private SkillEffects skillEffects;

    @Builder
    public SkillEffectMap(AllSkills allSkills , SkillEffects skillEffects){
        this.allSkills = allSkills;
        this.skillEffects = skillEffects;
    }
}
