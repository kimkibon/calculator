package com.nueral.calculator.entity.skill;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class SkillEffects {
    @Id

    @Column(name = "effects_name" , nullable = false)
    private String effectsName;
    private String effectsExplain;

    @OneToMany(mappedBy = "skillEffects", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<SkillEffectsMap> skillEffectsMapList;

    @Builder
    public SkillEffects(String effectsName , String effectsExplain){
        this.effectsName = effectsName;
        this.effectsExplain = effectsExplain;
    }
}
