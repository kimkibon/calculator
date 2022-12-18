package com.nueral.calculator.entity.skill;

import com.nueral.calculator.entity.DefaultEntity;
import com.nueral.calculator.entity.skill.id.SkillLevelId;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
@IdClass(SkillLevelId.class)
public class SkillLevels extends DefaultEntity {

    @Id
    private int skillLevel;
    @Id
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumns({
            @JoinColumn(name = "CHARACTER_NAME", referencedColumnName = "CHARACTER_NAME"),
            @JoinColumn(name = "skill_name", referencedColumnName = "skill_name")
    })
    private AllSkills allSkills;
    private double status;
    private double status2;
    private double status3;
    private double status4;

    @Builder
    public SkillLevels(
            int skillLevel , AllSkills allSkills ,
            double status ,double status2 , double status3,double status4 ){
        this.allSkills = allSkills;
        this.skillLevel = skillLevel;
        this.status = status;
        this.status2 = status2;
        this.status3 = status3;
        this.status4 = status4;
    }

}
