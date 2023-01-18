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
            @JoinColumn(name = "skill_name", referencedColumnName = "skill_name", nullable = false)
    })
    @ToString.Exclude
    private AllSkills allSkills;
    @Id
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "effects_name", nullable = false, referencedColumnName = "effects_name")
    @ToString.Exclude
    private SkillEffects skillEffects;

    public void setSkillEffects(SkillEffects skillEffects) {
        this.skillEffects = skillEffects;
    }

    public void setAllSkills(AllSkills allSkills) {
        this.allSkills = allSkills;
    }

    @Builder
    public SkillEffectsMap(AllSkills allSkills , SkillEffects skillEffects){
        this.skillEffects = skillEffects;
        this.allSkills = allSkills;
    }

}
