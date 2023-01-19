package com.nueral.calculator.entity.skill;

import com.nueral.calculator.entity.Characters;
import com.nueral.calculator.entity.DefaultEntity;
import com.nueral.calculator.entity.skill.id.AllSkillId;
import com.nueral.calculator.types.SkillType;
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
@IdClass(AllSkillId.class)
public class AllSkills extends DefaultEntity {
    @Id
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CHARACTER_NAME", nullable = false , referencedColumnName ="CHARACTER_NAME")
    @ToString.Exclude
    private Characters characters;

    @Id
    @Enumerated(EnumType.STRING)
    @Column(name= "skill_type" , nullable = false)
    private SkillType skillType;

    @Column(name = "skill_name" , nullable = false)
    private String skillName;
    private String skillExplain;
    private String effect;

    @OneToMany(mappedBy = "allSkills", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<SkillEffectsMap> skillEffectsMapList;

    @Builder
    public AllSkills(
            Characters characters, SkillType skillType ,
            String skillName , String explain , String effect
    ){
        this.characters = characters;
        this.skillName = skillName;
        this.skillType = skillType;
        this.skillExplain = explain;
        this.effect = effect;
    }

}
