package com.nueral.calculator.entity.skill;

import com.nueral.calculator.entity.skill.id.SkillEffectsMapId;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
@IdClass(SkillEffectsMapId.class)
public class SkillEffectsMap {
    @Id
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumns({
            @JoinColumn(name = "CHARACTER_NAME", referencedColumnName = "CHARACTER_NAME", nullable = false),
            @JoinColumn(name = "skill_type", referencedColumnName = "skill_type", nullable = false)
    })
    @ToString.Exclude
    private AllSkills allSkills;
    @Id
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "effect_index", nullable = false, referencedColumnName = "effect_index")
    @ToString.Exclude
    private SkillEffects skillEffects;

    @Builder
    public SkillEffectsMap(AllSkills allSkills , SkillEffects skillEffects){
        this.skillEffects = skillEffects;
        this.allSkills = allSkills;
    }

}
