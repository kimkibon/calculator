package com.nueral.calculator.entity.skill;

import com.nueral.calculator.dto.skillsDto.SkillEffectDto;
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
    @Column(nullable = false)
    private String effectsExplain;

    @OneToMany(mappedBy = "skillEffects", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<SkillEffectsMap> skillEffectsMapList;

    @Builder
    public SkillEffects(String effectsName , String effectsExplain){
        this.effectsName = effectsName;
        this.effectsExplain = effectsExplain;
    }

    public SkillEffects(SkillEffectDto skillEffectDto){
        this.effectsName = skillEffectDto.getEffectsName();
        this.effectsExplain = skillEffectDto.getEffects().replace("\r\n" , "<br>");
    }
}
